from collections import deque

N = int(input())

dp = [1000000] * (N + 1)
dp[1] = 0
dq = deque([1])
while dq:
    a = dq.popleft()

    for i in (a + 1, 2 * a, 3 * a):
        if i > N:
            continue

        if dp[i] <= dp[a] + 1:
            continue

        dp[i] = dp[a] + 1
        dq.append(i)

print(dp[N])
