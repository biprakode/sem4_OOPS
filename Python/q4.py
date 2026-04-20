# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a regular expression to validate a phone number.

import re

number = "7980759044"
# a basic 10-digit indian-style number check
pattern = r"^\d{10}$"

if re.match(pattern, number):
    print("Valid number")
else:
    print("Not a valid number")
