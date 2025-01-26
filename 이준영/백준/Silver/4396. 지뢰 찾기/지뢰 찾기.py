dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]

n = int(input())

arr = [[0] * n for _ in range(n)]
click = [[0] * n for _ in range(n)]
result = [["."] * n for _ in range(n)]

for i in range(n):
    arr[i] = list(input())
for i in range(n):
    click[i] = list(input())

bomb_check = False

for i in range(n):
    for j in range(n):
        if click[i][j] == "x" and arr[i][j] == "*":
            bomb_check = True
            break
    if bomb_check:
        break
for i in range(n):
    for j in range(n):
        if click[i][j] == "x":
            if arr[i][j] == ".":
                count = 0
                for k in range(8):
                    ny = i + dy[k]
                    nx = j + dx[k]
                    if 0 <= ny < n and 0 <= nx < n and arr[ny][nx] == "*":
                        count += 1
                result[i][j] = count
            if arr[i][j] == "*":
                result[i][j] = "*"
        else:
            if arr[i][j] == "*" and bomb_check:
                result[i][j] = "*"

for i in range(n):
    for j in range(n):
        print(result[i][j], end="")
    print()
