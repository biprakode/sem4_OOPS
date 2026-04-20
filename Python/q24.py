# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# You are given a string. Your task is to find the first occurrence of an alphanumeric
# character (read from left to right) that has consecutive repetitions using Group(),
# Groups() and Groupdict().

import re


def first_repeat(s):
    # capture any alnum char and demand it repeats immediately after
    m = re.search(r'([A-Za-z0-9])\1+', s)
    if m:
        # show what the built-in match helpers give us
        print("group():", m.group())
        print("groups():", m.groups())
        # named version so groupdict has something to show
        m2 = re.search(r'(?P<char>[A-Za-z0-9])\1+', s)
        print("groupdict():", m2.groupdict())
        return m.group(1)
    return -1


tests = ["..12345678910111213141516171819202122232425...",
         "abcdeef",
         "abcdef"]

# run the helper over each test string
for t in tests:
    print(f"\nInput: {t!r}")
    result = first_repeat(t)
    print(f"Result: {result}")
