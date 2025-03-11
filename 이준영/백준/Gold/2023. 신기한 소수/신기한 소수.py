import math


def check_prime(n):
    tmp = int(math.sqrt(n))
    for i in range(2, tmp + 1):
        if n % i == 0:
            return False

    return True


N = int(input())
if N == 1:
    print(2, 3, 5, 7, sep="\n")
else:
    lst = [2, 3, 5, 7]

    for l in range(N - 1):
        tmp_lst = []
        for num in lst:
            for i in (1, 3, 5, 7, 9):
                tmp = num * 10 + i
                if check_prime(tmp):
                    tmp_lst.append(tmp)
        lst = tmp_lst

    lst.sort()
    for i in lst:
        print(i)
