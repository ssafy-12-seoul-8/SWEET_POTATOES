# 그냥 같이 돌아가는 애들을 순서대로 리스트에 넣은 후 index를 R만큼 옮기면 되지 않을까?
import sys

input = sys.stdin.readline


def rotate():
    for l in range(min(M, N) // 2):
        s_y, s_x = l, l
        x_len = M - 2 * l
        y_len = N - 2 * l
        lst = [arr[s_y][s_x]]  # 리스트에 넣고

        for i in range(x_len - 1):
            lst.append(arr[s_y][s_x + 1 + i])
        for i in range(y_len - 1):
            lst.append(arr[s_y + 1 + i][s_x + x_len - 1])
        for i in range(x_len - 1):
            lst.append(arr[s_y + y_len - 1][s_x + x_len - 2 - i])
        for i in range(y_len - 2):
            lst.append(arr[s_y + y_len - 2 - i][s_x])

        t_l = len(lst)
        arr[s_y][s_x] = lst[R % t_l]  # 회전하며 넣는다.
        for i in range(x_len - 1):
            arr[s_y][s_x + 1 + i] = lst[(1 + i + R) % t_l]
        for i in range(y_len - 1):
            arr[s_y + 1 + i][s_x + x_len - 1] = lst[(x_len + i + R) % t_l]
        for i in range(x_len - 1):
            arr[s_y + y_len - 1][s_x + x_len - 2 - i] = lst[(x_len + y_len - 1 + i + R) % t_l]
        for i in range(y_len - 2):
            arr[s_y + y_len - 2 - i][s_x] = lst[(2 * x_len + y_len + i - 2 + R) % t_l]


N, M, R = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

rotate()

for i in range(N):
    print(*arr[i])
