# 배열의 (i,j)가 돌렸을 때 어디로 갈까 혹은 어디에서 왔을까를 생각하면 직접 배열을 돌리지 않고 해결할 수 있다.
# (i,j)에서 x,y축에 수평인 선을 그려 직사각형을 만든 후 돌리면 좀 더 잘 생각날지도
import sys

input = sys.stdin.readline


def calc(do):
    global N, M
    global arr
    if do == 3 or do == 4:
        tmp = [[0] * N for _ in range(M)]
    else:
        tmp = [[0] * M for _ in range(N)]
    match do:
        case 1:
            for i in range(N):
                for j in range(M):
                    tmp[i][j] = arr[N - 1 - i][j]

        case 2:
            for i in range(N):
                for j in range(M):
                    tmp[i][j] = arr[i][M - 1 - j]

        case 3:
            for i in range(M):
                for j in range(N):
                    tmp[i][j] = arr[N - 1 - j][i]
            N, M = M, N

        case 4:
            for i in range(M):
                for j in range(N):
                    tmp[i][j] = arr[j][M - 1 - i]
            N, M = M, N

        case 5:
            for i in range(N):
                for j in range(M):
                    if i < N // 2 and j < M // 2:  # (i,j)는 4구역에 따라 규칙성이 달라진다.
                        y = i + N // 2
                        x = j
                    elif i < N // 2 and j >= M // 2:
                        y = i
                        x = j - M // 2
                    elif i >= N // 2 and j < M // 2:
                        y = i
                        x = j + M // 2
                    else:
                        y = i - N // 2
                        x = j
                    tmp[i][j] = arr[y][x]

        case 6:
            for i in range(N):
                for j in range(M):
                    if i < N // 2 and j < M // 2:
                        y = i
                        x = j + M // 2
                    elif i < N // 2 and j >= M // 2:
                        y = i + N // 2
                        x = j
                    elif i >= N // 2 and j < M // 2:
                        y = i - N // 2
                        x = j
                    else:
                        y = i
                        x = j - M // 2
                    tmp[i][j] = arr[y][x]
    arr = tmp


N, M, R = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

d = list(map(int, input().split()))
for do in d:
    calc(do)

for i in range(N):
    print(*arr[i])
