def btk(dis, cnt, y, x, ld):
    global mn
    if mn <= dis:
        return
    if cnt == tot_cnt:
        mn = dis
        return

    for k in nd[ld]:
        lst = []
        ny, nx = y, x
        while True:
            nny = ny + dy[k]
            nnx = nx + dx[k]
            if not (0 <= nny < N and 0 <= nnx < M):
                break

            if visited[nny][nnx] == 1:
                break

            visited[nny][nnx] = 1
            lst.append((nny, nnx))
            ny, nx = nny, nnx
        if lst:
            btk(dis + 1, cnt + len(lst), ny, nx, k)
            for ny, nx in lst:
                visited[ny][nx] = 0


tc = 1
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
nd = [[2, 3], [2, 3], [0, 1], [0, 1], [0, 1, 2, 3]]
while True:
    try:
        N, M = map(int, input().split())
        arr = [list(input()) for _ in range(N)]
        visited = [[0] * M for _ in range(N)]
        mn = 1000
        tot_cnt = 0
        for i in range(N):
            for j in range(M):
                if arr[i][j] == ".":
                    tot_cnt += 1
                else:
                    visited[i][j] = 1
        for i in range(N):
            for j in range(M):
                if visited[i][j] == 0:
                    visited[i][j] = 1
                    btk(0, 1, i, j, 4)
                    visited[i][j] = 0
        if mn == 1000:
            ans = -1
        else:
            ans = mn
        print(f'Case {tc}: {ans}')
        tc += 1
    except Exception:
        break
