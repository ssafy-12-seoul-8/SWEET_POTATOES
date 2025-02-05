# 각 컴퓨터에 대해 bfs를 하여 해킹 가능한 컴퓨터의 수를 계산하였습니다.
import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    visited = [False] * (N + 1)
    dq = deque([start])
    c_cnt = 0
    while dq:
        x = dq.popleft()
        if not visited[x]:
            visited[x] = True
            c_cnt += 1
            for k in road[x]:
                if not visited[k]:
                    dq.append(k)

    return c_cnt


N, M = map(int, input().split())
road = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    road[b].append(a)

mx = 0
lst = []

for i in range(1, N + 1):
    tmp = bfs(i)
    if mx == tmp:               # 현재 최대값과 같다면 리스트에 추가
        lst.append(i)
    elif mx < tmp:              # 더 크다면 최대값리스트 초기화 후 리스트에 추가
        mx = tmp
        lst.clear()
        lst.append(i)
    else:
        continue

print(*lst)