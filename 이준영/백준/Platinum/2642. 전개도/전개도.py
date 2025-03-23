from collections import deque


def check():
    for i in range(6):
        for j in range(6):
            if arr[i][j] != 0:
                return bfs(i, j)

    return False


def bfs(s_y, s_x):
    visited = [[0] * 6 for _ in range(6)]
    visited[s_y][s_x] = 1
    dice[0] = arr[s_y][s_x]
    dq = deque([(s_y, s_x, 0, 0, 0)])
    cnt = 1
    while dq:
        y, x, axis, d, cur = dq.popleft()
        for k in range(3):
            tmp = (d + direction[k]) % 4
            ny = y + dy[tmp]
            nx = x + dx[tmp]
            if 0 <= ny < 6 and 0 <= nx < 6 and visited[ny][nx] == 0 and arr[ny][nx] > 0:
                visited[ny][nx] = 1
                n_axis = change_direction[axis][cur][k]
                idx = rotate_axis[n_axis].index(cur)
                idx = (idx + 1) % 4
                n_cur = rotate_axis[n_axis][idx]
                if dice[n_cur] != 0:
                    return False
                dice[n_cur] = arr[ny][nx]
                cnt += 1
                dq.append((ny, nx, n_axis, tmp, n_cur))

    if cnt == 6:
        return True

    return False


rotate_axis = [[0, 1, 5, 4],
               [0, 3, 5, 2],
               [1, 3, 4, 2],
               [0, 4, 5, 1],
               [0, 2, 5, 3],
               [1, 2, 4, 3]]

change_direction = [[[0, 1, 4], [0, 2, 5], [],[], [0, 5, 2], [0, 4, 1]],
                    [[1, 3, 0], [], [1, 5, 2], [1, 2, 5], [], [1, 0, 3]],
                    [[], [2, 3, 0], [2, 1, 4], [2, 4, 1], [2, 0, 3], []],
                    [[3, 4, 1], [3, 5, 2], [], [], [3, 2, 5], [3, 1, 3]],
                    [[4, 0, 3], [], [4, 2, 5], [4, 5, 2], [], [4, 3, 0]],
                    [[], [5, 0, 3], [5, 4, 1], [5, 1, 4], [5, 3, 0], []]]

direction = [0, 1, 3]
dice = [0] * 6
arr = [list(map(int, input().split())) for _ in range(6)]
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
if check():
    for i in range(6):
        if dice[i] == 1:
            print(dice[5 - i])
            break
else:
    print(0)

