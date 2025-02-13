# dp[i][j] 1~i번째 동전으로 j원을 만드는 방법의 수

T = int(input())

for _ in range(T):
    N = int(input())
    arr = list(map(int, input().split()))
    M = int(input())
    dp = [[0] * (M + 1) for _ in range(N + 1)]
    for i in range(N+1):
        dp[i][0] = 1
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if j < arr[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]]

    print(dp[N][M])
