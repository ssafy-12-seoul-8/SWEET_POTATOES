n, m, r = map(int, input().split())
price = [0]
price.extend(list(map(int, input().split())))
distance = [[int(1e9)] * (n + 1) for _ in range(n + 1)]
for _ in range(r):
    a, b, c = map(int, input().split())
    distance[a][b] = c
    distance[b][a] = c
for i in range(1, n + 1):
    distance[i][i] = 0
for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if distance[i][j] > distance[i][k] + distance[k][j]:
                distance[i][j] = distance[i][k] + distance[k][j]

mx = 0
for i in range(1, n + 1):
    tmp = price[i]
    for j in range(1, n + 1):
        if j != i and distance[i][j] <= m:
            tmp += price[j]
    mx = max(mx, tmp)
print(mx)
