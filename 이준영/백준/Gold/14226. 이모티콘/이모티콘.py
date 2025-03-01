from collections import deque

S = int(input())
visited = [[3000] * 1001 for _ in range(1001)]
time = 3000

dq = deque([(1, 1, 1)])

while dq:
    cur, clip, t = dq.popleft()

    if time <= t:
        break

    if cur == S:
        time = min(time, t)
        break

    if visited[cur][cur] > t + 1:
        visited[cur][cur]
        dq.append((cur, cur, t + 1))

    if cur + clip > S:
        time = min(time, t + 1 + cur + clip - S)
    elif visited[cur + clip][clip] > t + 1:
        visited[cur + clip][clip] = t + 1
        dq.append((cur + clip, clip, t + 1))

    if cur > 0 and visited[cur - 1][clip] > t + 1:
        visited[cur - 1][clip] = t + 1
        dq.append((cur - 1, clip, t + 1))

print(time)
