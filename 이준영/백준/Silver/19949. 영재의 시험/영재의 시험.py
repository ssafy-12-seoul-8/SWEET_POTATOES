# dp 풀이
arr = list(map(int, input().split()))
dp = [[[[0] * 11 for _ in range(3)] for _ in range(6)] for _ in range(10)]

dp[0][arr[0]][1][1] = 1
for i in range(1, 6):
    if i != arr[0]:
        dp[0][i][1][0] = 1

for i in range(9):
    for j in range(1, 6):
        for k in range(1, 3):
            for l in range(i + 2):
                for cur in range(1, 6):
                    tmp = l
                    if cur == arr[i + 1]:
                        tmp += 1

                    if cur == j:
                        if k == 2:
                            continue
                        dp[i + 1][cur][k + 1][tmp] += dp[i][j][k][l]
                    else:
                        dp[i + 1][cur][1][tmp] += dp[i][j][k][l]

cnt = 0

for j in range(1, 6):
    for k in range(1, 3):
        for l in range(5, 11):
            cnt += dp[9][j][k][l]

print(cnt)
