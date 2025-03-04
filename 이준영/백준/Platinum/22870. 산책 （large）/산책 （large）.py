import sys
from heapq import heappop, heappush

input = sys.stdin.readline

N, M = map(int, input().split())
road = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B, C = map(int, input().split())
    road[A].append((B, C))
    road[B].append((A, C))

S, E = map(int, input().split())

distance = [[int(1e9), 0] for _ in range(N + 1)]
ans = 0
distance[E] = [0, E]
pq = []
heappush(pq, (0, E))

while pq:
    dis, cur = heappop(pq)

    if distance[cur][0] < dis:
        continue

    for tmp_des, tmp_dis in road[cur]:
        if distance[tmp_des][0] > dis + tmp_dis:
            distance[tmp_des] = [dis + tmp_dis, cur]
            heappush(pq, (dis + tmp_dis, tmp_des))
        elif distance[tmp_des][0] == dis + tmp_dis and distance[tmp_des][1] > cur:
            distance[tmp_des][1] = cur

ans = ans + distance[S][0]

start = S

already = set([])
while start != E:
    ne = distance[start][1]
    already.add(ne)
    start = ne

already.remove(E)

distance = [int(1e9)] * (N + 1)
distance[E] = 0
pq = []
heappush(pq, (0, E))

while pq:
    dis, cur = heappop(pq)

    if distance[cur] < dis:
        continue

    for tmp_des, tmp_dis in road[cur]:
        if tmp_des in already:
            continue

        if distance[tmp_des] > dis + tmp_dis:
            distance[tmp_des] = dis + tmp_dis
            heappush(pq, (dis + tmp_dis, tmp_des))

ans += distance[S]
print(ans)
