import sys
from heapq import heappush, heappop
from collections import deque

input = sys.stdin.readline


def dijk(s):
    distance = [int(1e9)] * (N)
    distance[s] = 0

    pq = []
    heappush(pq, (0, s))
    while pq:
        dis, des = heappop(pq)

        if distance[des] < dis:
            continue

        for tmp_des, tmp_dis in road[des].items():
            if distance[tmp_des] > dis + tmp_dis:
                distance[tmp_des] = dis + tmp_dis
                heappush(pq, (distance[tmp_des], tmp_des))

    return distance


while True:
    N, M = map(int, input().split())
    if N == 0:
        break

    S, D = map(int, input().split())
    road = [{} for _ in range(N)]
    reverse_road = [{} for _ in range(N)]

    for _ in range(M):
        a, b, c = map(int, input().split())
        road[a][b] = c
        reverse_road[b][a] = c

    distance = dijk(S)
    if distance[D] == int(1e9):
        print(-1)

    else:
        visited = [0] * (N + 1)
        dq = deque([D])
        while dq:
            cur = dq.popleft()
            if cur == S or visited[cur] == 1:
                continue
            visited[cur] = 1
            for tmp_des, tmp_dis in reverse_road[cur].items():
                if tmp_dis == distance[cur] - distance[tmp_des]:
                    del road[tmp_des][cur]
                    dq.append(tmp_des)

        distance = dijk(S)
        if distance[D] == int(1e9):
            print(-1)
        else:
            print(distance[D])
