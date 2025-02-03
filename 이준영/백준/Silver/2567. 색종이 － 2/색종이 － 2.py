N = int(input())
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
d = 0
arr = [[0] * 101 for _ in range(101)]
min_y = 101
min_x = 101
for _ in range(N):
    x, y = map(int, input().split())
    min_y = min(min_y, y)
    min_x = min(min_x, x)
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            arr[i][j] = 1
cnt = 0
for i in range(101):
    for j in range(101):
        if arr[i][j] == 0:
            continue
        for k in range(4):
            ny = i + dy[k]
            nx = j + dx[k]
            if 0 <= ny < 101 and 0 <= nx < 101:
                if arr[ny][nx] == 0:
                    cnt += 1
            else:
                cnt += 1
print(cnt)
