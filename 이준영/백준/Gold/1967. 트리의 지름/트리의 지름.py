import heapq
import sys

def dijk(start):
    distance = [int(1e9)]*(n+1)
    distance[start] = 0
    pq = [(0,start)]
    heapq.heapify(pq)
    while pq:
        dis, des = heapq.heappop(pq)
        if distance[des] < dis:
            continue
        distance[des] = dis
        for tmp_des, tmp_dis in road[des].items():
            if distance[tmp_des] > dis + tmp_dis:
                distance[tmp_des] = dis + tmp_dis
                heapq.heappush(pq,(distance[tmp_des],tmp_des))
    return distance

input = sys.stdin.readline
n = int(input())
road = [{} for _ in range(n+1)]
for _ in range(n-1):
    a,b,c = map(int,input().split())
    road[a][b] = c
    road[b][a] = c
lst1 = dijk(1)
mx = -1
mx_index = -1
for i in range(1,n+1):
    if mx < lst1[i] < int(1e9):
        mx = lst1[i]
        mx_index = i
lst2 = dijk(mx_index)
mx = -1
for i in range(1,n+1):
    if mx < lst2[i] < int(1e9):
        mx = lst2[i]

print(mx)


