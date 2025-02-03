n = int(input())
m = int(input())
road = [[] for _ in range(n + 1)]
distance = [[int(1e9)] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    distance[i][i] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    distance[a][b] = min(distance[a][b], c)

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if distance[i][j] > distance[i][k] + distance[k][j]:
                distance[i][j] = distance[i][k] + distance[k][j]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if distance[i][j] == int(1e9):
            print(0, end=" ")
        else:
            print(distance[i][j], end=" ")
    print()
