# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Convert Snake case to Pascal case, camel case and kebab case.

s = "this_is_a_snake_case_string"

# split on underscore to grab the individual words
words = s.split('_')

# PascalCase: every word capitalised and glued together
pascal = ''.join(w.capitalize() for w in words)

# camelCase: first word kept lowercase, rest capitalised
camel = words[0] + ''.join(w.capitalize() for w in words[1:])

# kebab-case: words joined by hyphens
kebab = '-'.join(words)

print(f"snake_case:  {s}")
print(f"PascalCase:  {pascal}")
print(f"camelCase:   {camel}")
print(f"kebab-case:  {kebab}")
