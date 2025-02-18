# 문제에서 하란대로 재귀적으로 구현해보자
# 만약 주어진 영역이 모두 같은 점으로 이루어져 있다면 그 점에 해당하는 좌표를 리턴한다.
# 그렇지 않다면 ()로 전체가 둘러싸져야 하고 4영역으로 나누어 나온 결과를 합쳐서 리턴한다.
import sys

input = sys.stdin.readline


def quad(l, y, x):                                                  # (길이, 왼쪽 위 y좌표, 왼쪽 위 x좌표)
    if l == 1:
        return arr[y][x]

    for i in range(y, y + l):
        for j in range(x, x + l):
            if arr[i][j] != arr[y][x]:
                tmp = ["("]
                tmp.append(quad(l // 2, y, x))
                tmp.append(quad(l // 2, y, x + l // 2))
                tmp.append(quad(l // 2, y + l // 2, x))
                tmp.append(quad(l // 2, y + l // 2, x + l // 2))
                tmp.append(")")
                return "".join(tmp)

    return arr[y][x]


N = int(input())
arr = [list(input().rstrip()) for _ in range(N)]

ans = quad(N, 0, 0)
print(ans)
