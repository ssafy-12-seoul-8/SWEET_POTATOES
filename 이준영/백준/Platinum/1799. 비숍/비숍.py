import sys

input = sys.stdin.readline
sys.setrecursionlimit(10000)

def btk1(cur, cnt):
    global mx1

    if mx1 >= cnt + l1 - cur:
        return

    if cur == l1:
        mx1 = max(mx1, cnt)
        return

    y, x = lst1[cur]
    if diag1[y + x] and diag2[y - x + N - 1]:
        diag1[y + x] = False
        diag2[y - x + N - 1] = False
        btk1(cur + 1, cnt + 1)
        diag1[y + x] = True
        diag2[y - x + N - 1] = True

    btk1(cur + 1, cnt)


def btk2(cur, cnt):
    global mx2

    if mx2 >= cnt + l2 - cur:
        return

    if cur == l2:
        mx2 = max(mx2, cnt)
        return

    y, x = lst2[cur]
    if diag1[y + x] and diag2[y - x + N - 1]:
        diag1[y + x] = False
        diag2[y - x + N - 1] = False
        btk2(cur + 1, cnt + 1)
        diag1[y + x] = True
        diag2[y - x + N - 1] = True

    btk2(cur + 1, cnt)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

lst1 = []
lst2 = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            if (i + j) % 2 == 0:
                lst1.append((i, j))
            else:
                lst2.append((i, j))

diag1 = [True] * (2 * N - 1)
diag2 = [True] * (2 * N - 1)

l1 = len(lst1)
l2 = len(lst2)
mx1 = 0
mx2 = 0

btk1(0, 0)
btk2(0, 0)

print(mx1 + mx2)
