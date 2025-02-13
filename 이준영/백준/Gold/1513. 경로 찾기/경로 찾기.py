N, M, C = map(int, input().split())
dp = [[{} for _ in range(M + 1)] for _ in range(N + 1)]

mod = 1_000_007
arcade = {}

for i in range(C):
    a, b = map(int, input().split())
    arcade[(a, b)] = i

if (1, 1) in arcade:
    start = arcade[(1, 1)]
    dp[1][1][(start, 1)] = 1
else:
    dp[1][1][(-1, 0)] = 1

for i in range(1, N + 1):
    for j in range(1, M + 1):
        for y, x in ((i - 1, j), (i, j - 1)):
            for s, cnt in dp[y][x]:
                tot = dp[y][x][(s, cnt)]

                if (i, j) not in arcade:
                    if (s, cnt) in dp[i][j]:
                        dp[i][j][(s, cnt)] = (dp[i][j][(s, cnt)] + tot) % mod
                    else:
                        dp[i][j][(s, cnt)] = tot
                else:
                    if s > arcade[(i, j)]:
                        continue
                    else:
                        if (arcade[(i, j)], cnt + 1) in dp[i][j]:
                            dp[i][j][(arcade[(i, j)], cnt + 1)] = (dp[i][j][(arcade[(i, j)], cnt + 1)] + tot) % mod
                        else:
                            dp[i][j][(arcade[(i, j)], cnt + 1)] = tot

lst = [0] * (C + 1)

for s, cnt in dp[N][M]:
    lst[cnt] += dp[N][M][(s, cnt)]

for i in range(C + 1):
    print(lst[i] % mod, end=" ")
