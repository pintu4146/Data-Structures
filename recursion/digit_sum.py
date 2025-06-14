class Solution:
    def helper(self, n, digit_sum):
        if n <= 0:
            return digit_sum
        return self.helper(n // 10, digit_sum + n % 10)

    def sumOfDigits(self, n):
        return self.helper(n, 0)
        # code here


sol = Solution()
print(sol.sumOfDigits(99999))
