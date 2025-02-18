def star(N):
    if N == 3:
        return [["*", "*", "*"],
                ["*", " ", "*"],
                ["*", "*", "*"]]

    arr2 = star(N // 3)
    res = [[" "] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if not (N // 3 <= i < N // 3 * 2 and N // 3 <= j < N // 3 * 2):
                res[i][j] = arr2[i % (N // 3)][j % (N // 3)]

    return res


N = int(input())

ans = star(N)

for i in range(N):
    print(*ans[i], sep="")
