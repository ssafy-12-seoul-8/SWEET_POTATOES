def check(a):
    x, y, z = a // 100, (a // 10) % 10, a % 10

    tmp = [x, y, z]
    if x == y or y == z or z == x:
        return False

    if x == 0 or y == 0 or z == 0:
        return False

    st = set([x, y, z])

    for i in range(N):
        s = 0
        b = 0
        a1, b1, c1 = arr[i][0] // 100, (arr[i][0] // 10) % 10, arr[i][0] % 10
        tmp2 = [a1, b1, c1]
        for j in range(3):
            if tmp[j] == tmp2[j]:
                s += 1
            elif tmp2[j] in st:
                b += 1

        if s != arr[i][1] or b != arr[i][2]:
            return False

    return True


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

cnt = 0
for i in range(100, 1000):
    if check(i):
        cnt += 1

print(cnt)
