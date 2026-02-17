import re

number = "7980759044"
pattern = r"^\d{10}$"
if re.match(pattern , number):
    print("Valid number")
else:
    print("Not a valid number")