# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a python program to
#   i. read lines from a file, break into tokens and convert the tokens to unique
#      numerical values using python dictionary.
#  ii. Convert lines of different lengths into lines of same length (maximum length).
#      Use padding if and when required.

import os

SAMPLE = "sample_input_q20.txt"

# read the file line by line and tokenize each line on whitespace
with open(SAMPLE) as f:
    lines = [line.strip().split() for line in f]

# map each unique token to a fresh integer id
vocab = {}
counter = 0
for tokens in lines:
    for t in tokens:
        if t not in vocab:
            vocab[t] = counter
            counter += 1

print("Vocabulary:", vocab)

# turn every line into a list of integer ids
encoded = [[vocab[t] for t in tokens] for tokens in lines]
print("\nEncoded (before padding):", encoded)

# pad shorter lines with 0 so every row is the same length
max_len = max(len(row) for row in encoded)
padded = [row + [0] * (max_len - len(row)) for row in encoded]

print(f"\nPadded to length {max_len}:")
for row in padded:
    print(row)
