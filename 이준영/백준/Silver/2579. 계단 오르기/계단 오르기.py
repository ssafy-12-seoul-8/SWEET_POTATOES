# 마지막 계단을 밟기 전 상황을 보면
# 전 계단을 밟았을 경우 그 다음 계단을 못 밟고 3칸 떨어진 곳을 밟아야 한다.
# 2칸 뛸 경우 2칸 떨어진 곳을 밟는다.
# 따라서 f(a) = max(f(a-2),f(a-3)+arr[a-2])+arr[a-1]
def f(a):
    if dp[a] != -1:
        return dp[a]

    if a == 0:
        dp[0] = 0
        return 0

    if a == 1:
        dp[1] = arr[0]
        return dp[1]

    if a == 2:
        dp[2] = arr[1] + arr[0]
        return dp[2]

    dp[a] = max(f(a - 2), f(a - 3) + arr[a - 2]) + arr[a-1]
    return dp[a]


N = int(input())
arr = [int(input()) for _ in range(N)]

dp = [-1] * (N+1)
print(f(N))
