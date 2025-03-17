from collections import deque

N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
direction = list(map(int, input().split()))
dy = [0, -1, 1, 0, 0]
dx = [0, 0, 0, -1, 1]
ord = [0] * (M + 1)

for i in range(1, M + 1):
    ord[i] = [list(map(int, input().split())) for _ in range(4)]

smell_map = [[set([]) for _ in range(N)] for _ in range(N)]
shark_deque = [deque([]) for _ in range(M + 1)]
shark_dct = [{} for _ in range(M + 1)]

for i in range(N):
    for j in range(N):
        if arr[i][j] != 0:
            num = arr[i][j]
            shark_deque[num].append((i, j))
            smell_map[i][j].add(num)
            arr[i][j] = [arr[i][j], direction[num - 1]]
            shark_dct[num][(i, j)] = 0
        else:
            arr[i][j] = [0, 0]

time = 0
ans = -1

while time < 1000:
    time += 1
    shark_map = [[[0, 0] for _ in range(N)] for _ in range(N)]
    t_loc = []

    for i in range(N):
        for j in range(N):
            num = arr[i][j][0]
            if num > 0:
                flag = False

                for k in ord[num][arr[i][j][1] - 1]:
                    ny = i + dy[k]
                    nx = j + dx[k]

                    if 0 <= ny < N and 0 <= nx < N and not smell_map[ny][nx]:
                        flag = True
                        t_loc.append((num, ny, nx))
                        if not (0 < shark_map[ny][nx][0] < num):
                            shark_map[ny][nx] = [num, k]
                        break

                if flag:
                    continue

                for k in ord[num][arr[i][j][1] - 1]:
                    ny = i + dy[k]
                    nx = j + dx[k]

                    if 0 <= ny < N and 0 <= nx < N and num in smell_map[ny][nx]:
                        t_loc.append((num, ny, nx))
                        if not (0 < shark_map[ny][nx][0] < num):
                            shark_map[ny][nx] = [num, k]
                        break

    if time >= K:
        for i in range(1, M + 1):
            if shark_deque[i]:
                y, x = shark_deque[i].popleft()
                if shark_dct[i][(y, x)] == time - K:
                    smell_map[y][x].remove(i)
                    del shark_dct[i][(y, x)]

    for num, y, x in t_loc:
        smell_map[y][x].add(num)
        shark_dct[num][(y, x)] = time
        shark_deque[num].append((y, x))

    cnt = 0
    for i in range(N):
        for j in range(N):
            num = shark_map[i][j][0]
            if num > 0:
                cnt += 1

    if cnt == 1:
        ans = time
        break

    arr = shark_map

print(ans)
