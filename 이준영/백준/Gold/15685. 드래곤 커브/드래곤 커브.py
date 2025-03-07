N = int(input())
dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

square = [[0] * 101 for _ in range(101)]

dragon = [0] * 11
dragon[0] = [0]
for i in range(1, 11):
    dragon[i] = dragon[i - 1][:]
    for k in dragon[i - 1][::-1]:
        dragon[i].append((k + 1) % 4)

for _ in range(N):
    x, y, d, g = map(int, input().split())
    square[y][x] = 1
    for k in dragon[g]:
        tmp = (k + d) % 4
        y = y + dy[tmp]
        x = x + dx[tmp]

        square[y][x] = 1

cnt = 0
for i in range(100):
    for j in range(100):
        check = 0
        for y, x in ((i, j), (i, j + 1), (i + 1, j), (i + 1, j + 1)):
            if square[y][x] == 1:
                check += 1
        if check == 4:
            cnt += 1

print(cnt)
