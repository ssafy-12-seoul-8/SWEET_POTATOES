import sys
from heapq import heappush, heappop

input = sys.stdin.readline


def btk(cur, mn_p, sm):
    global mn
    if mn <= mn_p:
        return

    if cur == B:
        mn = min(mn, mn_p)
        return

    for des, dis in road[cur]:
        if visited[des] == 0 and sm + dis <= C:
            visited[des] = 1
            btk(des, max(mn_p, dis), sm + dis)
            visited[des] = 0


N, M, A, B, C = map(int, input().split())

road = [[] for _ in range(N + 1)]

for _ in range(M):
    s, e, price = map(int, input().split())
    road[s].append((e, price))
    road[e].append((s, price))

mn = 1001
visited = [0] * (N + 1)
visited[A] = 1
btk(A, 0, 0)

if mn == 1001:
    print(-1)
else:
    print(mn)
