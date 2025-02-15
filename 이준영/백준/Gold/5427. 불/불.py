import sys
from collections import deque

input = sys.stdin.readline
T = int(input())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
for _ in range(T):
    w, h = map(int, input().split())
    arr = [list(input().rstrip()) for _ in range(h)]
    visited = [[0] * w for _ in range(h)]
    b_dq = deque([])
    s_dq = deque([])
    for i in range(h):
        for j in range(w):
            if arr[i][j] == "@":
                s_dq.append((i, j))
                visited[i][j] = 1
                arr[i][j] = "."
            elif arr[i][j] == "*":
                b_dq.append((i, j))

    time = 1
    flag = False
    while s_dq:

        l1 = len(b_dq)
        l2 = len(s_dq)
        for i in range(l1):
            y, x = b_dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < h and 0 <= nx < w and arr[ny][nx] == ".":
                    arr[ny][nx] = "*"
                    b_dq.append((ny, nx))

        for i in range(l2):
            y, x = s_dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if not (0 <= ny < h and 0 <= nx < w):
                    flag = True
                    break
                elif visited[ny][nx] == 0 and arr[ny][nx] == ".":
                    visited[ny][nx] = 1
                    s_dq.append((ny, nx))
            if flag:
                break

        if flag:
            break
        time = time + 1

    if flag:
        print(time)
    else:
        print("IMPOSSIBLE")
