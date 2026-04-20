# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# CSS colors are defined using a hexadecimal (HEX) notation for the combination of Red,
# Green, and Blue color values (RGB). It must start with a '#' symbol. It can have 3 or 6
# digits. Each digit is in the range of 0 to F. You are given N<10 lines of CSS code. Your
# task is to print all valid Hex Color Codes, in order of their occurrence from top to
# bottom.

import re

# sample css block
css = """
body {
    background-color: #FfFdF8;
    font-size: 13px;
}
h1 {
    color: #E8D0A9;
    border-color: #B7AFA3;
}
p {
    color: #333;
    background: #1a2b3c;
}
#header {
    margin: 0;
    color: #abc;
}
"""

# '#' followed by exactly 3 or 6 hex digits - the lookahead stops us from matching
# longer weird sequences
colors = re.findall(r'#(?:[0-9a-fA-F]{6}|[0-9a-fA-F]{3})(?![0-9a-fA-F])', css)

print("Valid hex color codes found:")
for c in colors:
    print(c)
