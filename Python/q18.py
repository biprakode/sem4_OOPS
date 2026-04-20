# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Use parameterized or nose_parameterized to compute power of following values:
# (2, 2, 4), (2, 3, 8), (1, 9, 1), (0, 9, 0). Use pytest to check errors.

import pytest


# parametrize feeds one tuple at a time into the test function
@pytest.mark.parametrize("a, b, expected", [
    (2, 2, 4),
    (2, 3, 8),
    (1, 9, 1),
    (0, 9, 0),
])
def test_power(a, b, expected):
    # pow() is the built-in exponent function
    assert pow(a, b) == expected


if __name__ == '__main__':
    # run pytest on just this file with verbose output
    pytest.main([__file__, '-v'])
