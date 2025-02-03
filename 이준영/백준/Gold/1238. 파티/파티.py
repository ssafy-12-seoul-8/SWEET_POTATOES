import sys
import heapq


def dijk(road):
    distance = [int(1e9)] * (N + 1)
    distance[X] = 0
    pq = [(0, X)]
    heapq.heapify(pq)
    while pq:
        dis, des = heapq.heappop(pq)
        if distance[des] < dis:
            continue
        for tmp_des, tmp_dis in road[des]:
            if distance[tmp_des] > tmp_dis + dis:
                distance[tmp_des] = tmp_dis + dis
                heapq.heappush(pq, (distance[tmp_des], tmp_des))
    return distance

input = sys.stdin.readline
N, M, X = map(int, input().split())
road = [[] for _ in range(N + 1)]
road2 = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b, c = map(int, input().split())
    road[a].append((b, c))
    road2[b].append((a, c))

go = dijk(road)
come = dijk(road2)

mx = 0
for i in range(1, N + 1):
    mx = max(mx, go[i] + come[i])

print(mx)