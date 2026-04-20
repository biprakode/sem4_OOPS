# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# There is a complex matrix script. The matrix script is an X grid of strings. It consists
# of alphanumeric characters, spaces and symbols (!,@,#,$,%,&). If there are symbols or
# spaces between two alphanumeric characters of the decoded script, then replace them with
# a single space '' for better readability. Alphanumeric characters consist of:
# [A-Z, a-z, and 0-9]. 0<N, M<100. Print the decoded matrix script.

import re

# sample input grid
grid = [
    "Tsi",
    "h%x",
    "i #",
    "sM ",
    " $i",
    "a]s",
    " n!",
    "c e",
]

# read column by column (top to bottom, left to right)
cols = len(grid[0]) if grid else 0
raw = ''
for c in range(cols):
    # glue every character in the c-th column
    for row in grid:
        if c < len(row):
            raw += row[c]

print("Raw:", repr(raw))

# replace any run of non-alphanumeric chars that sits between two alphanumeric chars
# with a single space - only interior gaps count
decoded = re.sub(r'(?<=[A-Za-z0-9])[^A-Za-z0-9]+(?=[A-Za-z0-9])', ' ', raw)
print("Decoded:", decoded)
