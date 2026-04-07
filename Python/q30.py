def down(n, k, current):
    print(current, end=' ')
    nxt = current - k
    if nxt > 0:
        down(n, k, nxt)
    else:
        print(0, end=' ')
        up(n, k, 0)

def up(n, k, current):
    nxt = current + k
    if nxt >= n:
        print(n)
    else:
        print(nxt, end=' ')
        up(n, k, nxt)

print("N=15, K=5:")
down(15, 5, 15)
print("\nN=20, K=6:")
down(20, 6, 20)
