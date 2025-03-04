import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
road = [set([]) for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, input().split())
    road[A].add(B)
    road[B].add(A)

S, E = map(int, input().split())

distance = [[-1, 0] for _ in range(N + 1)]
ans = 0
distance[E] = [0, E]
dq = deque([(0, E)])

while dq:
    dis, cur = dq.popleft()

    for des in road[cur]:
        if distance[des][0] == -1:
            distance[des] = [dis + 1, cur]
            dq.append((dis + 1, des))
        elif distance[des][0] == dis + 1:
            if distance[des][1] > cur:
                distance[des][1] = cur

ans = ans + distance[S][0]

start = S

already = set([])
while start != E:
    ne = distance[start][1]
    already.add(ne)
    start = ne

already.remove(E)

visited = [-1] * (N + 1)
dq = deque([(0, E)])
visited[E] = 0

while dq:
    dis, cur = dq.popleft()
    for des in road[cur]:
        if visited[des] == -1 and des not in already:
            visited[des] = dis + 1
            dq.append((dis + 1, des))

ans += visited[S]
print(ans)
