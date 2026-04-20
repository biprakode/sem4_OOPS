# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a python program to identify and extract numerical chunks from a text file and
# convert them into words; e.g.; 1992 -> "nineteen hundred and ninety two".

import re
import os

# look-up tables for the classic english number-to-word conversion
ones = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine',
        'ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen',
        'seventeen', 'eighteen', 'nineteen']
tens = ['', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']


def int_to_words(n):
    # handle the special cases first
    if n == 0:
        return 'zero'
    if n < 0:
        return 'minus ' + int_to_words(-n)

    parts = []
    # break the number into thousand/hundred/tens/ones chunks
    if n >= 1000:
        parts.append(ones[n // 1000] + ' thousand')
        n %= 1000
    if n >= 100:
        parts.append(ones[n // 100] + ' hundred')
        n %= 100
    if n >= 20:
        word = tens[n // 10]
        if n % 10:
            # glue the ones place with a hyphen (e.g. twenty-one)
            word += '-' + ones[n % 10]
        parts.append(word)
    elif n > 0:
        parts.append(ones[n])
    return ' '.join(parts)


# make sure we have something to work with
SAMPLE = "sample_input_q21.txt"
if not os.path.exists(SAMPLE):
    with open(SAMPLE, 'w') as f:
        f.write("Born in 1992, graduated in 2014.\nRoom 404 has 3 chairs.\n")

with open(SAMPLE) as f:
    text = f.read()

print("Original:", text)


def replace_num(m):
    # callback that turns the matched digits into words
    return int_to_words(int(m.group()))


# swap every standalone number for its word version
result = re.sub(r'\b\d+\b', replace_num, text)
print("Converted:", result)
