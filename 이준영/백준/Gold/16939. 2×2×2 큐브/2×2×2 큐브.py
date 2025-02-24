# 돌린다면 8개의 칸이 2칸씩 가는 꼴이다.
# 이를 미리 저장해 놓으면 될 것 같다.
# 앞뒤로 돌리는게 가능한데 이를 그냥 한번 돌리고 2번 추가 돌리는 걸로 하였다.
# 물론 이렇게 짜면 상태가 같은게 생기지만 (왼쪽을 앞으로 돌리나, 오른쪽을 뒤로 돌리나..) 그냥 무시하고 했다.
def rotate(a):
    b = arr[:]
    tmp1 = b[d[a][6]]
    tmp2 = b[d[a][7]]

    for i in range(7, 1, -1):
        b[d[a][i]] = b[d[a][i - 2]]

    b[d[a][0]] = tmp1
    b[d[a][1]] = tmp2

    res1 = check(b)

    for i in range(4):
        b[d[a][i]], b[d[a][i + 4]] = b[d[a][i + 4]], b[d[a][i]]

    res2 = check(b)

    return res1 + res2


def check(b):
    res = 1
    for i in range(6):
        for j in range(1, 4):
            if b[i * 4 + j] != b[i * 4]:
                res = 0

    return res


arr = list(map(int, input().split()))

# 돌릴 수 있는 축 6가지
d = [[12, 13, 4, 5, 16, 17, 20, 21],
     [14, 15, 6, 7, 18, 19, 22, 23],
     [0, 2, 4, 6, 8, 10, 23, 21],
     [1, 3, 5, 7, 9, 11, 22, 20],
     [3, 2, 13, 15, 8, 9, 18, 16],
     [1, 0, 12, 14, 10, 11, 19, 17]]



flag = 0

for i in range(6):
    flag = flag + rotate(i)

if flag >= 1:
    print(1)

else:
    print(0)
