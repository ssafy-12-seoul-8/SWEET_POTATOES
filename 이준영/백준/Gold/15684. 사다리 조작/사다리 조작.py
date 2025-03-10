import sys

input = sys.stdin.readline


def btk(cur, cnt, m_cnt):
    global ans, f_check
    if ans != 4:
        return

    y = cur // (N - 1)
    x = cur % (N - 1)

    if cnt == m_cnt:
        f_check += 1
        t_arr = [0] * (N + 1)
        for i in range(1, N + 1):
            t_arr[i] = start[i]
        if y <= H - 1:
            for t_x in vt[y]:
                if t_x >= x:
                    swap(t_arr, t_x + 1)
        for k in range(y + 1, H):
            for t_x in vt[k]:
                swap(t_arr, t_x + 1)

        for i in range(1, N + 1):
            if t_arr[i] != i:
                return
        ans = m_cnt
        return

    if cur == (N - 1) * H:
        return

    if check[y][x] != 0:
        if check[y][x] == 1:
            swap(start, x + 1)
            btk(cur + 1, cnt, m_cnt)
            swap(start, x + 1)
        else:
            btk(cur + 1, cnt, m_cnt)
        return

    check[y][x] = 1
    if x + 1 < N - 1:
        origin = check[y][x + 1]
        check[y][x + 1] = -1
        swap(start, x + 1)
        btk(cur + 1, cnt + 1, m_cnt)
        check[y][x + 1] = origin
        swap(start, x + 1)
    else:
        swap(start, x + 1)
        btk(cur + 1, cnt + 1, m_cnt)
        swap(start, x + 1)
    check[y][x] = 0
    btk(cur + 1, cnt, m_cnt)


def swap(arr, a):
    arr[a], arr[a + 1] = arr[a + 1], arr[a]


N, M, H = map(int, input().split())

vt = [[] for _ in range(H)]
check = [[0] * (N - 1) for _ in range(H)]

for _ in range(M):
    a, b = map(int, input().split())
    vt[a - 1].append(b - 1)

    check[a - 1][b - 1] = 1
    for tmp in (b - 2, b):
        if 0 <= tmp < N - 1:
            check[a - 1][tmp] = -1

ans = 0
f_check = 0
start = [i for i in range(N + 1)]
for y in range(H):
    for x in vt[y]:
        swap(start, x + 1)

for i in range(1, N + 1):
    if start[i] != i:
        ans = 4
        break
for i in range(1, 4):
    if ans != 4:
        break
    start = [i for i in range(N + 1)]
    btk(0, 0, i)

if ans == 4:
    print(-1)
else:
    print(ans)
