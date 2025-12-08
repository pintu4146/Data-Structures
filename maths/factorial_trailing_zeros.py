def factorial_trailing_zeros(n: int) -> int:
    def factorial(n):
        if n==1 or n==0:
            return 1
        fact = n* factorial(n-1)
        print(n, fact, sep='->')
        return fact
    return factorial(25)
    



print(factorial_trailing_zeros(10))
