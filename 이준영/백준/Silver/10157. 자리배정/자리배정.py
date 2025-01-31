C, R = map(int, input().split())
K = int(input())
if R * C < K:
    print(0)
else:
    arr = [[0] * C for _ in range(R)]
    dy = [-1, 0, 1, 0]                # (dy,dx)는 각각 위, 오른쪽, 아래, 왼쪽 방향을 의미함
    dx = [0, 1, 0, -1]
    y = R - 1
    x = 0
    cnt = 2
    dir = 0                           # 방향의 인덱스
    arr[y][x] = 1
    if K == 1:
        print(1, 1)
    else:
        while cnt <= R * C:
            ny = y + dy[dir]
            nx = x + dx[dir]
            if 0 <= ny < R and 0 <= nx < C and arr[ny][nx] == 0: # 이 방향으로 나아가는게 옳은 방향
                arr[ny][nx] = cnt
                y = ny
                x = nx
            else:                                                # 기존의 방향에서 방향을 시계 방향으로 90도 회전해서 가야함
                dir = (dir + 1) % 4
                ny = y + dy[dir]
                nx = x + dx[dir]
                arr[ny][nx] = cnt
                y, x = ny, nx
            if K == cnt:
                print(x + 1, R - y)                               # 우리가 다루는 좌표가 문제의 좌표와 달라 조정해준다.
                break
            cnt += 1
