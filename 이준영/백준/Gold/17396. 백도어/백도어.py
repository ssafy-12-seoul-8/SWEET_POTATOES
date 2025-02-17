import sys
from heapq import heappush, heappop

input = sys.stdin.readline

N, M = map(int, input().split())

enemy = list(map(int, input().split()))

road = [[] for _ in range(N)]

for _ in range(M):
    a, b, c = map(int, input().split())         # 도착지가 아니면서 시야에 걸리는 곳이 있다면 굳이 길을 추가 안해도 됨
    if a < N - 1 and enemy[a] == 1:             # 시야에 걸려서 무효
        continue
    if b < N - 1 and enemy[b] == 1:             # 시야에 걸려서 무효
        continue

    road[a].append((b, c))
    road[b].append((a, c))

distance = [int(1e11)] * N
distance[0] = 0
pq = []
heappush(pq, (0, 0))

while pq:
    dis, des = heappop(pq)

    if distance[des] < dis:
        continue

    for tmp_des, tmp_dis in road[des]:
        if distance[tmp_des] > tmp_dis + dis:
            distance[tmp_des] = tmp_dis + dis
            heappush(pq, (distance[tmp_des], tmp_des))

if distance[N - 1] == int(1e11):
    print(-1)
else:
    print(distance[N - 1])
