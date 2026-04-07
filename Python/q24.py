import re

def first_repeat(s):
    m = re.search(r'([A-Za-z0-9])\1+', s)
    if m:
        print("group():", m.group())
        print("groups():", m.groups())
        # groupdict with named version
        m2 = re.search(r'(?P<char>[A-Za-z0-9])\1+', s)
        print("groupdict():", m2.groupdict())
        return m.group(1)
    return -1

tests = ["..12345678910111213141516171819202122232425...",
         "abcdeef",
         "abcdef"]

for t in tests:
    print(f"\nInput: {t!r}")
    result = first_repeat(t)
    print(f"Result: {result}")
