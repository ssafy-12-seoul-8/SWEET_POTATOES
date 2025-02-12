import sys
input = sys.stdin.readline

T = int(input())
dy = [-1, 0, 1, 0]                  # 위를 기준으로 시계 방향 회전
dx = [0, 1, 0, -1]

for _ in range(T):
    y = 0
    x = 0
    d = 0
    mn_y = mn_x = mx_y = mx_x = 0

    s = input().rstrip()
    for i in s:
        if i == "L":                # 좌회전
            d = (d - 1) % 4
        elif i == "R":              # 우회전
            d = (d + 1) % 4
        else:                       # 나머지는 y,x좌표가 바뀌므로 최소,최대 y,x 갱신
            if i == "F":
                y = y + dy[d]
                x = x + dx[d]
            else:
                y = y - dy[d]
                x = x - dx[d]

            mn_y = min(mn_y, y)
            mn_x = min(mn_x, x)
            mx_y = max(mx_y, y)
            mx_x = max(mx_x, x)

    print((mx_y - mn_y) * (mx_x - mn_x))
