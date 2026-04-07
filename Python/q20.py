import os

SAMPLE = "sample_input_q20.txt"

# create sample file if it doesn't exist
if not os.path.exists(SAMPLE):
    with open(SAMPLE, 'w') as f:
        f.write("the cat sat on the mat\n")
        f.write("the dog ate my homework\n")
        f.write("I sat on a cat\n")

with open(SAMPLE) as f:
    lines = [line.strip().split() for line in f]

# map each unique token to a unique integer
vocab = {}
counter = 0
for tokens in lines:
    for t in tokens:
        if t not in vocab:
            vocab[t] = counter
            counter += 1

print("Vocabulary:", vocab)

# convert lines to integer sequences
encoded = [[vocab[t] for t in tokens] for tokens in lines]
print("\nEncoded (before padding):", encoded)

# pad all lines to length of longest
max_len = max(len(row) for row in encoded)
padded = [row + [0] * (max_len - len(row)) for row in encoded]

print(f"\nPadded to length {max_len}:")
for row in padded:
    print(row)
