def move_left(a):
    tmp = [[0] * N for _ in range(N)]
    for i in range(N):
        stk = []
        for j in range(N):
            if a[i][j] == 0:
                continue
            if not stk:
                stk.append(a[i][j])
            elif stk[-1] == a[i][j]:
                stk.pop()
                stk.extend((2 * a[i][j], 0))
            else:
                stk.append(a[i][j])

        k = 0
        for j in stk:
            if j == 0:
                continue
            tmp[i][k] = j
            k += 1

    t_mx = max(map(max, tmp))

    return tmp, t_mx


def move_right(a):
    tmp = [[0] * N for _ in range(N)]
    for i in range(N):
        stk = []
        for j in range(N - 1, -1, -1):
            if a[i][j] == 0:
                continue
            if not stk:
                stk.append(a[i][j])
            elif stk[-1] == a[i][j]:
                stk.pop()
                stk.extend((2 * a[i][j], 0))
            else:
                stk.append(a[i][j])

        k = N - 1
        for j in stk:
            if j == 0:
                continue
            tmp[i][k] = j
            k -= 1

    t_mx = max(map(max, tmp))

    return tmp, t_mx


def move_up(a):
    tmp = [[0] * N for _ in range(N)]
    for j in range(N):
        stk = []
        for i in range(N):
            if a[i][j] == 0:
                continue
            if not stk:
                stk.append(a[i][j])
            elif stk[-1] == a[i][j]:
                stk.pop()
                stk.extend((2 * a[i][j], 0))
            else:
                stk.append(a[i][j])

        k = 0
        for i in stk:
            if i == 0:
                continue
            tmp[k][j] = i
            k += 1

    t_mx = max(map(max, tmp))

    return tmp, t_mx


def move_down(a):
    tmp = [[0] * N for _ in range(N)]
    for j in range(N):
        stk = []
        for i in range(N - 1, -1, -1):
            if a[i][j] == 0:
                continue
            if not stk:
                stk.append(a[i][j])
            elif stk[-1] == a[i][j]:
                stk.pop()
                stk.extend((2 * a[i][j], 0))
            else:
                stk.append(a[i][j])

        k = N - 1
        for i in stk:
            if i == 0:
                continue
            tmp[k][j] = i
            k -= 1

    t_mx = max(map(max, tmp))

    return tmp, t_mx


def btk(cur, mx_num, a):
    global mx

    mx = max(mx, mx_num)
    if cur == 5:
        return

    tmp, t_num = move_left(a)
    btk(cur + 1, t_num, tmp)
    tmp, t_num = move_right(a)
    btk(cur + 1, t_num, tmp)
    tmp, t_num = move_up(a)
    btk(cur + 1, t_num, tmp)
    tmp, t_num = move_down(a)
    btk(cur + 1, t_num, tmp)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

mx = max(map(max, arr))

btk(0, mx, arr)

print(mx)
