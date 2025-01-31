C, R = map(int, input().split())
K = int(input())
if R * C < K:
    print(0)
else:
    arr = [[0] * C for _ in range(R)]
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]
    y = R - 1
    x = 0
    cnt = 2
    dir = 0
    arr[y][x] = 1
    if K == 1:
        print(1, 1)
    else:
        while cnt <= R * C:
            ny = y + dy[dir]
            nx = x + dx[dir]
            if 0 <= ny < R and 0 <= nx < C and arr[ny][nx] == 0:
                arr[ny][nx] = cnt
                y = ny
                x = nx
            else:
                dir = (dir + 1) % 4
                ny = y + dy[dir]
                nx = x + dx[dir]
                arr[ny][nx] = cnt
                y, x = ny, nx
            if K == cnt:
                print(x + 1, R - y)
                break
            cnt += 1
