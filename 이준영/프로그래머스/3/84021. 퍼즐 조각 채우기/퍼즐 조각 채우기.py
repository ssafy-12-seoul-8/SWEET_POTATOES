def solution(game_board, table):
    answer = 0
    N = len(game_board)
    M = len(game_board[0])

    dy = [0, 0, 1, -1]
    dx = [1, -1, 0, 0]
    block_lst = []
    visited = [[0] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0 and table[i][j] == 1:
                visited[i][j] = 1
                lst = [(i, j)]
                idx = 0
                mx_y, mx_x, mn_y, mn_x = i, j, i, j
                while idx < len(lst):
                    y, x = lst[idx]
                    idx += 1
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and table[ny][nx] == 1:
                            visited[ny][nx] = 1
                            lst.append((ny, nx))
                            mx_y = max(mx_y, ny)
                            mn_y = min(mn_y, ny)
                            mx_x = max(mx_x, nx)
                            mn_x = min(mn_x, nx)
                l1 = mx_y - mn_y + 1
                l2 = mx_x - mn_x + 1
                arr = [[0] * l2 for _ in range(l1)]

                for y, x in lst:
                    arr[y - mn_y][x - mn_x] = 1
                new_lst = [l1, l2, len(lst), arr]

                block_lst.append(new_lst)
    l = len(block_lst)
    used = [0] * l
    visited = [[0] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0 and game_board[i][j] == 0:
                visited[i][j] = 1
                lst = [(i, j)]
                idx = 0
                mx_y, mx_x, mn_y, mn_x = i, j, i, j
                while idx < len(lst):
                    y, x = lst[idx]
                    idx += 1
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and game_board[ny][nx] == 0:
                            visited[ny][nx] = 1
                            lst.append((ny, nx))
                            mx_y = max(mx_y, ny)
                            mn_y = min(mn_y, ny)
                            mx_x = max(mx_x, nx)
                            mn_x = min(mn_x, nx)
                l1 = mx_y - mn_y + 1
                l2 = mx_x - mn_x + 1
                cnt = len(lst)
                arr = [[0] * l2 for _ in range(l1)]
                for y, x in lst:
                    arr[y - mn_y][x - mn_x] = 1

                flag = False
                for p in range(l):
                    if used[p] == 1:
                        continue
                    t_l1, t_l2, t_cnt, t_arr = block_lst[p]
                    if t_cnt != cnt:
                        continue

                    for _ in range(4):
                        if (l1, l2) == (t_l1, t_l2):
                            if check(arr, t_arr, l1, l2):
                                for y, x in lst:
                                    game_board[y][x] = 1
                                    used[p] = 1
                                answer += cnt
                                flag = True
                                break

                        t_l1, t_l2 = t_l2, t_l1
                        t_arr = rotate(t_arr)
                    if flag:
                        break
    return answer


def rotate(arr):
    arr = [row[::-1] for row in arr]
    arr = list(zip(*arr))
    return arr


def check(arr1, arr2, l1, l2):
    for i in range(l1):
        for j in range(l2):
            if arr1[i][j] != arr2[i][j]:
                return False

    return True