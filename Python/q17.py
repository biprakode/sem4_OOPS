# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Write a function that flattens a nested dictionary structure like one obtained from
# Twitter and Facebook APIs or from some JSON file.

def flatten(d, parent_key='', sep='.'):
    items = []
    # walk through every key/value and build a fully-qualified key
    for k, v in d.items():
        key = f"{parent_key}{sep}{k}" if parent_key else k
        if isinstance(v, dict):
            # recurse one level deeper and merge results back
            items.extend(flatten(v, key, sep).items())
        else:
            items.append((key, v))
    return dict(items)


# the sample nested record from the assignment
nested = {
    'fullname': 'Alessandra',
    'age': 41,
    'phone-numbers': ['+447421234567', '+447423456789'],
    'residence': {
        'address': {'first-line': 'Alexandra Rd', 'second-line': ''},
        'zip': 'N8 0PP',
        'city': 'London',
        'country': 'UK',
    },
}

# flatten and print nicely
flat = flatten(nested)
for k, v in flat.items():
    print(f"{k}: {v}")
