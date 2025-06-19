from typing import List


def subset(nums: list) -> List:
    result = []

    def backtrack(index: int, path: list) -> None:
        if index == len(nums):
            result.append(path[:])
            return
        path.append(nums[index])
        backtrack(index + 1, path)
        path.pop()
        # ignore
        backtrack(index + 1, path)
    backtrack(0, [])

    return result


_nums = [1, 2]
print(subset(_nums))
