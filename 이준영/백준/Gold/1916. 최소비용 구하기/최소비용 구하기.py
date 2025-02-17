import sys
from heapq import heappop, heappush

input = sys.stdin.readline

N = int(input())
M = int(input())
road = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    road[a].append((b, c))                                  # (목적지,거리)

start, end = map(int, input().split())

pq = []
distance = [int(1e9)] * (N + 1)
distance[start] = 0 
heappush(pq, (0, start))

while pq:
    dis, des = heappop(pq)

    if distance[des] < dis:                                 # 이미 최적화 되어있다면 패스
        continue

    for tmp_des, tmp_dis in road[des]:
        if dis + tmp_dis < distance[tmp_des]:               # 이 경로로 갔을 대 최적화가 된다면
            distance[tmp_des] = dis + tmp_dis               # 거리를 갱신해주고
            heappush(pq, (distance[tmp_des], tmp_des))      # 이 지점으로부터 다시 갱신해준다.

print(distance[end])
