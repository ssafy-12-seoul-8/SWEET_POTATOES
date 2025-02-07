# 스택을 사용하는 문제
# 뒤에서 부터 탐색하며 스택에서 나보다 낮은 건물을 다 빼내고 나+1 ~ 나보다 처음으로 높은것-1까지의 개수를 계속 더한다.
import sys

input = sys.stdin.readline

N = int(input())
h = [int(input()) for _ in range(N)]

stk = []

cnt = 0

for i in range(N - 1, -1, -1):
    if not stk:
        stk.append(i)
    else:
        while stk and h[i] > h[stk[-1]]:
            stk.pop()
        if stk:
            cnt += (stk[-1] - 1 - i)
        else:
            cnt += (N - 1 - i)
        stk.append(i)
print(cnt)
