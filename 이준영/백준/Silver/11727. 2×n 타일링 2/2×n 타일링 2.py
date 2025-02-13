# 2*n타일의 마지막을 세로로 1개 놓으면 f(a-1)
# 마지막 세로를 안쓰면 가로 2개를 쓰거나 큰 거 하나 써야 되므로 2*f(a-2)
def f(a):
    if dp[a] != -1:
        return dp[a]

    if a == 0:
        dp[0] = 1
        return dp[0]

    if a == 1:
        dp[1] = 1
        return dp[1]

    dp[a] = (f(a - 1) + 2 * f(a - 2)) % 10007
    return dp[a]


n = int(input())
dp = [-1] * (n + 1)
print(f(n))
