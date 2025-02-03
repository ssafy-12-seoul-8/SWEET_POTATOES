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
