from collections import deque

N, K = map(int, input().split())
dx = [-1, 1]
dp = [-1] * 140001
dq = deque([N])
dp[N] = 0
cnt = 0
while True:
    flag = False
    tmp = []
    for i in dq:
        i = i * 2
        while i < 140000:
            if i == 0:
                break
            if dp[i] != -1:
                break
            tmp.append(i)
            dp[i] = cnt
            i = i * 2
    cnt = cnt + 1
    for i in dq:
        tmp.append(i)
    dq.clear()
    for i in tmp:
        if i == K:
            flag = True
            break
        for j in range(2):
            nx = i + dx[j]
            if 0 <= nx < 140000 and dp[nx] == -1:
                dp[nx] = cnt
                dq.append(nx)
    if flag:
        break
print(dp[K])
