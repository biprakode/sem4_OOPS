# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write first seven Fibonacci numbers using generator next function/ yield in python.
# Trace and memorize the function. Also check whether a user given number is Fibonacci or not.

def recur_fibo(n, dp):
    # base case - first two fib numbers are themselves
    if n <= 1:
        yield n
        return n

    # if already computed, just hand it back
    if dp[n] != -1:
        yield dp[n]
        return dp[n]

    # otherwise compute both halves and memoize
    val1 = yield from recur_fibo(n - 1, dp)
    val2 = yield from recur_fibo(n - 2, dp)

    dp[n] = val1 + val2
    yield dp[n]
    return dp[n]


def simple_fibo():
    # infinite generator that keeps yielding fib numbers
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b


dp = []
gen = simple_fibo()
n = 20

# memo array for the recursive version
memo = [-1] * (n + 1)
gen2 = recur_fibo(20, memo)

# grab the first 19 fibs from the simple generator
fibos = []
for i in range(1, 20):
    fibos.append((next(gen)))

print(fibos)
print(list(gen2))
