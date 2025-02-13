# dp[i][j] 는 i번째에 j를 사는 가짓수
# 각 시행마다 살 수 있는 범위가 최소, 최대는 정해져 있다.
dp = [[0] * (2001) for _ in range(10)]

for i in range(1, 2001):
    dp[0][i] = 1

for i in range(1, 10):
    for j in range(2 ** i, 2001):
        for k in range(2 ** (i - 1), j // 2 + 1):
            dp[i][j] += dp[i - 1][k]
T = int(input())
for _ in range(T):
    n, m = map(int, input().split())

    cnt = 0
    for i in range(1, m + 1):
        cnt += dp[n - 1][i]

    print(cnt)
