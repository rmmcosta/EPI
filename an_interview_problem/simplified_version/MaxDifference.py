def max_difference(arr):
    min_abs = arr[0]
    diff_abs = 0

    for i in range(1, len(arr)):
        if arr[i] < min_abs:
            min_abs = arr[i]
        else:
            diff_abs = max(diff_abs, arr[i] - min_abs)

    return max(diff_abs, local_max_difference(arr))


def local_max_difference(arr):
    if len(arr) < 2:
        return 0

    pivot = len(arr) // 2 - 1
    return max(
        local_max_difference(arr[:pivot + 1]),
        local_max_difference(arr[pivot + 1:])
    )


values = [3, 1, 2, 5, 10, 9, 4, 6, 7]
result = max_difference(values)
print("Maximum difference:", result)

values = [3, 10, 2, 5, 1, 9, 4, 6, 7]
result = max_difference(values)
print("Maximum difference:", result)