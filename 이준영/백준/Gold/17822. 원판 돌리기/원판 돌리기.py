def rotate(i, d, k):
    if d == 0:
        tmp = circle[i][M - k:]
        for j in range(M - 1, k - 1, -1):
            circle[i][j] = circle[i][(j - k) % M]
        for j in range(k):
            circle[i][j] = tmp[j]

    else:
        tmp = circle[i][:k]
        for j in range(M - k):
            circle[i][j] = circle[i][(j + k) % M]
        for j in range(M - k, M):
            circle[i][j] = tmp[j - M + k]


N, M, T = map(int, input().split())

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
sm = 0
cnt = 0
circle = [list(map(int, input().split())) for _ in range(N)]
for i in range(N):
    sm += sum(circle[i])

cnt = N * M

for _ in range(T):
    x, d, k = map(int, input().split())
    for i in range(N):
        if i % x == x - 1:
            rotate(i, d, k)
    if sm == 0:
        continue

    lst = []
    for i in range(N):
        for j in range(M):
            if circle[i][j] == 0:
                continue
            for k in range(4):
                ny = i + dy[k]
                nx = (j + dx[k]) % M
                if 0 <= ny < N and circle[i][j] == circle[ny][nx]:
                    lst.append((i, j))
                    break

    if lst:
        for y, x in lst:
            sm -= circle[y][x]
            circle[y][x] = 0
            cnt -= 1
    else:
        t_sm = sm
        t_cnt = cnt
        for i in range(N):
            for j in range(M):
                if circle[i][j] == 0:
                    continue
                if circle[i][j] * t_cnt > t_sm:
                    circle[i][j] -= 1
                    sm -= 1
                    if circle[i][j] == 0:
                        cnt -= 1
                elif circle[i][j] * t_cnt < t_sm:
                    circle[i][j] += 1
                    sm += 1

print(sm)
