# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Quicksort is one of the most efficient sorting algorithms and is commonly implemented
# using recursion. However, recursion can cause stack overflow errors when dealing with
# very large datasets. To overcome this, we can use an iterative version of Quicksort that
# replaces recursive calls with an explicit stack to manage subarrays. Implement it.

def quicksort(arr):
    # explicit stack of (lo, hi) ranges to process instead of recursive calls
    stack = [(0, len(arr) - 1)]
    while stack:
        lo, hi = stack.pop()
        # nothing to sort in a range of 0 or 1 elements
        if lo >= hi:
            continue
        # standard Lomuto partition using the last element as pivot
        pivot = arr[hi]
        i = lo
        for j in range(lo, hi):
            if arr[j] <= pivot:
                arr[i], arr[j] = arr[j], arr[i]
                i += 1
        arr[i], arr[hi] = arr[hi], arr[i]
        # push both subranges so they get sorted later
        stack.append((lo, i - 1))
        stack.append((i + 1, hi))
    return arr


data = [38, 27, 43, 3, 9, 82, 10]
print("Before:", data)
quicksort(data)
print("After: ", data)
