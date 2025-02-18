# 2*2이면 4개 중 2번째로 큰 수 리턴
# 이보다 크면 크게 4등분하여 후보군 4개 가겨오고 그 중 2번째로 큰 수 리턴
import sys

input = sys.stdin.readline


def second(l, y, x):
    if l == 2:
        lst = [arr[y][x], arr[y][x + 1], arr[y + 1][x], arr[y + 1][x + 1]]
        lst.sort()
        return lst[2]

    num1 = second(l // 2, y, x)
    num2 = second(l // 2, y, x + l // 2)
    num3 = second(l // 2, y + l // 2, x)
    num4 = second(l // 2, y + l // 2, x + l // 2)

    lst = [num1, num2, num3, num4]
    lst.sort()
    return lst[2]


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

ans = second(N, 0, 0)
print(ans)
