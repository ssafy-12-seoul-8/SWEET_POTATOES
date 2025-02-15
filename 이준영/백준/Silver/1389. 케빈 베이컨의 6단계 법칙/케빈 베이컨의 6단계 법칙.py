# 각각의 사람에 대해 bfs를 하여 케빈베이컨 수를 계산한 후 가장 작은 사람을 구하면 된다.
import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    cnt = 0
    visited = [0] * (N + 1)
    visited[start] = 1
    dq = deque([(start, 0)])                                    # 각 사람을 만날떄마다 거리를 cnt에 더하기 위해
    while dq:                                                   # dq에 위치와 거리를 함꼐 넣었다.
        cur, dis = dq.popleft()
        for i in friend[cur]:
            if visited[i] == 0:
                visited[i] = 1
                cnt += (dis + 1)
                dq.append((i, dis + 1))

    return cnt


N, M = map(int, input().split())
friend = [set([]) for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    friend[a].add(b)
    friend[b].add(a)

num = [0] * (N + 1)
for i in range(1, N + 1):
    num[i] = bfs(i)

mn_idx = 1
for i in range(2, N + 1):
    if num[mn_idx] > num[i]:                                        # 같다면 번호가 가장 낮은 사람을 고르라고 했기에 등호 제외
        mn_idx = i                                                  # 번호가 가장 높은 사람을 뽑으라 했으면 등호 넣으면 된다.

print(mn_idx)
