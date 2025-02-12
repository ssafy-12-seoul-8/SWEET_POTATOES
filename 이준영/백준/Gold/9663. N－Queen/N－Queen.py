# 퀸은 하나의 행에 하나만 놓을 수 있기 떄문에 각 행에 놓을 위치를 선정해주면 된다.
# 그 과정에서 같은 열에 퀸이 없고 두 대각선 방향으로도 퀸이 없어야 한다.
import sys

sys.setrecursionlimit(10000)


def btk(cur):
    global cnt
    if cur >= N:
        cnt += 1
        return
    for j in range(N):
        if col[j] and diag1[cur - j + N - 1] and diag2[cur + j]:
            col[j] = diag1[cur - j + N - 1] = diag2[cur + j] = False
            btk(cur + 1)
            col[j] = diag1[cur - j + N - 1] = diag2[cur + j] = True


N = int(input())
cnt = 0
col = [True] * N
diag1 = [True] * (2 * N - 1)  # 정방향대각선 (오른쪽 아래)
diag2 = [True] * (2 * N - 1)  # 역방향대각선 (왼쪽 아래)
btk(0)
print(cnt)
