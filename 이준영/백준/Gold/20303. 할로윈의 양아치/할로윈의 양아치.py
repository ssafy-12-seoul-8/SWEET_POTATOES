# bfs + dp로 풀었습니다.
# bfs를 통해 각 친구 그룹의 (사람수,사탕수)를 계산하였고 K-1명 이하의 조합에서 최대 사탕수를
# 배낭문제와 같은 dp로 해결하였습니다.
import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
    p_cnt = 0
    c_cnt = 0
    dq = deque([start])
    while dq:
        tmp = dq.popleft()
        if not visited[tmp]:
            visited[tmp] = True
            p_cnt += 1
            c_cnt += arr[tmp]
            for i in road[tmp]:
                if not visited[i]:
                    dq.append(i)

    return p_cnt, c_cnt


N, M, K = map(int, input().split())
arr = [0]
arr.extend(list(map(int, input().split())))
road = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    road[a].append(b)
    road[b].append(a)

candy = []
visited = [False] * (N + 1)
for i in range(1, N + 1):
    if not visited[i]:
        p, c = bfs(i)
        candy.append((p, c))

l = len(candy)
dp = [[0] * K for _ in range(l + 1)]

for i in range(1, l + 1):
    for j in range(1, K):
        if j < candy[i - 1][0]:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], candy[i - 1][1] + dp[i - 1][j - candy[i - 1][0]])

print(dp[l][K - 1])
