def btk(cur, ry, rx, by, bx):  # 이번에 움직일 횟수
    global ans
    if ans <= cur:
        return

    for k in range(4):
        sry, srx = move(ry, rx, k)
        sby, sbx = move(by, bx, k)
        if arr[sry][srx] == "O":
            if arr[sby][sbx] != "O":
                ans = cur
            continue
        elif arr[sby][sbx] == "O":
            continue

        elif sry == sby and srx == sbx:
            if k == 0:
                if rx < bx:
                    srx -= 1
                else:
                    sbx -= 1
            elif k == 1:
                if rx < bx:
                    sbx += 1
                else:
                    srx += 1
            elif k == 2:
                if ry < by:
                    sry -= 1
                else:
                    sby -= 1
            else:
                if ry < by:
                    sby += 1
                else:
                    sry += 1
        if (ry, rx) == (sry, srx) and (by, bx) == (sby, sbx):
            continue
        btk(cur + 1, sry, srx, sby, sbx)

def move(y, x, d):
    while True:
        ny = y + dy[d]
        nx = x + dx[d]
        if arr[ny][nx] == ".":
            y = ny
            x = nx
        else:
            if arr[ny][nx] == "O":
                return ny, nx
            else:
                return y, x


N, M = map(int, input().split())

arr = [list(input()) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

for i in range(N):
    for j in range(M):
        if arr[i][j] == "R":
            ry, rx = i, j
            arr[i][j] = "."
        elif arr[i][j] == "B":
            by, bx = i, j
            arr[i][j] = "."

ans = 11

btk(1, ry, rx, by, bx)

if ans == 11:
    print(-1)
else:
    print(ans)
