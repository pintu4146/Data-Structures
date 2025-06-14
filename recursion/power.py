# gfg
class Solution:
    def power(self, base, pow):
        def helper(pow):
            if pow == 0:
                return 1
            return base * helper(pow - 1)

        return helper(pow)


print(Solution().power(9, 9))
