def btk(cur, sm):
    global mn
    if mn <= sm:
        return

    if cur == 100:
        mn = sm
        return

    y = cur // 10
    x = cur % 10
    if arr[y][x] == 0:
        btk(cur + 1, sm)
        return

    pos = [0]
    k = 1
    while k < min(5, 10 - y, 10 - x):
        flag = True
        for i in range(y, y + k + 1):
            if arr[i][x + k] == 0:
                flag = False
                break
        if not flag:
            break
        for j in range(x, x + k):
            if arr[y + k][j] == 0:
                flag = False
                break
        if not flag:
            break
        pos.append(k)
        k = k + 1

    for i in range(len(pos) - 1, -1, -1):
        tmp = pos[i]
        if paper[tmp] > 0:
            paper[tmp] -= 1
            for j in range(tmp + 1):
                for k in range(tmp + 1):
                    arr[y + j][x + k] = 0
            btk(cur + 1, sm + 1)

            for j in range(tmp + 1):
                for k in range(tmp + 1):
                    arr[y + j][x + k] = 1
            paper[tmp] += 1


arr = [list(map(int, input().split())) for _ in range(10)]

paper = [5] * 5

mn = 26
btk(0, 0)

if mn == 26:
    print(-1)
else:
    print(mn)
