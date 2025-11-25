class Solution:
    def helper(self, n, total_count):
        if n <= 0:
            return total_count
        return self.helper(n // 10, 1 + total_count)

    def countDigits(self, n):
        return self.helper(n, 0)



sol = Solution()
print(sol.countDigits(12345))
# The solution uses tail recursion to count digits.
# Time Complexity: O(log10(n)) because we divide n by 10 in each step.
# Space Complexity: O(log10(n)) due to the recursion stack depth.
