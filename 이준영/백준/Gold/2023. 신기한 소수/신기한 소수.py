# 에라토스테네스의 체를 쓰기에는 최대 8자리까지 가능하기 때문에 시간이 너무 많이 든다.
# 따라서 순차적으로 늘려나가는 방식 채택
import math


def check_prime(n):                 # 소수인가
    tmp = int(math.sqrt(n))
    for i in range(2, tmp + 1):     # 루트n까지만 보면 된다.
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
            for i in (1, 3, 7, 9):  # 뒷자리에는 1,3,7,9만 올 수 있다.
                tmp = num * 10 + i
                if check_prime(tmp):# 소수면 저장하자
                    tmp_lst.append(tmp)
        lst = tmp_lst

    lst.sort()
    for i in lst:
        print(i)
