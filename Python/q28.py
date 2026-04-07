from collections import Counter

words = ['listen', 'silent', 'enlist', 'hello', 'world', 'dog', 'god', 'inlets', 'tinsel']

groups = Counter()
for w in words:
    key = ''.join(sorted(w))
    groups[key] += 1

largest = groups.most_common(1)[0][1]
print(f"Words: {words}")
print(f"Largest anagram group size: {largest}")
