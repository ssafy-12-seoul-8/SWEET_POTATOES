# 가희가 고구마를 먹고 다시 돌아와야 최적이 될 수도 있다.
# 그렇기에 모든 경우를 따져야 한다.
# 가지치기를 위하여 전체 고구마의 수를 구했다.
import sys

input = sys.stdin.readline


def btk(y, x, cnt, time):                                           # 현재 y좌표, x좌표, 먹은 고구마 수, 시간
    global mx
    if mx == tot:                                                   # 고구마를 다 먹은 경우가 있다면 안봐도 된다.
        return

    if cnt + T - time <= mx:                                        # 매번 1개씩 먹어도 mx가 안되므로 보지 말자
        return

    if time == T:                                                   # 시간 다 되면
        mx = cnt                                                    # mx갱신
        return

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < R and 0 <= nx < C and arr[ny][nx] != "#":
            if arr[ny][nx] == "S":                                  # 갔는데 고구마있으면 먹고 계속하자
                arr[ny][nx] = "."
                btk(ny, nx, cnt + 1, time + 1)
                arr[ny][nx] = "S"                                   # 되돌려 놓자
            else:
                btk(ny, nx, cnt, time + 1)                          # 고구마 없으면 그냥 위치, 시간만 갱신


R, C, T = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(R)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

s_y = -1
s_x = -1
tot = 0
for i in range(R):
    for j in range(C):
        if arr[i][j] == "G":                                        # 가희가 있던 초기 위치만 중요하니까
            s_y = i                                                 # 위치만 뺴고 빈칸으로 만들자
            s_x = j
            arr[i][j] = "."
        elif arr[i][j] == "S":
            tot += 1

mx = 0
btk(s_y, s_x, 0, 0)
print(mx)