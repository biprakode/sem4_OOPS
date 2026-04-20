# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Create a dictionary that maps stock names to prices, which will keep insertion order.
# Find minimum price, maximum price and sort items according to their prices in first
# dictionary using itemgetter or lambda function. Create another second stock dictionary.
# Find items that are only in first dictionary and find items whose prices do not match.
# Remove duplicate items from first dictionary. Sort both dictionaries for incrementing
# prices. Group items in first dictionary by price in multiple of 500. Find an item with
# price=800 from both dictionaries.

from operator import itemgetter
from itertools import groupby

# first stock dict
stocks1 = {
    'Reliance': 2500,
    'TCS': 3200,
    'Infosys': 1800,
    'HDFC': 2500,
    'Wipro': 800,
    'ITC': 450,
    'SBI': 500,
}

# second stock dict for comparison work
stocks2 = {
    'Reliance': 2600,
    'TCS': 3200,
    'HUL': 2100,
    'Wipro': 800,
    'Adani': 1500,
}

# itemgetter(1) pulls the price out of each (name, price) tuple
print("Min price:", min(stocks1.items(), key=itemgetter(1)))
print("Max price:", max(stocks1.items(), key=itemgetter(1)))

# sort every stock by its price
print("\nSorted by price:", sorted(stocks1.items(), key=itemgetter(1)))

# keys that only exist in stocks1
only_in_1 = {k: stocks1[k] for k in stocks1.keys() - stocks2.keys()}
print("\nOnly in stocks1:", only_in_1)

# stocks present in both dicts but with different prices
mismatched = {k: (stocks1[k], stocks2[k]) for k in stocks1.keys() & stocks2.keys() if stocks1[k] != stocks2[k]}
print("Price mismatch:", mismatched)

# strip out entries whose (name, price) pair also sits in stocks2
deduped = {k: v for k, v in stocks1.items() if k not in stocks2 or stocks1[k] != stocks2[k]}
print("After removing duplicates:", deduped)

# sort both dictionaries by ascending price
sorted1 = dict(sorted(stocks1.items(), key=itemgetter(1)))
sorted2 = dict(sorted(stocks2.items(), key=itemgetter(1)))
print("\nStocks1 sorted:", sorted1)
print("Stocks2 sorted:", sorted2)


def price_bucket(item):
    # snap every price down to the nearest 500
    return (item[1] // 500) * 500


# group by 500-sized buckets
sorted_items = sorted(stocks1.items(), key=price_bucket)
print("\nGrouped by 500-multiples:")
for bucket, group in groupby(sorted_items, key=price_bucket):
    print(f"  {bucket}-{bucket+499}: {list(group)}")

# look for stocks priced exactly at 800 in both dicts
target = 800
for name, d in [("stocks1", stocks1), ("stocks2", stocks2)]:
    matches = [k for k, v in d.items() if v == target]
    print(f"\nPrice=={target} in {name}: {matches if matches else 'not found'}")
