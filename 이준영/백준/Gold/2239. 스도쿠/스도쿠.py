import sys

input = sys.stdin.readline
sys.setrecursionlimit(10000)


def btk(cur):
    global check
    if check:
        return
    if cur == 81:
        check = True
        for i in range(9):
            print(*arr[i], sep="")
        return
    y = cur // 9
    x = cur % 9
    if arr[y][x] != 0:
        btk(cur + 1)
        return
    for i in range(1, 10):
        if row[y][i] and col[x][i] and square[(y // 3) * 3 + x // 3][i]:
            row[y][i] = col[x][i] = square[(y // 3) * 3 + x // 3][i] = False
            arr[y][x] = i
            btk(cur + 1)
            arr[y][x] = 0
            row[y][i] = col[x][i] = square[(y // 3) * 3 + x // 3][i] = True


arr = [list(map(int, input().rstrip())) for _ in range(9)]
row = [[True] * 10 for _ in range(9)]
col = [[True] * 10 for _ in range(9)]
square = [[True] * 10 for _ in range(9)]

for i in range(9):
    for j in range(9):
        tmp = arr[i][j]
        if tmp == 0:
            continue
        row[i][tmp] = False
        col[j][tmp] = False
        square[(i // 3) * 3 + j // 3][tmp] = False

check = False
btk(0)
