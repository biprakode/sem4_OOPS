import time

i = 0
a = 2
q = 1
term = a
start_time = time.time()
while(True):
    if(i > 10e6):
        break
    term = term * (q ** i)
    i+=1
end_time = time.time()
elapsed_time = end_time - start_time
print("Elapsed time:", elapsed_time, "seconds")