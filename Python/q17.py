def flatten(d, parent_key='', sep='.'):
    items = []
    for k, v in d.items():
        key = f"{parent_key}{sep}{k}" if parent_key else k
        if isinstance(v, dict):
            items.extend(flatten(v, key, sep).items())
        else:
            items.append((key, v))
    return dict(items)

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

flat = flatten(nested)
for k, v in flat.items():
    print(f"{k}: {v}")
