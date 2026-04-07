import re

# sample input
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
    for row in grid:
        if c < len(row):
            raw += row[c]

print("Raw:", repr(raw))

# replace any run of non-alphanumeric chars between two alphanumeric chars with a single space
decoded = re.sub(r'(?<=[A-Za-z0-9])[^A-Za-z0-9]+(?=[A-Za-z0-9])', ' ', raw)
print("Decoded:", decoded)
