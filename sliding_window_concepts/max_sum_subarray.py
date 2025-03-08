def max_su_subarray_brute_force(arr, k):
    max_sum = float('-inf')
    n = len(arr)
    for i in range(n - k + 1):
        current_sum = sum(arr[i: i + k])

        # current_sum = 0
        # for j in range(i, i + k):
        #     current_sum += arr[j]
        max_sum = max(max_sum, current_sum)
        print(f"window: {i}, current sum: {current_sum}, max sum so far: {max_sum}")
    return max_sum


def optimised_max_sum_sub_array(arr, k):
    left, right = 0, k - 1
    n = len(arr)
    current_sum = sum(arr[left: right])
    max_sum = float('-inf')
    while right < n-1:
        max_sum = max(current_sum, max_sum)
        current_sum -= arr[left]
        left += 1
        right += 1
        current_sum += arr[right]
    return max_sum


if __name__ == '__main__':
    arr = [2, 1, 5, 1, 3, 8]
    k = 3
    print(max_su_subarray_brute_force(arr, k))
    print(f"optimised using sliding window: {optimised_max_sum_sub_array(arr, k)}")
