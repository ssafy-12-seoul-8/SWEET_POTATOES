N, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dy = [0, 0, 0, -1, 1]
dx = [0, 1, -1, 0, 0]

unit = [[[] for _ in range(N)] for _ in range(N)]
loc = [0] * K
for i in range(K):
    y, x, d = map(int, input().split())
    unit[y - 1][x - 1].append([i, d])
    loc[i] = [y - 1, x - 1, 0]

ans = -1
time = 0
flag = False
while time <= 1000:
    time += 1
    for l in range(K):
        y, x, idx = loc[l]
        d = unit[y][x][idx][1]
        ny = y + dy[d]
        nx = x + dx[d]
        if 0 <= ny < N and 0 <= nx < N:
            if arr[ny][nx] == 0:
                t_l = len(unit[ny][nx])
                for k in range(idx, len(unit[y][x])):
                    num, t_d = unit[y][x][k]
                    loc[num] = [ny, nx, t_l + k - idx]
                    unit[ny][nx].append([num, t_d])
                unit[y][x] = unit[y][x][:idx]
                if len(unit[ny][nx]) >= 4:
                    flag = True
                    break
            elif arr[ny][nx] == 1:
                t_l = len(unit[ny][nx])
                cnt = 0
                for k in range(len(unit[y][x]) - 1, idx - 1, -1):
                    num, t_d = unit[y][x][k]
                    loc[num] = [ny, nx, t_l + cnt]
                    unit[ny][nx].append([num, t_d])
                    cnt += 1
                unit[y][x] = unit[y][x][:idx]
                if len(unit[ny][nx]) >= 4:
                    flag = True
                    break

            else:
                ny = y - dy[d]
                nx = x - dx[d]
                if d <= 2:
                    d = 3 - d
                else:
                    d = 7 - d
                unit[y][x][idx][1] = d
                if not (0 <= ny < N and 0 <= nx < N) or arr[ny][nx] == 2:
                    continue
                elif arr[ny][nx] == 0:
                    t_l = len(unit[ny][nx])
                    for k in range(idx, len(unit[y][x])):
                        num, t_d = unit[y][x][k]
                        loc[num] = [ny, nx, t_l + k - idx]
                        unit[ny][nx].append([num, t_d])
                    unit[y][x] = unit[y][x][:idx]
                    if len(unit[ny][nx]) >= 4:
                        flag = True
                        break
                else:
                    t_l = len(unit[ny][nx])
                    cnt = 0
                    for k in range(len(unit[y][x]) - 1, idx - 1, -1):
                        num, t_d = unit[y][x][k]
                        loc[num] = [ny, nx, t_l + cnt]
                        unit[ny][nx].append([num, t_d])
                        cnt += 1
                    unit[y][x] = unit[y][x][:idx]
                    if len(unit[ny][nx]) >= 4:
                        flag = True
                        break
        else:
            ny = y - dy[d]
            nx = x - dx[d]
            if d <= 2:
                d = 3 - d
            else:
                d = 7 - d
            unit[y][x][idx][1] = d

            if not (0 <= ny < N and 0 <= nx < N) or arr[ny][nx] == 2:
                continue
            elif arr[ny][nx] == 0:
                t_l = len(unit[ny][nx])
                for k in range(idx, len(unit[y][x])):
                    num, t_d = unit[y][x][k]
                    loc[num] = [ny, nx, t_l + k - idx]
                    unit[ny][nx].append([num, t_d])
                unit[y][x] = unit[y][x][:idx]
                if len(unit[ny][nx]) >= 4:
                    flag = True
                    break
            else:
                t_l = len(unit[ny][nx])
                cnt = 0
                for k in range(len(unit[y][x]) - 1, idx - 1, -1):
                    num, t_d = unit[y][x][k]
                    loc[num] = [ny, nx, t_l + cnt]
                    unit[ny][nx].append([num, t_d])
                    cnt += 1
                unit[y][x] = unit[y][x][:idx]
                if len(unit[ny][nx]) >= 4:
                    flag = True
                    break
        # for i in range(N):
        #     print(unit[i])
        # print("-" * 100)
    if flag:
        ans = time
        break

    # for i in range(N):
    #     print(unit[i])
    # print("-" * 100)
    # print(loc)
print(ans)
