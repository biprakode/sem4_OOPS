s = "this_is_a_snake_case_string"

words = s.split('_')

pascal = ''.join(w.capitalize() for w in words)
camel = words[0] + ''.join(w.capitalize() for w in words[1:])
kebab = '-'.join(words)

print(f"snake_case:  {s}")
print(f"PascalCase:  {pascal}")
print(f"camelCase:   {camel}")
print(f"kebab-case:  {kebab}")
