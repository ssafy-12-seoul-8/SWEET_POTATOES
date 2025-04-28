from collections import deque

N = int(input())
road = [[] for _ in range(N + 1)]
cnt = [0] * (N + 1)
visited = [0] * (N + 1)
depth = [0] * (N + 1)

for _ in range(N):
    a, b = map(int, input().split())
    road[a].append(b)
    road[b].append(a)
    cnt[a] += 1
    cnt[b] += 1

dq = deque([])
for i in range(1, N + 1):
    if cnt[i] == 1:
        visited[i] = 1
        dq.append(i)

while dq:
    cur = dq.popleft()
    for num in road[cur]:
        if visited[num] == 0:
            cnt[num] -= 1
            if cnt[num] == 1:
                visited[num] = 1
                dq.append(num)

for i in range(1, N + 1):
    if visited[i] == 0:
        dq.append((i, 0))

while dq:
    cur, dis = dq.popleft()
    for num in road[cur]:
        if visited[num] == 1:
            visited[num] = 0
            depth[num] = dis + 1
            dq.append((num, dis + 1))

print(*depth[1:])
