def check(y, x, d1, d2):
    global mn

    sm1 = sm2 = sm3 = sm4 = sm5 = 0
    for i in range(y - d1):
        for j in range(x + d1 + 1):
            sm1 += arr[i][j]
        for j in range(x + d1 + 1, N):
            sm2 += arr[i][j]

    for i in range(y - d1, y):
        for j in range(y + x - i):
            sm1 += arr[i][j]

    for i in range(y - d1, y + d2 - d1 + 1):
        for j in range(i + x - y + 2 * d1 + 1, N):
            sm2 += arr[i][j]

    for i in range(y, y + d2 + 1):
        for j in range(x + i - y):
            sm4 += arr[i][j]

    for i in range(y + d2 - d1 + 1, y + d2 + 1):
        for j in range(y + x + 2 * d2 - i + 1, N):
            sm3 += arr[i][j]

    for i in range(y + d2 + 1, N):
        for j in range(x + d2):
            sm4 += arr[i][j]
        for j in range(x + d2, N):
            sm3 += arr[i][j]

    sm5 = tot - (sm1 + sm2 + sm3 + sm4)

    lst = sorted([sm1, sm2, sm3, sm4, sm5])

    mn = min(mn, lst[4] - lst[0])


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

mn = 40001
tot = sum(map(sum, arr))
for i in range(N):
    for j in range(N):
        for d1 in range(1, min(i, N - 2 - j) + 1):
            for d2 in range(1, min(N - 1 - j - d1, N - 1 - i, N - 2 - j) + 1):
                check(i, j, d1, d2)
print(mn)
