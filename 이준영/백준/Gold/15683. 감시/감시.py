def btk(cur):
    if cur == l:
        check()
        return
    for i in range(4):
        idx[cur] = i
        btk(cur + 1)


def check():
    global mn
    visited = [[0] * M for _ in range(N)]
    for i in range(l):
        num, s_y, s_x = C[i]
        d = idx[i]
        for k in dct[num]:
            tmp = (k + d) % 4
            y = s_y
            x = s_x
            while True:
                ny = y + dy[tmp]
                nx = x + dx[tmp]
                if 0 <= ny < N and 0 <= nx < M:
                    if arr[ny][nx] != 6:
                        visited[ny][nx] = 1
                        y = ny
                        x = nx
                    else:
                        break
                else:
                    break
    cnt = 0
    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0 and arr[i][j] == 0:
                cnt += 1

    mn = min(mn, cnt)


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

dct = {1: [1], 2: [1, 3], 3: [0, 1], 4: [0, 1, 2], 5: [0, 1, 2, 3]}
C = []

for i in range(N):
    for j in range(M):
        if 0 < arr[i][j] < 6:
            C.append((arr[i][j], i, j))

l = len(C)
idx = [0] * l
mn = 65
btk(0)
print(mn)
