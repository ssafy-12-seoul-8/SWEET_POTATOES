dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
N = int(input())
M = int(input())
result = [[0] * N for _ in range(N)]
dir = 0
num = 1
y = x = N // 2
result[y][x] = 1
if M == 1:
    ans_y = ans_x = N // 2
for i in range(1, N):
    for j in range(2):
        for k in range(1, i + 1):
            num += 1
            y = y + dy[dir]
            x = x + dx[dir]
            result[y][x] = num
            if num == M:
                ans_y = y
                ans_x = x
        dir = (dir + 1) % 4
for i in range(N - 1):
    num += 1
    y = y + dy[dir]
    x = x + dx[dir]
    result[y][x] = num
    if num == M:
        ans_y = y
        ans_x = x
for i in range(N):
    for j in range(N):
        print(result[i][j], end=" ")
    print()
print(ans_y + 1, ans_x + 1)
