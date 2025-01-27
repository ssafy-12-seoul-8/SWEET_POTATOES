dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
R, C = map(int, input().split())
arr = [0] * R
result = [["."] * C for _ in range(R)]
for i in range(R):
    arr[i] = list(input())
min_row = 11
min_col = 11
max_row = 0
max_col = 0
for i in range(R):
    for j in range(C):
        if arr[i][j] == "X":
            count = 0
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < R and 0 <= nx < C:
                    if arr[ny][nx] == ".":
                        count += 1
                else:
                    count += 1
            if count <= 2:
                result[i][j] = "X"
                min_col = min(min_col, i)
                max_col = max(max_col, i)
                min_row = min(min_row, j)
                max_row = max(max_row, j)
for i in range(min_col, max_col + 1):
    for j in range(min_row, max_row + 1):
        print(result[i][j], end="")
    print()
