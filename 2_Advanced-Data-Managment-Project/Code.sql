ROP TRIGGER IF EXISTS refresh_summary ON detailed;

DROP FUNCTION IF EXISTS refresh_summary_function();
DROP FUNCTION IF EXISTS make_full_name(VARCHAR, VARCHAR);

-- function to build full_name
CREATE FUNCTION make_full_name(first VARCHAR, last VARCHAR)
RETURNS VARCHAR AS $$
BEGIN
    RETURN CONCAT_WS(' ', first, last);
END;
$$ LANGUAGE plpgsql;

-- function to rebuild summary
CREATE FUNCTION refresh_summary_function()
RETURNS TRIGGER
AS $$
BEGIN
    DELETE FROM summary;

    INSERT INTO summary (full_name, email, customer_count)
    SELECT
        make_full_name(first_name, last_name),
        email,
        COUNT(*)
    FROM detailed
    GROUP BY first_name, last_name, email
    ORDER BY COUNT(*) DESC
    LIMIT 100;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

DROP TABLE IF EXISTS detailed;

CREATE TABLE detailed (
    customer_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    rental_id INT,
    rental_date TIMESTAMP,
    return_date TIMESTAMP
);

SELECT * FROM detailed;

DROP TABLE IF EXISTS summary;

CREATE TABLE summary (
    full_name VARCHAR(100),
    email VARCHAR(100),
    customer_count INT
);

SELECT * FROM summary;

-- insert into detailed
INSERT INTO detailed (
    customer_id,
    first_name,
    last_name,
    email,
    rental_id,
    rental_date,
    return_date
)
SELECT
    c.customer_id,
    c.first_name,
    c.last_name,
    c.email,
    r.rental_id,
    r.rental_date,
    r.return_date
FROM rental r
JOIN customer c
    ON c.customer_id = r.customer_id;

SELECT * FROM detailed;

CREATE TRIGGER refresh_summary
AFTER INSERT ON detailed
FOR EACH STATEMENT
EXECUTE FUNCTION refresh_summary_function();

SELECT trigger_name
FROM information_schema.triggers
WHERE event_object_table = 'detailed'
  AND trigger_name = 'refresh_summary';

-- test insert
INSERT INTO detailed(customer_id, first_name, last_name, email, rental_id, rental_date, return_date)
SELECT
    1,
    'Abdul',
    'Siddiq',
    'as@example.com',
    10000 + s,
    '2025-11-13',
    '2025-11-13'
FROM generate_series(1, 50) s;

SELECT * FROM detailed
WHERE customer_id = 1;

SELECT * FROM summary;

DROP PROCEDURE IF EXISTS refresh_tables();

-- procedure to reload detailed
CREATE PROCEDURE refresh_tables()
AS $$
BEGIN
    DELETE FROM detailed;

    INSERT INTO detailed (
        customer_id,
        first_name,
        last_name,
        email,
        rental_id,
        rental_date,
        return_date
    )
    SELECT
        c.customer_id,
        c.first_name,
        c.last_name,
        c.email,
        r.rental_id,
        r.rental_date,
        r.return_date
    FROM rental r
    JOIN customer c
        ON c.customer_id = r.customer_id;
END;
$$ LANGUAGE plpgsql;

CALL refresh_tables();

SELECT * FROM detailed
WHERE customer_id = 1;

SELECT * FROM summary;