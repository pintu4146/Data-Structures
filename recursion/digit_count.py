class Solution:
    def helper(self, n, total_count):
        if n <= 0:
            return total_count
        return self.helper(n // 10, 1 + total_count)

    def countDigits(self, n):
        return self.helper(n, 0)
        # code here


sol = Solution()
print(sol.countDigits(12345))
