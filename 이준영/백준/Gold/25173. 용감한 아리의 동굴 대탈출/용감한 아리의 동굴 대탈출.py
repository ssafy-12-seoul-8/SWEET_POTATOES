from collections import deque


def find_seuksoon(b_y, b_x, b_d):
    l = 1
    t_d = b_d
    while True:
        for _ in range(2):
            for _ in range(l):
                b_y += dy[t_d]
                b_x += dx[t_d]
                if 0 <= b_y < N and 0 <= b_x < M and arr[b_y][b_x] == 1:
                    return b_y, b_x
            t_d = (t_d + 1) % 4
        l = l + 1


def atk(sy, sx):
    visited = [[0] * M for _ in range(N)]
    visited[sy][sx] = 1
    dq = deque([(sy, sx, 0)])
    while dq:
        y, x, d = dq.popleft()
        if d >= E - 1:
            return 0

        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0:
                if arr[ny][nx] == 2:
                    return E - (d + 1)
                elif arr[ny][nx] == 0:
                    visited[ny][nx] = 1
                    dq.append((ny, nx, d + 1))
    return 0


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

A, D, B, E = map(int, input().split())
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
cnt = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            a_y, a_x = i, j
        elif arr[i][j] == 3:
            b_y, b_x = i, j
        elif arr[i][j] == 1:
            cnt += 1

for k in range(4):
    if b_y + dy[k] == a_y and b_x + dx[k] == a_x:
        a_d = b_d = k
        break
s_y, s_x, s_d = b_y, b_x, b_d
while True:
    # 아리 공격
    B -= D
    if B <= 0:
        ans = "VICTORY!"
        break

    for k in range(4):
        tmp = (a_d + k) % 4
        ny = a_y + dy[tmp]
        nx = a_x + dx[tmp]
        if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] == 0:
            s_y, s_x, s_d = a_y, a_x, tmp
            a_y, a_x, a_d = ny, nx, tmp
            arr[s_y][s_x] = 0
            arr[a_y][a_x] = 2
            break
        else:
            A -= 1

    if A <= 0:
        ans = "CAVELIFE..."
        break

    if cnt > 0:
        y, x = find_seuksoon(b_y, b_x, b_d)

        l = atk(y, x)
        A -= l
        if A <= 0:
            ans = "CAVELIFE..."
            break

    arr[b_y][b_x] = 0
    b_y, b_x, b_d = s_y, s_x, s_d
    arr[b_y][b_x] = 3

print(ans)
