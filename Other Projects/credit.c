#include <cs50.h>
#include <math.h>
#include <stdio.h>
int number_of_digits(long card_number);
int multiply_sum(int last_digit);
int sum_digits(long card_number);
bool valid_amex(int num_digits, long card_number);
bool valid_mastercard(int num_digits, long card_number);
bool valid_visa(int num_digits, long card_number);

int main(void)
{
    long card_number = get_long("CARD NUMBER:");
    int num_digits = number_of_digits(card_number);
    int sum = sum_digits(card_number);
    bool amex = valid_amex(num_digits, card_number);
    bool mastercard = valid_mastercard(num_digits, card_number);
    bool visa = valid_visa(num_digits, card_number);

    if (sum % 10 != 0)
    {
        printf("INVALID\n");
    }
    else if (amex == true)
    {
        printf("AMEX\n");
    }
    else if (mastercard == true)
    {
        printf("MASTERCARD\n");
    }
    else if (visa == true)
    {
        printf("VISA\n");
    }
    else
    {
        printf("INVALID\n");
    }
}
bool valid_amex(int num_digits, long card_number)
{
    int first_two_digits = card_number / pow(10, 13);
    if ((num_digits == 15) && (first_two_digits == 34 || first_two_digits == 37))
    {
        return true;
    }
    return false;
}
bool valid_mastercard(int num_digits, long card_number)
{

    int first_two_digits = card_number / pow(10, 14);
    if ((num_digits == 16) && (first_two_digits < 56 && first_two_digits > 50))
    {
        return true;
    }
    return false;
}
bool valid_visa(int num_digits, long card_number)
{
    if (num_digits == 13)
    {
        int first_number = card_number / pow(10, 12);
        if (first_number == 4)
        {
            return true;
        }
    }
    if (num_digits == 16)
    {
        int first_number = card_number / pow(10, 15);
        if (first_number == 4)
        {
            return true;
        }
    }
    return false;
}
int number_of_digits(long card_number)
{
    int count = 0;
    while (card_number > 0)
    {
        card_number = card_number / 10;
        count++;
    }
    return count;
}

int sum_digits(long card_number)
{
    int sum = 0;
    bool alternate_digit = false;
    while (card_number > 0)
    {
        if (alternate_digit == true)
        {
            int last_digit = card_number % 10;
            int product = multiply_sum(last_digit);
            sum = sum + product;
        }
        else
        {
            int last_digit = card_number % 10;
            sum = sum + last_digit;
        }
        alternate_digit = !alternate_digit;
        card_number = card_number / 10;
    }
    return sum;
}
int multiply_sum(int last_digit)
{
    int sum = 0;
    int multiply = last_digit * 2;
    while (multiply > 0)
    {
        int multiply_last_digit = multiply % 10;
        sum = sum + multiply_last_digit;
        multiply = multiply / 10;
    }
    return sum;
}
