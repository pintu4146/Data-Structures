def count_factors(n: int) -> list:
    res = set()
    for i in range(1, int(n**.5)+1):
        if n%i ==0:
            res.add(i)
            res.add(n//i)
    return sorted(res)


print(count_factors(10))