import sys
import heapq

input = sys.stdin.readline


def dijk(n):
    distance = [int(1e9)] * (V + 1)
    distance[n] = 0
    pq = [(0, n)]
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


V = int(input())
road = [[] for _ in range(V + 1)]
for i in range(V):
    lst = list(map(int, input().split()))
    start = lst[0]
    for j in range(len(lst) // 2 - 1):
        road[start].append((lst[j * 2 + 1], lst[j * 2 + 2]))

lst1 = dijk(1)
mx_idx = 1
for i in range(2, V + 1):
    if lst1[mx_idx] < lst1[i] < int(1e9):
        mx_idx = i
lst2 = dijk(mx_idx)
mx = 0
for i in range(1, V + 1):
    if mx < lst2[i] < int(1e9):
        mx = lst2[i]
print(mx)
