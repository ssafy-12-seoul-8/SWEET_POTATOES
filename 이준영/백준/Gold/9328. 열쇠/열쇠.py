# 14:57~15:13, 15:27~
import sys
from collections import deque

input = sys.stdin.readline


def check(tmp, i, j):
    global cnt
    if tmp == ".":
        dq.append((i, j))
        visited[i][j] = True
        return

    if tmp == "*":
        return

    if tmp == "$":
        cnt += 1
        dq.append((i, j))
        visited[i][j] = True
        return

    if tmp.isupper():
        k = tmp.lower()
        if k in key:
            dq.append((i, j))
            visited[i][j] = True
        else:
            if k in need_key:
                need_key[k].append((i, j))
            else:
                need_key[k] = [(i, j)]
        return

    dq.append((i, j))
    visited[i][j] = True
    key.add(tmp)
    if tmp in need_key:
        for y, x in need_key[tmp]:
            dq.append((y, x))
            visited[y][x] = True
        del need_key[tmp]


T = int(input())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

for _ in range(T):
    h, w = map(int, input().split())
    arr = [list(input().rstrip()) for _ in range(h)]
    key = list(input().rstrip())

    if key[0] == "0":
        key = set([])
    else:
        key = set(key)

    visited = [[False] * w for _ in range(h)]

    dq = deque([])
    need_key = {}
    cnt = 0

    for i in (0, h - 1):
        for j in range(w):
            tmp = arr[i][j]
            check(tmp, i, j)

    for j in (0, w - 1):
        for i in range(1, h - 1):
            tmp = arr[i][j]
            check(tmp, i, j)

    while dq:
        y, x = dq.popleft()

        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < h and 0 <= nx < w and not visited[ny][nx]:
                tmp = arr[ny][nx]
                check(tmp, ny, nx)

    print(cnt)
