print("Hello Welcome to the BMI Calculator")

feet = int(input("Feet? "))
inches = int(input("Inches? "))
weight = int(input("Weight? "))

cm = feet * 12 + inches #Converts Ft to in

sum = weight / (cm**2) * 703 #Creates bmi
round_sum = round(sum,1)

if (round_sum) < 18.5:
    print("Underweight. ")

elif (round_sum) < 24.9:
    print("Healthy")

elif (round_sum) < 29.9:
    print("Overweight")

elif (round_sum) > 30:
    print("Obese")
