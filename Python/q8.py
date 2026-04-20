# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Create a list of all the numbers up to N=50 which are multiples of five using
# anonymous function.

# all numbers from 1 to 50
numbers = list(range(1, 51))

# lambda does the "is this a multiple of 5" test
multiples = list(filter(lambda x: x % 5 == 0, numbers))
print(multiples)
