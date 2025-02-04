# n각형을 하나의 꼭짓점에서 나머지 꼭짓점을 연결하여 n-2개의 삼각형으로 나눈다.
# 각 삼각형의 넓이는 벡터의 외적 혹은 신발끈 공식을 이용하여 구한다.
import sys

input = sys.stdin.readline


def area(i, j, k):
    x1, y1 = arr[i]
    x2, y2 = arr[j]
    x3, y3 = arr[k]
    return (x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3) / 2


N = int(input())
arr = [0] * N
for i in range(N):
    arr[i] = list(map(int, input().split()))

S = 0
for i in range(N - 2):
    S = S + area(0, i + 1, i + 2)

S = abs(int(S * 100))
if S % 10 >= 5:
    S = (S // 10 + 1) * 10
else:
    S = (S // 10) * 10
print(S / 100)
