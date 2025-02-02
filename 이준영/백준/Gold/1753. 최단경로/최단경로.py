import heapq
import sys

input = sys.stdin.readline
V, E = map(int, input().split())
K = int(input())
road = [{} for _ in range(V + 1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    if v in road[u]:
        road[u][v] = min(road[u][v], w)
    else:
        road[u][v] = w

distance = [int(1e9)] * (V + 1)
distance[K] = 0
pq = [(0, K)]
heapq.heapify(pq)
while pq:
    dis, des = heapq.heappop(pq)
    if distance[des] < dis:
        continue
    for tmp_des, tmp_dis in road[des].items():
        if distance[tmp_des] > dis + tmp_dis:
            distance[tmp_des] = dis + tmp_dis
            heapq.heappush(pq, (distance[tmp_des], tmp_des))
for i in range(1, V + 1):
    if distance[i] == int(1e9):
        print("INF")
    else:
        print(distance[i])
