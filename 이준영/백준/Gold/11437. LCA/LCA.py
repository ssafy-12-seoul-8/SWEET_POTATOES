# 최소 공통 조상 문제 심화버전 풀이입니다. (일반 풀이는 이전 코드를 참조해 주세요)
# 일반적인 트리의 경우 깊이가 N수준까지 내려갈 수 있어 올라오는게 굉장히 비효율적일 수 있습니다.
# 그렇다고 모든 조상을 다 저장하는 건 메모리를 많이 잡아먹습니다.
# 따라서 2의 거듭제곱에 해당하는 부모만 저장하는 방법을 채택합니다. (높이를 맞출 때도 동일 합니다.)

import sys
from collections import deque

input = sys.stdin.readline

sys.setrecursionlimit(50000)


def fill(n, d):
    depth[n] = d
    for i in child[n]:
        fill(i, d + 1)  # 자식에 대해 깊이를 1 증가시킨 후 재귀


N = int(input())  # par[i][j]: i의 2^j번째 조상
par = [[0] * 21 for _ in range(N + 1)]  # 2**20이 100만 정도이기에 보통 21을 많이 잡습니다. 이 문제에서는 10000이기 때문에 14정도로 잡아도 됩니다.
child = [[] for _ in range(N + 1)]
depth = [0] * (N + 1)
road = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    a, b = map(int, input().split())
    road[a].append(b)
    road[b].append(a)

visited = [0] * (N + 1)
dq = deque([1])
visited[1] = 1
while dq:
    cur = dq.popleft()
    for a in road[cur]:
        if visited[a] == 0:
            visited[a] = 1
            par[a][0] = cur
            child[cur].append(a)
            dq.append(a)

for i in range(1, 21):
    for j in range(1, N + 1):
        par[j][i] = par[par[j][i - 1]][i - 1]  # 나의 2**i번째 조상은 나의 2**(i-1)번째 조상의 2**(i-1)번째 조상이다.

fill(1, 0)
M = int(input())
for _ in range(M):
    x, y = map(int, input().split())

    if depth[x] > depth[y]:  # 편의를 위해 x가 깊이가 더 얕게 설정
        x, y = y, x

    for i in range(20, -1, -1):
        if depth[y] - depth[x] >= (1 << i):  # 만약 높이차이가 2^i이상이면 y를 y의 2^i번째 조상으로 끌어 올린다.
            y = par[y][i]

    if y == x:  # 높이를 맞췄을 때 값이 같다면 이를 출력합니다.
        print(y)
    else:  # 만약 2^i번째 부모가 서로 다르면 끌어올립니다.
        for i in range(20, -1, -1):
            if par[y][i] != par[x][i]:
                y = par[y][i]
                x = par[x][i]

        print(par[x][0])  # 이렇게 하면 서로 공통조상이 같기 직전까지 가기에 이들의 부모를 출력해줍니다.
