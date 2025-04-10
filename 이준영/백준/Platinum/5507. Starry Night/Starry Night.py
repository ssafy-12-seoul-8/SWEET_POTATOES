def myprint():
    for i in range(N):
        print(*board[i], sep="")
    # print("-" * 50)


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


def check(cnt, arr):
    c = semi_check(cnt, arr)
    if c != -1:
        return c
    for _ in range(3):
        arr = [row[::-1] for row in list(zip(*arr))]
        c = semi_check(cnt, arr)
        if c != -1:
            return c

    arr = [row[::-1] for row in arr]
    c = semi_check(cnt, arr)
    if c != -1:
        return c
    for _ in range(3):
        arr = [row[::-1] for row in list(zip(*arr))]
        c = semi_check(cnt, arr)
        if c != -1:
            return c
    return -1


def semi_check(cnt, arr):
    l1 = len(arr)
    l2 = len(arr[0])
    for l in range(len(star_lst)):
        cnt1, ll1, ll2, arr1 = star_lst[l]
        if cnt1 != cnt or l1 != ll1 or l2 != ll2:
            continue

        flag = True
        for i in range(l1):
            for j in range(l2):
                if arr1[i][j] != arr[i][j]:
                    flag = False
                    break
            if not flag:
                break

        if flag:
            return l

    return -1


M = int(input())
N = int(input())
board = [list(map(int, input())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
dy = [0, 0, 1, -1, 1, 1, -1, -1]
dx = [1, -1, 0, 0, 1, -1, 1, -1]

star_lst = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            mn_y = i
            mx_y = i
            mn_x = j
            mx_x = j
            lst = [(i, j)]
            idx = 0
            visited[i][j] = 1
            while idx < len(lst):
                y, x = lst[idx]
                idx += 1
                for k in range(8):
                    ny = y + dy[k]
                    nx = x + dx[k]
                    if not oob(ny, nx) and visited[ny][nx] == 0 and board[ny][nx] == 1:
                        visited[ny][nx] = 1
                        lst.append((ny, nx))
                        mn_y = min(mn_y, ny)
                        mx_y = max(mx_y, ny)
                        mn_x = min(mn_x, nx)
                        mx_x = max(mx_x, nx)

            l1 = mx_y - mn_y + 1
            l2 = mx_x - mn_x + 1
            cnt = len(lst)
            arr = [[0] * l2 for _ in range(l1)]
            for y, x in lst:
                arr[y - mn_y][x - mn_x] = 1

            if not star_lst:
                star_lst.append((cnt, l1, l2, arr))
                for y, x in lst:
                    board[y][x] = "a"
            else:
                flag = False
                c = check(cnt, arr)
                if c == -1:
                    target = chr(ord('a') + len(star_lst))
                    star_lst.append((cnt, l1, l2, arr))
                else:
                    target = chr(ord('a') + c)
                for y, x in lst:
                    board[y][x] = target

myprint()
