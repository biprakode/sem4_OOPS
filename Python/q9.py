# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Enumerate the sequence of all lowercase ASCII letters, starting from 1, using enumerate.

# walk over the ASCII table and keep only the lowercase letters
for index, char in enumerate(range(255)):
    if char >= ord('a') and char <= ord('z'):
        # shift the index so 'a' comes out as 0, 'b' as 1, etc.
        print((index - ord('a'), chr(char)))
