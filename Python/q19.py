# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Use profile/cprofile to check pythogorian triples code in python. Think about time
# complexity of the code.

import cProfile


def pythagorean_triples(limit):
    # O(n^2) - two nested loops, inner check is O(1) via perfect-square test
    triples = []
    for a in range(1, limit):
        for b in range(a, limit):
            # check if a^2 + b^2 is a perfect square <= limit
            c_sq = a * a + b * b
            c = int(c_sq ** 0.5)
            if c * c == c_sq and c <= limit:
                triples.append((a, b, c))
    return triples


# small demo output
print("Triples up to 30:")
for t in pythagorean_triples(30):
    print(t)

# use cProfile to see where the time actually goes
print("\nProfiling with limit=500:")
cProfile.run('pythagorean_triples(500)')
