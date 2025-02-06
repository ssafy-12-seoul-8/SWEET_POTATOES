# 각 연결 상태를 무방향 그래프처럼 저장한 후
# 루트 노드인 1에서부터 bfs를 돌리면 된다.
# 만약 q에서 pop해서 나온 i에 대해 방문하지 않는 노드 j가 연결되어 있다면 j의 부모가 i가 된다.
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
