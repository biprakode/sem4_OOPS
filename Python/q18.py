import pytest

@pytest.mark.parametrize("a, b, expected", [
    (2, 2, 4),
    (2, 3, 8),
    (1, 9, 1),
    (0, 9, 0),
])
def test_power(a, b, expected):
    assert pow(a, b) == expected

if __name__ == '__main__':
    pytest.main([__file__, '-v'])
