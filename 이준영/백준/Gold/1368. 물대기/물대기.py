# 그냥 우물파는걸 노드로 생각하면 된다니..
import sys
from heapq import heappop, heappush, heapify

input = sys.stdin.readline

N = int(input())
w = [int(input()) for _ in range(N)]

arr = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    arr[i].append(w[i])

arr.append(w+[0])


sm = 0
visited = [0] * (N+1)

visited[N] = 1                                          # 방문표시
need_check = []
for i in range(N):
    need_check.append((arr[N][i], i))
    need_check.append((arr[N][i], i))

heapify(need_check)

cnt = 0
while cnt < N:
    dis, b = heappop(need_check)
    if visited[b] == 1:
        continue

    visited[b] = 1
    sm += dis
    cnt += 1

    for j in range(N):
        if visited[j] == 0:
            heappush(need_check, (arr[b][j], j))

print(sm)
