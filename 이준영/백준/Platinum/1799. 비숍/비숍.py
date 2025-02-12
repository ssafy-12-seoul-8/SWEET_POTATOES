# 생각해보면 흑색 칸에 놓인 비숍과 백색 칸에 놓인 비숍은 서로 영향을 주지 못한다.
# 따라서 백트래킹을 할 때 두 부분으로 나눠서 하는 것이 시간이 절약된다.
# 따라서 처음에 비숍이 들어갈 수 있는 부분을 받을 때도 이를 나누어 lst1과 lst2에 나누어 받았습니다.
# 재제출
import sys

input = sys.stdin.readline
sys.setrecursionlimit(10000)

def btk1(cur, cnt):                             # 흑색칸 백트래킹(첫 칸이 속함)
    global mx1

    if mx1 >= cnt + l1 - cur:                   # 나머지 비숍을 다 놓아도 갱신 안됨
        return

    if cur == l1:                               # 끝까지 놓았으니 이 때 mx1 갱신
        mx1 = max(mx1, cnt)
        return

    y, x = lst1[cur]
    if diag1[y + x] and diag2[y - x + N - 1]:   # 만약 그 칸을 지나는 두 대각선에 비숍이 없다면 넣을 수 있다.
        diag1[y + x] = False
        diag2[y - x + N - 1] = False
        btk1(cur + 1, cnt + 1)
        diag1[y + x] = True
        diag2[y - x + N - 1] = True

    btk1(cur + 1, cnt)                          # 그 칸을 건너띈다.


def btk2(cur, cnt):                             # 백색 칸 백트래킹 (2번째 칸이 속함)
    global mx2                                  # btk1과 내부 로직이 동일

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

diag1 = [True] * (2 * N - 1)                    # 왼쪽 아래로 가는 대각선
diag2 = [True] * (2 * N - 1)                    # 오른쪽 아래로 가는 대각선

l1 = len(lst1)
l2 = len(lst2)
mx1 = 0
mx2 = 0

btk1(0, 0)
btk2(0, 0)

print(mx1 + mx2)
