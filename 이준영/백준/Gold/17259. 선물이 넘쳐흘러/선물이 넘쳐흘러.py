import sys

input = sys.stdin.readline
B, N, M = map(int, input().split())

dy = [1, 0, -1]
dx = [0, 1, 0]

emp = [[0] * 4 for _ in range(N)]
arr = [[0] * B for _ in range(B)]

for i in range(N):
    a, b, c = map(int, input().split())
    emp[i] = [a, b, c, 0]

belt = []
for i in range(B):
    belt.append((0, i))
for i in range(1, B):
    belt.append((i, B - 1))
for i in range(B - 2, -1, -1):
    belt.append((B - 1, i))

l = len(belt)
cnt = 0
for time in range(M + 3 * B + 1):
    for i in range(l - 1, 0, -1):
        y1, x1 = belt[i]
        y2, x2 = belt[i - 1]
        arr[y1][x1] = arr[y2][x2]

    if time < M:
        arr[0][0] = 1
    else:
        arr[0][0] = 0

    for i in range(N):
        if emp[i][2] == 1:
            for k in range(3):
                ny = emp[i][0] + dy[k]
                nx = emp[i][1] + dx[k]
                if arr[ny][nx] == 1:
                    arr[ny][nx] = 0
                    emp[i][3] = 1
                    cnt += 1
                    break
        else:
            if emp[i][3] >= 1:
                emp[i][3] += 1
                if emp[i][3] == emp[i][2]:
                    emp[i][3] = 0
            else:
                for k in range(3):
                    ny = emp[i][0] + dy[k]
                    nx = emp[i][1] + dx[k]
                    if arr[ny][nx] == 1:
                        arr[ny][nx] = 0
                        emp[i][3] = 1
                        cnt += 1
                        break

print(cnt)
