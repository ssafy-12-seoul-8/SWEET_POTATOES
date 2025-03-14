def drop(arr):
    b = [[-2] * N for _ in range(N)]
    for j in range(N):
        stk = []
        for i in range(N):
            if arr[i][j] >= 0:
                stk.append(arr[i][j])
            elif arr[i][j] == -2:
                continue
            else:
                l = len(stk)
                for k in range(l):
                    b[i - l + k][j] = stk[k]
                b[i][j] = -1
                stk = []
        if stk:
            l = len(stk)
            for k in range(l):
                b[N - l + k][j] = stk[k]

    return b


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

score = 0
while True:
    visited = [[0] * N for _ in range(N)]
    mx_score = -1
    mx_r = -1
    m_y, m_x = -1, -1
    m_lst = []
    for i in range(N):
        for j in range(N):
            if arr[i][j] >= 1 and visited[i][j] == 0:
                lst = [(i, j)]
                idx = 0
                visited[i][j] = 1
                cnt = 0
                while idx < len(lst):
                    y, x = lst[idx]
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and (
                                arr[ny][nx] == 0 or arr[ny][nx] == arr[i][j]):
                            visited[ny][nx] = 1
                            lst.append((ny, nx))
                    idx += 1

                for y, x in lst:
                    if arr[y][x] == 0:
                        cnt += 1
                        visited[y][x] = 0
                l = len(lst)

                if l >= 2:
                    if l > mx_score:
                        mx_score = l
                        mx_r = cnt
                        m_y, m_x = i, j
                        m_lst = lst
                    elif l == mx_score:
                        if cnt >= mx_r:
                            mx_score = l
                            mx_r = cnt
                            m_y, m_x = i, j
                            m_lst = lst

    if mx_score == -1:
        break
    score += mx_score ** 2

    for y, x in m_lst:
        arr[y][x] = -2

    arr = drop(arr)

    t_arr = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            t_arr[i][j] = arr[j][N - 1 - i]
    arr = t_arr
    arr = drop(arr)
print(score)
