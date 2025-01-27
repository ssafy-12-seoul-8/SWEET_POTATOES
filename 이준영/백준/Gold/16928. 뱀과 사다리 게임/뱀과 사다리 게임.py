from collections import deque

N, M = map(int, input().split())
road = {}
for i in range(N + M):
    s, e = map(int, input().split())
    road[s] = e

dp = [0] * 101
dq = deque([1])
while True:
    a = dq.popleft()
    flag = False
    for k in range(1, 7):
        if a + k <= 100 and dp[a + k] == 0:
            dp[a + k] = dp[a] + 1
            if a + k in road:
                if dp[road[a + k]] == 0:
                    dp[road[a + k]] = dp[a] + 1
                    dq.append(road[a + k])
            else:
                dq.append(a + k)
        if a + k == 100:
            flag = True
            break
    if flag:
        break
print(dp[100])
