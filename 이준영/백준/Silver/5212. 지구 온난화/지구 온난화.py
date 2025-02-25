R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]
ans = [["."] * C for _ in range(R)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

mn_y = R
mn_x = C
mx_y = -1
mx_x = -1

for i in range(R):
    for j in range(C):
        if arr[i][j] == "X":
            cnt = 0
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < R and 0 <= nx < C:
                    if arr[ny][nx] == ".":
                        cnt += 1
                else:
                    cnt += 1

            if cnt <= 2:
                ans[i][j] = "X"
                mn_y = min(i, mn_y)
                mn_x = min(j, mn_x)
                mx_y = max(i, mx_y)
                mx_x = max(j, mx_x)

for i in range(mn_y, mx_y + 1):
    for j in range(mn_x, mx_x + 1):
        print(ans[i][j], end="")
    print()
