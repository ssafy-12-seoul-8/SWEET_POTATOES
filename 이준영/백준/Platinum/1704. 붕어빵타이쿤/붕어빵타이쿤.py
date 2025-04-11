import sys

input = sys.stdin.readline


def button(list1, y, x):
    for i in range(5):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < N and 0 <= nx < M:
            if list1[ny][nx] == 1:
                list1[ny][nx] = 0
            else:
                list1[ny][nx] = 1


def check(num):
    cnt2 = 0
    arr2 = [row[:] for row in arr]
    ans = [[0] * M for _ in range(N)]
    for i in range(M):
        if (num & (1 << (M - 1 - i))) != 0:
            cnt2 += 1
            button(arr2, 0, i)
            ans[0][i] = 1

    for i in range(1, N):
        for j in range(M):
            if arr2[i - 1][j] == 1:
                cnt2 += 1
                button(arr2, i, j)
                ans[i][j] = 1

    for j in range(M):
        if arr2[N - 1][j] == 1:
            return -1, []

    return cnt2, ans


N, M = map(int, input().split())

count = 226
dx = [0, 0, 0, 1, -1]
dy = [0, 1, -1, 0, 0]

arr = [list(map(int, input().split())) for _ in range(N)]
real_ans = []
for i in range(1 << M):
    cnt2, ans = check(i)
    if cnt2 == -1:
        continue
    if count > cnt2:
        count = cnt2
        real_ans = ans

if count == 226:
    print("IMPOSSIBLE")
else:
    for i in range(N):
        print(*real_ans[i])
