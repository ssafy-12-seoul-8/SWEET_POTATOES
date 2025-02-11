def btk(cur, sm):                                           # 가능한 것만 들어온다. (상담을 시작할 날짜, 지금까지의 합)
    global mx

    mx = max(mx, sm)                                        # 갱신

    if cur >= N:                                            # 상담시작할 날짜 지나서 리턴
        return

    btk(cur + 1, sm)                                        # 오늘 상담 안함
    if cur + arr[cur][0] - 1 < N:                           # 오늘 상담 가능하면 하는 경우
        btk(cur + arr[cur][0], sm + arr[cur][1])


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

mx = 0
btk(0, 0)
print(mx)
