def sum_n_params(n: int, total_sum) -> int:
    """

    :param n: integer value provide to sum upto
    :param total_sum: total sum in intermediate recursion
    :return: total sum of the numbers
    """
    if n == 0:
        return total_sum
    return sum_n_params(n - 1, n + total_sum)


print(sum_n_params(4, 0))
