def btk(cur):
    global ans
    if ans:
        return

    if cur == 10:
        check()
        return

    tmp = lst[cur - 1]
    for i in nd[tmp]:
        lst[cur] = i
        btk(cur + 1)


def check():
    global ans
    for i in range(N):
        for j in range(M):
            if arr[i][j] == ".":
                t_check = roll(i, j)
                if not t_check:
                    return

    ans = lst[:]


def roll(y, x):
    for i in range(10):
        c = lst[i]
        y, x = go(y, x, c)
        if arr[y][x] == "O":
            return True

    return False


def go(y, x, d):
    while True:
        ny = y + dy[d]
        nx = x + dx[d]
        if arr[ny][nx] == ".":
            y, x = ny, nx
        elif arr[ny][nx] == "#":
            return y, x
        else:
            return ny, nx


T = int(input())
dy = [-1, 1, 0, 0]
dx = [0, 0, 1, -1]
command = ["U", "D", "R", "L"]
nd = [[2, 3], [2, 3], [0, 1], [0, 1]]
for _ in range(T):
    N, M = map(int, input().split())
    arr = [list(input()) for _ in range(N)]
    ans = []
    lst = [0] * 10
    for i in range(4):
        lst[0] = i
        btk(1)

    if ans:
        for i in range(10):
            print(command[ans[i]], end="")
        print()
    else:
        print("XHAE")
