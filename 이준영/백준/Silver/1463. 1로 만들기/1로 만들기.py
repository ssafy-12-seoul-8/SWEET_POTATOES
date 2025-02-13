def f(a):
    if dp[a] != -1:
        return dp[a]
    if a == 0:
        dp[0] = 1000000
        return dp[0]

    if a == 1:
        dp[1] = 0
        return 0

    if a % 6 == 0:
        dp[a] = min(f(a // 2), f(a // 3)) + 1
        return dp[a]
    if a % 6 == 2:
        dp[a] = min(f(a // 2), f(a - 2) + 1) + 1
        return dp[a]
    if a % 6 == 3:
        dp[a] = min(f(a // 3), f(a - 1)) + 1
        return dp[a]
    if a % 6 == 4:
        dp[a] = min(f(a // 2), f(a - 1)) + 1
        return dp[a]

    dp[a] = f(a - 1) + 1
    return dp[a]


N = int(input())

dp = [-1] * (N + 1)

print(f(N))
