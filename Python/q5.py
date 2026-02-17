def recur_fibo(n , dp):
    if n<=1:
        yield n
        return n
    
    if dp[n] != -1:
        yield dp[n]
        return dp[n]
    
    val1 = yield from recur_fibo(n - 1, dp)
    val2 = yield from recur_fibo(n - 2, dp)
    
    dp[n] = val1 + val2
    yield dp[n]
    return dp[n]

def simple_fibo():
    a , b = 0 , 1
    while True:
        yield a
        a , b = b , a+b

dp = []
gen = simple_fibo()
n = 20
memo = [-1] * (n + 1)
gen2 = recur_fibo(20 , memo)
fibos = []
for i in range(1 , 20):
    fibos.append((next(gen)))
print(fibos)
print(list(gen2))