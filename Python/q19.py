import cProfile

def pythagorean_triples(limit):
    # O(n^2) — two nested loops, inner check is O(1) via perfect-square test
    triples = []
    for a in range(1, limit):
        for b in range(a, limit):
            c_sq = a * a + b * b
            c = int(c_sq ** 0.5)
            if c * c == c_sq and c <= limit:
                triples.append((a, b, c))
    return triples

print("Triples up to 30:")
for t in pythagorean_triples(30):
    print(t)

print("\nProfiling with limit=500:")
cProfile.run('pythagorean_triples(500)')
