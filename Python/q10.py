# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a code which yields all terms of the geometric progression a, aq, aq^2, aq^3, ....
# When the progression produces a term that is greater than 100,000, the generator stops
# (with a return statement). Compute total time and time within the loop.

import time

# starting values for the gp
i = 0
a = 2
q = 2
term = a

start_time = time.time()
total_loop_time = 0

# keep multiplying until we cross the 10e6 ceiling
while (True):
    loop_time = time.time()
    if (term > 10e6):
        break
    # each term multiplies by q raised to the running exponent
    term = term * (q ** i)
    end_loop_time = time.time()
    total_loop_time += (end_loop_time - loop_time)
    i += 1

end_time = time.time()
elapsed_time = end_time - start_time

# dump the timing stats
print("Elapsed time:", elapsed_time, "seconds")
print("Average loop time:", total_loop_time / i)
