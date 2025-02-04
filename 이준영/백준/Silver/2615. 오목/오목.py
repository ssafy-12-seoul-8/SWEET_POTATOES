arr = [list(map(int, input().split())) for _ in range(19)]
win = 0
dy = [-1, 0, 1, 1]          # 궁금한 것이 가장 왼쪽 돌의 좌표이므로 그 돌을 기준으로 4방향을 탐색하면 된다.
dx = [1, 1, 1, 0]
col = 0
row = 0

for i in range(19):
    for j in range(19):
        if win != 0:
            break
        if arr[i][j] == 0:
            continue
        target = arr[i][j]

        for k in range(4):
            cnt = 0
            for l in range(1, 5):                   # 오목이 완성되었는가를 판단
                ny = i + dy[k] * l
                nx = j + dx[k] * l
                if 0 <= nx < 19 and 0 <= ny < 19:
                    if arr[ny][nx] == target:
                        cnt += 1
            if cnt < 4:
                continue
            else:                                   # 오목이 완성되었다면
                for a in [-1, 5]:                   # 6목이 아닌지를 판별해보고 검사한다.
                    ny = i + dy[k] * a
                    nx = j + dx[k] * a
                    if 0 <= nx < 19 and 0 <= ny < 19 and arr[ny][nx] == target:
                        break
                else:
                    win = target
                    col = i + 1
                    row = j + 1
    if win != 0:
        break

if win == 0:
    print(0)
else:
    print(win)
    print(col, row)
