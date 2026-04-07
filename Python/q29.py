def quicksort(arr):
    stack = [(0, len(arr) - 1)]
    while stack:
        lo, hi = stack.pop()
        if lo >= hi:
            continue
        pivot = arr[hi]
        i = lo
        for j in range(lo, hi):
            if arr[j] <= pivot:
                arr[i], arr[j] = arr[j], arr[i]
                i += 1
        arr[i], arr[hi] = arr[hi], arr[i]
        stack.append((lo, i - 1))
        stack.append((i + 1, hi))
    return arr

data = [38, 27, 43, 3, 9, 82, 10]
print("Before:", data)
quicksort(data)
print("After: ", data)
