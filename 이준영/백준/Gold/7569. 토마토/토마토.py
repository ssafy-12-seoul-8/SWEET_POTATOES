M, N, H = map(int, input().split())

arr = [[[[0] * M for _ in range(N)]] for _ in range(H)]

dy = [0, 0, 0, 0, 1, -1]
dx = [0, 0, 1, -1, 0, 0]
dz = [1, -1, 0, 0, 0, 0]

tm = 0

for k in range(H):
    arr[k] = [list(map(int, input().split())) for _ in range(N)]

dq = []
for k in range(H):
    for i in range(N):
        for j in range(M):
            if arr[k][i][j] == 1:
                dq.append((k, i, j))
            elif arr[k][i][j] == 0:
                tm += 1

day = 0
while tm > 0 and dq:
    tmp_dq = []
    for z, y, x in dq:
        for k in range(6):
            nz = z + dz[k]
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= nz < H and 0 <= ny < N and 0 <= nx < M and arr[nz][ny][nx] == 0:
                tmp_dq.append((nz, ny, nx))
                tm -= 1
                arr[nz][ny][nx] = 1

    dq = tmp_dq
    day += 1

if tm>0:
    print(-1)
else:
    print(day)
