# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Make a list of the largest or smallest N items in a collection.

import heapq

nums = [34, 1, 78, 2, 56, 99, 12, 45, 67, 23]

# heapq has ready made helpers for top/bottom N
print("List:", nums)
print("3 largest:", heapq.nlargest(3, nums))
print("3 smallest:", heapq.nsmallest(3, nums))

# works with dicts too - pass a key function
portfolio = [
    {'name': 'AAPL', 'price': 543},
    {'name': 'GOOG', 'price': 891},
    {'name': 'TSLA', 'price': 230},
    {'name': 'MSFT', 'price': 410},
]
print("\n2 cheapest stocks:", heapq.nsmallest(2, portfolio, key=lambda s: s['price']))
print("2 priciest stocks:", heapq.nlargest(2, portfolio, key=lambda s: s['price']))
