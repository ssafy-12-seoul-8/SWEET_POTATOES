# 중량이 가능하냐 가능하지 않냐로 parametri search
import sys

input = sys.stdin.readline
from collections import deque


def check(a):
    visited = [0] * (N + 1)
    dq = deque([s])
    visited[s] = 1
    while dq:
        cur = dq.popleft()

        for des, w in road[cur].items():
            if visited[des] == 0 and a <= w:
                if des == e:
                    return True
                visited[des] = 1
                dq.append(des)

    return False


N, M = map(int, input().split())
road = [{} for _ in range(N + 1)]
for _ in range(M):
    A, B, C = map(int, input().split())
    if B in road[A]:
        road[A][B] = max(road[A][B], C)
        road[B][A] = max(road[B][A], C)
    else:
        road[A][B] = C
        road[B][A] = C

s, e = map(int, input().split())

start = 0
end = int(1e9) + 1

while end - start > 1:
    mid = (end + start) // 2
    if check(mid):
        start = mid
    else:
        end = mid

print(start)
