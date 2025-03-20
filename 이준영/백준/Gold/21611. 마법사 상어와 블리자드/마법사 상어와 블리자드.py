def myprint():
    for i in range(N):
        print(*arr[i])
    print("-" * 50)


def go(y, x, d, l, k):
    for _ in range(l):
        y = y + tdy[d]
        x = x + tdx[d]
        idx[k] = (y, x)
        k += 1
    d = (d + 1) % 4
    return y, x, d, k


def pull():
    stk = []
    for i in range(N ** 2 - 2, -1, -1):
        y, x = idx[i]
        if arr[y][x] != 0:
            stk.append(arr[y][x])
            arr[y][x] = 0

    if not stk:
        return

    l = len(stk)

    for i in range(l):
        y, x = idx[i]
        arr[y][x] = stk.pop()


def check():
    global score
    if arr[N // 2][N // 2 - 1] == 0:
        return

    flag = False
    i = 1
    cnt = 1
    num = arr[N // 2][N // 2 - 1]

    while i < N ** 2 - 1:
        y, x = idx[i]
        if arr[y][x] == 0:
            if cnt >= 4:
                flag = True
                score += arr[idx[i - 1][0]][idx[i - 1][1]] * cnt
                for j in range(i - cnt, i):
                    ny, nx = idx[j]
                    arr[ny][nx] = 0
                cnt = 0
            break

        if arr[y][x] == num:
            cnt += 1
        else:
            if cnt >= 4:
                flag = True
                score += arr[idx[i - 1][0]][idx[i - 1][1]] * cnt
                for j in range(i - cnt, i):
                    ny, nx = idx[j]
                    arr[ny][nx] = 0
            cnt = 1
            num = arr[y][x]
        i += 1

    if cnt >= 4:
        flag = True
        score += arr[idx[N ** 2 - 1][0]][idx[N ** 2 - 1][1]] * cnt
        for j in range(N ** 2 - cnt, N ** 2):
            ny, nx = idx[j]
            arr[ny][nx] = 0

    return flag


def change():
    if arr[N // 2][N // 2 - 1] == 0:
        return
    stk = []
    cnt = 1
    num = arr[N // 2][N // 2 - 1]
    for i in range(1, N ** 2 - 1):
        y, x = idx[i]
        if arr[y][x] == 0:
            break

        if arr[y][x] == num:
            cnt += 1
        else:
            stk.extend((cnt, num))
            cnt = 1
            num = arr[y][x]
        arr[y][x] = 0

    if cnt > 0:
        stk.extend((cnt, num))

    for i in range(min(len(stk), N ** 2 - 1)):
        y, x = idx[i]
        arr[y][x] = stk[i]


N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

idx = [0] * (N ** 2 - 1)

y = x = N // 2
d = 0

tdy = [0, 1, 0, -1]
tdx = [-1, 0, 1, 0]
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
k = 0

for l in range(1, N):
    for _ in range(2):
        y, x, d, k = go(y, x, d, l, k)

go(y, x, d, N - 1, k)

score = 0
for _ in range(M):
    d, s = map(int, input().split())
    d = d - 1
    for k in range(1, s + 1):
        y = N // 2 + dy[d] * k
        x = N // 2 + dx[d] * k
        if not (0 <= y < N and 0 <= x < N):
            break
        arr[y][x] = 0
    pull()
    while True:
        if not check():
            break
        pull()
    change()

print(score)
