# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Given an array of strings containing lowercase letters, the task is to find the size of
# the largest subset of words that are anagrams of each other. Two strings are said to be
# anagrams if they contain the same characters, only in a different order.

from collections import Counter

# sample input - some of these are anagrams of each other
words = ['listen', 'silent', 'enlist', 'hello', 'world', 'dog', 'god', 'inlets', 'tinsel']

# group words by their sorted-letters fingerprint
groups = Counter()
for w in words:
    key = ''.join(sorted(w))
    groups[key] += 1

# most_common returns the biggest group first
largest = groups.most_common(1)[0][1]

print(f"Words: {words}")
print(f"Largest anagram group size: {largest}")
