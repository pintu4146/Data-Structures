class Solution:
    def print_nos(self, n):
        # base case
        if n == 0:
            return
        self.print_nos(n - 1)
        print(n, end=' ')


solution = Solution()
solution.print_nos(10)
