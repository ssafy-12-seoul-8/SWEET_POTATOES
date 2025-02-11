def btk(cur, cnt):                   # 현재 계란, 깨진 계란 수
    global mx

    if 2 * (N - cur) + cnt < mx:     # 한번 내리칠 때마다 최대 2개씩 깨짐  
        return                       # 다 깨도 최대에 못미침

    if cur == N:
        mx = max(mx, cnt)
        return

    if arr[cur][0] <= 0:             # 현재 계란이 깨짐
        btk(cur + 1, cnt)
        return

    s1, w1 = arr[cur]
    check = False                    # 다른 계란 중 깨진게 있는가

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

    if check:                           # 하나라도 깨져 있다.
        return

    btk(cur + 1, cnt)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

mx = 0
btk(0, 0)

print(mx)
