from collections import deque


def btk(cur, lst):
    if len(lst) == M:
        check(lst)
        return

    for i in range(cur, l + len(lst) - M + 1):
        lst.append(i)
        btk(i + 1, lst)
        lst.pop()


def check(lst):
    global mn
    visited = [[0] * N for _ in range(N)]
    dq = deque([])
    t_cnt = 0
    for i in lst:
        y, x = virus[i]
        dq.append((y, x))
        visited[y][x] = 1

    t = 0
    while dq:
        if t_cnt == cnt:
            break
        t += 1
        l = len(dq)
        for _ in range(l):
            y, x = dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] != 1:
                    visited[ny][nx] = 1
                    dq.append((ny, nx))
                    if arr[ny][nx] == 0:
                        t_cnt += 1

    if t_cnt != cnt:
        return

    mn = min(t, mn)


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
cnt = 0
virus = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 2:
            virus.append((i, j))
        elif arr[i][j] == 0:
            cnt += 1

l = len(virus)

mn = 2501
btk(0, [])

if mn == 2501:
    print(-1)
else:
    print(mn)
