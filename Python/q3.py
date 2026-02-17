from itertools import compress

def mask_numbers(array : list[int] , mask : list[int] ) -> list[int]:
    return list(compress(array , mask))

even = [False , True] * 10
odd = [True , False] * 10
numbers = list(range(20))

print(mask_numbers(numbers, odd))
print(mask_numbers(numbers, even))