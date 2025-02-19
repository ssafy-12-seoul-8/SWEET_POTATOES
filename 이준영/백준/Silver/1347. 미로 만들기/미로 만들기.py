N = int(input())
arr = list(input())
y_min = y_max = x_min = x_max = 0
dy = [1, 0, -1, 0]  # 시계방향
dx = [0, -1, 0, 1]
y = 0
x = 0
d = 0
lst = [(0, 0)]
for s in arr:

    if s == "F":
        y = y + dy[d]
        x = x + dx[d]
        y_min = min(y_min, y)
        x_min = min(x_min, x)
        y_max = max(y_max, y)
        x_max = max(x_max, x)
        lst.append((y, x))
    elif s == "L":
        d = (d - 1) % 4
    else:
        d = (d + 1) % 4

ans = [["#"] * (x_max - x_min + 1) for _ in range(y_max - y_min + 1)]
for y, x in lst:
    ans[y - y_min][x - x_min] = "."

for i in range(y_max - y_min + 1):
    print(*ans[i], sep="")
