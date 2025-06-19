

# def first_largets(nums):
#     first = -1
#     for ele, idx in enumerate(nums):
#         if ele > first:
#             first = idx
#     return first

def second_largest(nums: list) -> int:
    # [1,2,3,4,5]
    f = s = float('-inf')
    for ele in nums:
        if ele > f:
            s = f
            f = ele
        elif f > ele > s:
            s = ele
    return s




print(second_largest([1, 11,-10,34,-13,100]))
