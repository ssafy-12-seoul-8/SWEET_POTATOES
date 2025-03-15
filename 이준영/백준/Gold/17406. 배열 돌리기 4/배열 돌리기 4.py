def btk(cur):
    global mn
    if cur == K:
        t_mn = min(map(sum, arr))
        mn = min(mn, t_mn)
        return

    for i in range(K):
        if visited[i] == 0:
            visited[i] = 1
            r, c, s = op[i]
            rotate(r, c, s)
            btk(cur + 1)
            back_rotate(r, c, s)
            visited[i] = 0


def rotate(r, c, s):
    for l in range(s):
        tmp = arr[r - s + l][c - s + l]

        for i in range(r - s + l, r + s - l):
            arr[i][c - s + l] = arr[i + 1][c - s + l]

        for j in range(c - s + l, c + s - l):
            arr[r + s - l][j] = arr[r + s - l][j + 1]

        for i in range(r + s - l, r - s + l, -1):
            arr[i][c + s - l] = arr[i - 1][c + s - l]

        for j in range(c + s - l, c - s + l + 1, -1):
            arr[r - s + l][j] = arr[r - s + l][j - 1]

        arr[r - s + l][c - s + l + 1] = tmp


def back_rotate(r, c, s):
    for l in range(s):
        tmp = arr[r - s + l][c - s + l]

        for j in range(c - s + l, c + s - l):
            arr[r - s + l][j] = arr[r - s + l][j + 1]

        for i in range(r - s + l, r + s - l):
            arr[i][c + s - l] = arr[i + 1][c + s - l]

        for j in range(c + s - l, c - s + l, -1):
            arr[r + s - l][j] = arr[r + s - l][j - 1]

        for i in range(r + s - l, r - s + l + 1, -1):
            arr[i][c - s + l] = arr[i - 1][c - s + l]

        arr[r - s + l + 1][c - s + l] = tmp


N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

op = [0] * K
for i in range(K):
    r, c, s = map(int, input().split())
    op[i] = [r - 1, c - 1, s]

visited = [0] * K

mn = 5001

btk(0)

print(mn)
