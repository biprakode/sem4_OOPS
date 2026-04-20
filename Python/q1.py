# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a prime generator program using only primes and using python loops.

import math
import json

# take range from user
k = int(input("Enter lower limit:- "))
x = int(input("Enter upper limit:- "))

# D will store non-primes with their factors, P will hold the primes
D = {}
P = []

# simple sanity check so weird ranges are caught early
if k <= 2 or x < k:
    print("Invalid")

# walk through every number in the given range
for a in range(k, x+1):
    b = a
    isPrime = True
    factors = []
    # only need to check divisors up to sqrt(n)
    for i in range(2, int(math.sqrt(b))+3):
        if b % i == 0:
            isPrime = False
            factors.append(i)

    # park the number into the right bucket
    if isPrime:
        P.append(a)
    else:
        D[a] = factors

# show everything at the end
print("not prime + factors ", json.dumps(D, indent=2))
print("Prime ", P)
