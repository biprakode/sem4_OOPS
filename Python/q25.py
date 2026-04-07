import re

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

# find all valid hex colors: # followed by exactly 3 or 6 hex digits
# negative lookahead ensures we don't match longer sequences
colors = re.findall(r'#(?:[0-9a-fA-F]{6}|[0-9a-fA-F]{3})(?![0-9a-fA-F])', css)

print("Valid hex color codes found:")
for c in colors:
    print(c)
