import sys

input = sys.stdin.readline
n = int(input())
lst = [int(input()) for _ in range(n)]

if n == 1:
    print(lst[0])
elif n == 2:
    print(lst[0] + lst[1])
else:
    dp = [[0] * 3 for _ in range(n)]  # 0은 이거 안먹었을 때, 1은 이거 먹고 이전꺼 먹. 2는 이거 먹고 이전꺼 안먹
    dp[0][2] = lst[0]
    dp[1][0] = lst[0]
    dp[1][1] = lst[0] + lst[1]
    dp[1][2] = lst[1]
    for i in range(2, n):
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
        dp[i][1] = lst[i] + lst[i - 1] + dp[i - 2][0]
        dp[i][2] = lst[i] + dp[i - 1][0]

    print(max(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]))
