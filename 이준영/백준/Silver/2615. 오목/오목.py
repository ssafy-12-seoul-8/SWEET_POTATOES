arr = [list(map(int, input().split())) for _ in range(19)]
win = 0
dy = [-1, 0, 1, 1]
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
            for l in range(1, 5):
                ny = i + dy[k] * l
                nx = j + dx[k] * l
                if 0 <= nx < 19 and 0 <= ny < 19:
                    if arr[ny][nx] == target:
                        cnt += 1
            if cnt < 4:
                continue
            else:
                for a in [-1, 5]:
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
