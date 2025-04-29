# 1639~

def btk(lst):
    global flag, ans
    if flag:
        return

    l = len(lst)
    if l == 9:
        flag = True
        ans = lst[:]
        return

    for i in range(9):
        if visited[i] == 0:
            if check(i) == score[l]:
                visited[i] = 1
                lst.append(word[i])
                btk(lst)
                lst.pop()
                visited[i] = 0
            roll_back(i)


def check(i):
    cur = word[i]
    y, x = loc[cur]
    cnt = 0
    row[y] += 1
    if row[y] == 3:
        cnt += 1

    col[x] += 1
    if col[x] == 3:
        cnt += 1

    if y + x == 2:
        diag[0] += 1
        if diag[0] == 3:
            cnt += 1

    if y == x:
        diag[1] += 1
        if diag[1] == 3:
            cnt += 1

    return cnt


def roll_back(i):
    cur = word[i]
    y, x = loc[cur]
    row[y] -= 1
    col[x] -= 1
    if y + x == 2:
        diag[0] -= 1
    if y == x:
        diag[1] -= 1


T = int(input())
for _ in range(T):
    word = list(input())
    loc = {}
    board = [list(input()) for _ in range(3)]
    for i in range(3):
        for j in range(3):
            loc[board[i][j]] = (i, j)

    score = [0] * 9
    row = [0] * 3
    col = [0] * 3
    diag = [0] * 2

    for i in range(9):
        cur = word[i]
        y, x = loc[cur]
        row[y] += 1
        if row[y] == 3:
            score[i] += 1

        col[x] += 1
        if col[x] == 3:
            score[i] += 1

        if y + x == 2:
            diag[0] += 1
            if diag[0] == 3:
                score[i] += 1

        if y == x:
            diag[1] += 1
            if diag[1] == 3:
                score[i] += 1

    word.sort()
    visited = [0] * 9
    row = [0] * 3
    col = [0] * 3
    diag = [0] * 2
    ans = []
    flag = False
    btk([])
    print(*score, sep="", end=" ")
    print(*ans, sep="")
