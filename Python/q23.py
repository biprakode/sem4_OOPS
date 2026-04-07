import re

# single regex for valid Roman numerals 1-3999
pattern = r'^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$'

tests = ['MCMXCIV', 'MMMCMXCIX', 'III', 'IV', 'IIII', '', 'ABC', 'MMMMM', 'XLII', 'DCCCXC']

for s in tests:
    valid = bool(re.match(pattern, s)) and len(s) > 0  # empty string must fail
    print(f"{s!r:15} -> {'valid' if valid else 'invalid'}")
