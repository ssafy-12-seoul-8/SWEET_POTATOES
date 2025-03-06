import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
road = [set([]) for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    road[a].add(b)
    road[b].add(a)

lst = deque(list(map(int, input().split())))
check = 1
dq = deque([1])
visited = [0] * (N + 1)
visited[1] = 1
if lst[0] != 1:
    check = 0
else:
    lst.popleft()
    while dq:
        cur = dq.popleft()
        while lst and lst[0] in road[cur]:
            dq.append(lst.popleft())

    if lst:
        check = 0

print(check)
