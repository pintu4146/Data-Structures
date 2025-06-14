
def print_n_2_1(integer: int ) -> None:
    """
    init approach is to think about the bases cases when func gets first args print and will call func with decreased
    args and BASE CASE 1. when function will return nothing
    :param integer:
    :return: None
    """
    print(integer)
    if integer == 1:
        return
    print_n_2_1(integer - 1)



print_n_2_1(5)
