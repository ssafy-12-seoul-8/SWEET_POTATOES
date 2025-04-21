N, K = map(int, input().split())
if K == 1:
    print(N)
else:
    dp = [-1] * (N + 1)
    dp[1] = 0
    for i in range(2, K):
        dp[i] = (dp[i - 1] + K) % i

    for i in range(K, N + 1):
        r = i % K
        q = i // K

        tmp = dp[i - q]
        if tmp <= r - 1:
            dp[i] = tmp + K * q
        else:
            h = tmp - r
            m = h % (K - 1)
            t = h // (K - 1)
            dp[i] = K * t + m

    print(dp[N] + 1)
