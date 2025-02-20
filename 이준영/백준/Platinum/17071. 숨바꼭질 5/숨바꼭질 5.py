from collections import deque

N, K = map(int, input().split())

visited = [[-1, -1] for _ in range(500001)]

dq = deque([(N, 0)])
visited[N][0] = 0
while dq:
    cur, t = dq.popleft()

    t = t + 1
    for i in (cur - 1, cur + 1, 2 * cur):
        if i < 0 or i > 500000:
            continue
        if visited[i][t % 2] != -1:
            continue
        visited[i][t % 2] = t
        dq.append((i, t))

t = 0
ans = -1
while K <= 500000:
    if visited[K][t % 2] <= t:
        ans = t
        break

    t += 1
    K = K + t

print(ans)