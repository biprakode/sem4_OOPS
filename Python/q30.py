# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Given two numbers N and K, the task is to print a number series where each term is
# obtained by repeatedly subtracting K from N until the number becomes zero or negative
# and once it becomes zero or negative, we start adding K back until the number reaches
# the original value N again. You must do this without using any loop.
# Input: N = 15, K = 5
# Output: 15 10 5 0 -5 0 5 10 15
# Input: N = 20, K = 6
# Output: 20 14 8 2 -4 2 8 14 20

def down(n, k, current):
    # print the current value on the way down
    print(current, end=' ')
    nxt = current - k
    # keep subtracting while positive, then flip to the "up" side
    if nxt > 0:
        down(n, k, nxt)
    else:
        print(0, end=' ')
        up(n, k, 0)


def up(n, k, current):
    # print and add k until we hit the original n
    nxt = current + k
    if nxt >= n:
        print(n)
    else:
        print(nxt, end=' ')
        up(n, k, nxt)


# two sample runs for different n and k
print("N=15, K=5:")
down(15, 5, 15)
print("\nN=20, K=6:")
down(20, 6, 20)
