def btk(cur, cnt):
    global mx

    if 2 * (N - cur) + cnt < mx:
        return

    if cur == N:
        mx = max(mx, cnt)
        return

    if arr[cur][0] <= 0:
        btk(cur + 1, cnt)
        return

    s1, w1 = arr[cur]
    check = False

    for i in range(N):
        if i == cur or arr[i][0] <= 0:
            continue

        s2, w2 = arr[i]
        check = True
        arr[cur][0] = s1 - w2
        arr[i][0] = s2 - w1

        tmp = cnt
        if s1 - w2 <= 0:
            tmp += 1
        if s2 - w1 <= 0:
            tmp += 1

        btk(cur + 1, tmp)
        arr[cur][0] = s1
        arr[i][0] = s2

    if check:
        return

    btk(cur + 1, cnt)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

mx = 0
btk(0, 0)

print(mx)
