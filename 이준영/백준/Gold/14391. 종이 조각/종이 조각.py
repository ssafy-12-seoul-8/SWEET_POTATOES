# 가로로 자를 수도 세로로 자를수도 있다.    
def btk(cur, sm):                                   # 현재위치, 현재까지 합
    global mx
    if cur == N * M:
        mx = max(sm, mx)
        return

    y = cur // M
    x = cur % M

    if visited[y][x] == 1:                          # 방문했으면 넘어가
        btk(cur + 1, sm)
        return

    num = arr[y][x]
    visited[y][x] = 1
    btk(cur + 1, sm + num)                          # 1칸짜리하고 넘어가기
    # 가로 자르기
    last = M - x
    for k in range(1, M - x):
        if visited[y][x + k] == 0:
            visited[y][x + k] = 1
            num = num * 10 + arr[y][x + k]
            btk(cur + 1, sm + num)
        else:
            last = k
            break

    for k in range(1, last):                        # 가로자르기 다했으면 방문표시 해제
        visited[y][x + k] = 0

    # 세로 자르기
    last = N - y
    num = arr[y][x]
    for k in range(1, N - y):
        if visited[y + k][x] == 0:
            visited[y + k][x] = 1
            num = num * 10 + arr[y + k][x]
            btk(cur + 1, sm + num)
        else:
            last = k
            break
    for k in range(1, last):                        # 세로자르기 다했으면 방문표시 해제
        visited[y + k][x] = 0   

    visited[y][x] = 0


N, M = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]

mx = 0
visited = [[0] * M for _ in range(N)]

btk(0, 0)

print(mx)
