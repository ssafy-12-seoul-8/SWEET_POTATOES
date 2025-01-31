import heapq

N = int(input())
M = int(input())
road = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b, c = map(int, input().split())
    road[a].append((b, c))

start, end = map(int, input().split())

pq = []
visited = [False] * (N + 1)
distance = [int(1e9)] * (N + 1)
heapq.heapify(pq)
heapq.heappush(pq, (0, start))
while pq:
    dis, des = heapq.heappop(pq)
    if not visited[des]:
        visited[des] = True
        for tmp_des, tmp_dis in road[des]:
            if not visited[tmp_des] and tmp_dis + dis < distance[tmp_des]:
                distance[tmp_des] = tmp_dis + dis
                heapq.heappush(pq, (distance[tmp_des], tmp_des))
print(distance[end])
