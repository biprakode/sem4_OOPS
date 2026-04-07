from operator import itemgetter
from itertools import groupby

stocks1 = {
    'Reliance': 2500,
    'TCS': 3200,
    'Infosys': 1800,
    'HDFC': 2500,
    'Wipro': 800,
    'ITC': 450,
    'SBI': 500,
}

stocks2 = {
    'Reliance': 2600,
    'TCS': 3200,
    'HUL': 2100,
    'Wipro': 800,
    'Adani': 1500,
}

# min and max price
print("Min price:", min(stocks1.items(), key=itemgetter(1)))
print("Max price:", max(stocks1.items(), key=itemgetter(1)))

# sort by price
print("\nSorted by price:", sorted(stocks1.items(), key=itemgetter(1)))

# items only in first dict
only_in_1 = {k: stocks1[k] for k in stocks1.keys() - stocks2.keys()}
print("\nOnly in stocks1:", only_in_1)

# items whose prices don't match
mismatched = {k: (stocks1[k], stocks2[k]) for k in stocks1.keys() & stocks2.keys() if stocks1[k] != stocks2[k]}
print("Price mismatch:", mismatched)

# remove duplicates (items in stocks1 that also appear in stocks2 with same price)
deduped = {k: v for k, v in stocks1.items() if k not in stocks2 or stocks1[k] != stocks2[k]}
print("After removing duplicates:", deduped)

# sort both by increasing price
sorted1 = dict(sorted(stocks1.items(), key=itemgetter(1)))
sorted2 = dict(sorted(stocks2.items(), key=itemgetter(1)))
print("\nStocks1 sorted:", sorted1)
print("Stocks2 sorted:", sorted2)

# group by price in multiples of 500
def price_bucket(item):
    return (item[1] // 500) * 500

sorted_items = sorted(stocks1.items(), key=price_bucket)
print("\nGrouped by 500-multiples:")
for bucket, group in groupby(sorted_items, key=price_bucket):
    print(f"  {bucket}-{bucket+499}: {list(group)}")

# find item with price == 800 in both
target = 800
for name, d in [("stocks1", stocks1), ("stocks2", stocks2)]:
    matches = [k for k, v in d.items() if v == target]
    print(f"\nPrice=={target} in {name}: {matches if matches else 'not found'}")
