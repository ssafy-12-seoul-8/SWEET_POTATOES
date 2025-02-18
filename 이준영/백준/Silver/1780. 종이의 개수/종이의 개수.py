# 종이 자르기 문제를 3번 자르는 걸로 바꾼것이다.
# 일반화하여 k번 자르기로 바꿔도 내부에서 이중 for문을 한번 더 써주면 된다.
import sys

input = sys.stdin.readline


def f(l, y, x):
    if l == 1:
        cnt[arr[y][x] + 1] += 1
        return

    for i in range(y, y + l):
        for j in range(x, x + l):
            if arr[i][j] != arr[y][x]:
                for k in range(3):
                    for w in range(3):
                        f(l // 3, y + l // 3 * k, x + l // 3 * w)

                return

    cnt[arr[y][x] + 1] += 1


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

cnt = [0] * 3

f(N, 0, 0)

for i in range(3):
    print(cnt[i])
