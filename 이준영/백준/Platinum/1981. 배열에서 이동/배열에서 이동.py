from heapq import heappop, heappush

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
t_mn = min(map(min, arr))
mn = 201
l = t_mn
while l <= min(arr[0][0], arr[n - 1][n - 1]):
    distance = [[201] * n for _ in range(n)]
    distance[0][0] = arr[0][0]
    pq = []
    heappush(pq, (arr[0][0], -arr[0][0], 0, 0))

    while pq:
        dis, t_m, y, x = heappop(pq)

        if distance[y][x] < dis:
            continue

        if y == n - 1 and x == n - 1:
            break

        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < n and 0 <= nx < n and arr[ny][nx] >= l and distance[ny][nx] > max(dis, arr[ny][nx]):
                distance[ny][nx] = max(dis, arr[ny][nx])
                heappush(pq, (distance[ny][nx], -min(-t_m, arr[ny][nx]), ny, nx))

    if distance[n - 1][n - 1] == 201:
        break

    mn = min(mn, distance[n - 1][n - 1] + t_m)
    l = max(l + 1, -t_m + 1)
print(mn)
