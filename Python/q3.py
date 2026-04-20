# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Print first 10 odd and even numbers using iterators and compress.
# You can use duck typing.

from itertools import compress


def mask_numbers(array: list[int], mask: list[int]) -> list[int]:
    # compress keeps only those items where mask is truthy
    return list(compress(array, mask))


# alternating True/False patterns act like picking even / odd positions
even = [False, True] * 10
odd = [True, False] * 10
numbers = list(range(20))

# print first ten odds and first ten evens
print(mask_numbers(numbers, odd))
print(mask_numbers(numbers, even))
