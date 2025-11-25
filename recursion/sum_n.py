def sum_n(n: int) -> int:
    """
    approach to head recussion to find the sum
    :param total_sum: can be int or None
    :param n: integer
    :return: total sum
    
    """
    # base cases
    if n == 1:
        return 1
    res = n + sum_n(n - 1)
    print(res)
    return res


print(f'{sum_n(5) = }')
