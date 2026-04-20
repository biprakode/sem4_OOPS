# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# You are given a string, and you have to validate whether it's a valid Roman numeral.
# If it is valid, print True. Otherwise, print False. Try to create a regular expression
# for a valid Roman numeral. The number will be between 1 and 3999 (both included).

import re

# single regex covering Roman numerals 1-3999
# - up to three M's for thousands
# - CM/CD for 900/400, optional D and up to three C's for hundreds
# - similar for tens (XC/XL/...)
# - similar for ones (IX/IV/...)
pattern = r'^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$'

tests = ['MCMXCIV', 'MMMCMXCIX', 'III', 'IV', 'IIII', '', 'ABC', 'MMMMM', 'XLII', 'DCCCXC']

for s in tests:
    # regex matches empty string, so explicitly reject it
    valid = bool(re.match(pattern, s)) and len(s) > 0
    print(f"{s!r:15} -> {'valid' if valid else 'invalid'}")
