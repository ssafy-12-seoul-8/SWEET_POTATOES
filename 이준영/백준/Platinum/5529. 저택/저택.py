import sys
from heapq import heappop, heappush

input = sys.stdin.readline

M, N, K = map(int, input().split())

col = {}
row = {}
distance = {}
pq = []
for _ in range(K):
    x, y = map(int, input().split())
    distance[y * 100000 + x] = 1 << 34
    if y in row:
        row[y].add(x)
    else:
        row[y] = set([x])
    if x in col:
        col[x].add(y)
    else:
        col[x] = set([y])

ans = 1 << 34
if 1 not in col or (M not in col and N not in row):
    print(-1)
else:
    for y in col[1]:
        distance[y * 100000 + 1] = y - 1
        tmp = ((((((y - 1) << 34) + y) << 34) + 1) << 1) + 1
        heappush(pq, tmp)

    while pq:
        tmp = heappop(pq)
        d = tmp % 2
        tmp = tmp >> 1
        x = tmp % (1 << 34)
        tmp = tmp >> 34
        y = tmp % (1 << 34)
        dis = tmp >> 34

        if dis >= ans:
            break

        if distance[y * 100000 + x] < dis:
            continue

        col[x].remove(y)
        row[y].remove(x)

        if y == N:
            ans = min(ans, dis + M - x + 1)
            continue
        if x == M:
            ans = min(ans, dis + N - y + 1)
            continue
        if d == 1:
            for t_x in row[y]:
                tmp = y * 100000 + t_x
                if distance[tmp] > dis + abs(x - t_x) + 1:
                    distance[tmp] = dis + abs(x - t_x) + 1
                    if ans > dis + abs(x - t_x) + 2 + M + N - y - t_x:
                        heappush(pq, (((((dis + abs(x - t_x) + 1) << 34) + y) << 34) + t_x) * 2)
        else:
            for t_y in col[x]:
                tmp = t_y * 100000 + x
                if distance[tmp] > dis + abs(y - t_y) + 1:
                    distance[tmp] = dis + abs(y - t_y) + 1
                    if ans > dis + abs(y - t_y) + 2 + M + N - t_y - x:
                        heappush(pq, (((((dis + abs(y - t_y) + 1) << 34) + t_y) << 34) + x) * 2 + 1)

    if ans == (1 << 34):
        print(-1)
    else:
        print(ans)
