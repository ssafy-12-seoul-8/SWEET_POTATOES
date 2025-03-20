def myprint(arr):
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            print("%-3s" % arr[i][j], end="")
        print()
    print("-" * 50)


def check():
    mx = -1
    mn = int(1e9)
    mn_lst = []
    for i in range(N):
        if mx < lst[i]:
            mx = lst[i]

        if mn == lst[i]:
            mn_lst.append(i)
        elif mn > lst[i]:
            mn = lst[i]
            mn_lst = [i]

    if mx - mn <= K:
        return True
    for i in mn_lst:
        lst[i] += 1
    return False


def change1(lst):
    arr = [[0] * (N - 2) for _ in range(2)]
    arr[1] = lst[2:]
    arr[0][0], arr[0][1] = lst[1], lst[0]
    y, x, z = 2, 2, N - 4
    while True:
        if y > z:
            return arr

        t_arr = [[0] * z for _ in range(x + 1)]
        t_arr[x] = arr[y - 1][x:]
        for i in range(x):
            for j in range(y):
                t_arr[i][j] = arr[y - 1 - j][i]

        x, y, z = y, x + 1, z - y
        arr = t_arr

    return arr


def divide(arr):
    n = len(arr)
    m = len(arr[0])
    tmp_arr = [row[:] for row in arr]

    for i in range(n):
        for j in range(m):
            if tmp_arr[i][j] == 0:
                continue
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < n and 0 <= nx < m and tmp_arr[ny][nx] > 0:
                    if tmp_arr[ny][nx] > tmp_arr[i][j]:
                        arr[i][j] += ((tmp_arr[ny][nx] - tmp_arr[i][j]) // 5)
                    else:
                        arr[i][j] -= ((tmp_arr[i][j] - tmp_arr[ny][nx]) // 5)

    t_lst = [0] * N
    k = 0
    for j in range(m):
        for i in range(n - 1, -1, -1):
            if k == N:
                break
            if arr[i][j] > 0:
                t_lst[k] = arr[i][j]
                k += 1

        if k == N:
            break

    return t_lst


def change2(lst):
    k = N // 4
    tmp_arr = [[0] * k for _ in range(4)]
    for j in range(k):
        tmp_arr[0][j] = lst[3 * k - 1 - j]
        tmp_arr[1][j] = lst[k + j]
        tmp_arr[2][j] = lst[k - 1 - j]
        tmp_arr[3][j] = lst[3 * k + j]

    return tmp_arr

N, K = map(int, input().split())
lst = list(map(int, input().split()))
t = 0
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
while True:
    if check():
        break

    t += 1

    arr = change1(lst)

    lst = divide(arr)

    arr = change2(lst)
    lst = divide(arr)

print(t)
