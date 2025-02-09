def rotate(i):
    if i == 1:
        dice[0], dice[2], dice[5], dice[3] = dice[3], dice[0], dice[2], dice[5]
    elif i == 2:
        dice[0], dice[2], dice[5], dice[3] = dice[2], dice[5], dice[3], dice[0]
    elif i == 3:
        dice[1], dice[0], dice[4], dice[5] = dice[0], dice[4], dice[5], dice[1]
    else:
        dice[1], dice[0], dice[4], dice[5] = dice[5], dice[1], dice[0], dice[4]


N, M, y, x, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
com = list(map(int, input().split()))

dy = [0, 0, 0, -1, 1]
dx = [0, 1, -1, 0, 0]

dice = [0] * 6

for k in com:
    ny = y + dy[k]
    nx = x + dx[k]

    if 0 <= ny < N and 0 <= nx < M:
        rotate(k)
        y = ny
        x = nx
        if arr[y][x] == 0:
            arr[y][x] = dice[5]
        else:
            dice[5] = arr[y][x]
            arr[y][x] = 0
        print(dice[0])
