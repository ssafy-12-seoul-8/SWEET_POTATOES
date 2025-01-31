from collections import deque

N = int(input())
par = [0] * (N + 1)
visited = [False] * (N + 1)
road = [[] for _ in range(N + 1)]

for i in range(N - 1):
    a, b = map(int, input().split())
    road[a].append(b)
    road[b].append(a)

dq = deque([1])
while dq:
    a = dq.popleft()
    if not visited[a]:
        visited[a] = True
        for i in road[a]:
            if not visited[i]:
                par[i] = a
                dq.append(i)

for i in range(2, N + 1):
    print(par[i])
