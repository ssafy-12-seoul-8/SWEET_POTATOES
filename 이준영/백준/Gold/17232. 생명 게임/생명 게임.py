N, M, T = map(int, input().split())
K, a, b = map(int, input().split())

arr = [list(input()) for _ in range(N)]

for _ in range(T):
    tmp_arr = [["."] * M for _ in range(N)]
    dp = [[0] * (M + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if arr[i - 1][j - 1] == "*":
                cnt = 1
            else:
                cnt = 0
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + cnt

    for i in range(N):
        for j in range(M):
            ly = max(0, i - K)
            lx = max(0, j - K)
            ry = min(N - 1, i + K)
            rx = min(M - 1, j + K)
            cnt = dp[ry + 1][rx + 1] - dp[ry + 1][lx] - dp[ly][rx + 1] + dp[ly][lx]

            if arr[i][j] == "*" and a <= cnt - 1 <= b:
                tmp_arr[i][j] = "*"
            elif arr[i][j] == "." and a < cnt <= b:
                tmp_arr[i][j] = "*"

    arr = tmp_arr
for i in range(N):
    print(*arr[i], sep="")
