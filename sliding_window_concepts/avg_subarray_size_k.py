"""
💡 Problem:
Find the average of all contiguous subarrays of size k in the array.

Example:

Input: arr = [1, 3, 2, 6, -1, 4, 1, 8, 2], k = 5
Output: [2.2, 2.8, 3.6, 2.8, 2.4]
(Each number is the average of a window of 5 numbers)
"""


def avg_subarrays_brute_force_approach(arr, k):
    n = len(arr)
    avg_window = []
    for i in range(n-k+1):
        current_avg = sum(arr[i:i+k])/k
        avg_window.append(current_avg)
    print(avg_window)
    return avg_window


arr, k = [1, 3, 2, 6, -1, 4, 1, 8, 2], 5
avg_subarrays_brute_force_approach(arr, k)
