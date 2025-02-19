import sys
from heapq import heappop, heappush, heapify

input = sys.stdin.readline

N = int(input())
w = [int(input()) for _ in range(N)]

arr = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    arr[i][i] = w[i]

mn = int(1e9)

for i in range(N):
    sm = arr[i][i]
    visited = [0] * N

    visited[i] = 1
    need_check = []
    for j in range(N):
        if j != i:
            need_check.append((arr[j][j], j))
            need_check.append((arr[i][j], j))

    heapify(need_check)

    cnt = 0
    while cnt < N - 1:
        dis, b = heappop(need_check)
        if visited[b] == 1:
            continue

        visited[b] = 1
        sm += dis
        cnt += 1

        for j in range(N):
            if visited[j] == 0:
                heappush(need_check, (arr[b][j], j))

    mn = min(mn, sm)

print(mn)
