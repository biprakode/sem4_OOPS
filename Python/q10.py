import time

i = 0
a = 2
q = 1
term = a
start_time = time.time()
total_loop_time = 0
while(True):
    loop_time = time.time()
    if(i > 10e6):
        break
    term = term * (q ** i)
    end_loop_time = time.time()
    total_loop_time += (end_loop_time - loop_time)
    i+=1
end_time = time.time()
elapsed_time = end_time - start_time
print("Elapsed time:", elapsed_time, "seconds")
print("Average loop time:", total_loop_time / i)