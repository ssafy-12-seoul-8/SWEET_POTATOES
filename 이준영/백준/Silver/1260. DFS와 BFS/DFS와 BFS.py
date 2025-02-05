# 각각 스택과 덱을 사용하여 풀었습니다.
# 함수의 구성을 보면 스택과 덱을 제외한 대부분이 동일함을 확인할 수 있습니다. (오름차순으로 방문해야 해서 스택의 정점은
# 역순으로 탐방)

import sys
from collections import deque

input = sys.stdin.readline


def dfs(start):
    visited = [False] * (N + 1)
    stk = [start]
    ans = []

    while stk:
        tmp = stk.pop()
        if not visited[tmp]:
            visited[tmp] = True
            ans.append(tmp)
            for i in reversed(road[tmp]):           # 오름차순으로 방문하기 위해서 역순으로 탐방
                if not visited[i]:
                    stk.append(i)
    return ans


def bfs(start):
    visited = [False] * (N + 1)
    dq = deque([start])
    ans = []

    while dq:
        tmp = dq.popleft()
        if not visited[tmp]:
            visited[tmp] = True
            ans.append(tmp)
            for i in road[tmp]:
                if not visited[i]:
                    dq.append(i)
    return ans


N, M, V = map(int, input().split())
road = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())        # 양 방향 그래프이므로 서로를 추가
    road[a].append(b)
    road[b].append(a)

for i in range(N + 1):
    road[i].sort()

ans1 = dfs(V)
ans2 = bfs(V)
print(*ans1)
print(*ans2)
