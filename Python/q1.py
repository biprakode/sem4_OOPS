import math
import json
k = int(input("Enter lower limit:- "))
x = int(input("Enter upper limit:- "))
D = {}
P = []
if k <= 2 or x < k:
    print("Invalid")
for a in range(k, x+1):
    b=a
    isPrime = True
    factors = []
    for i in range(2, int(math.sqrt(b))+3):
        if b % i == 0:
            isPrime = False
            factors.append(i)

    if isPrime:
        P.append(a)
    else:
        D[a] = factors

print("not prime + factors " , json.dumps(D,indent = 2))
print("Prime " , P)