# 최소 공통 조상 문제를 풀기 위해서는 깊이 개념이 필요합니다.
# 각 트리의 root가 있는 곳을 깊이 0으로 하고 재귀를 돌려 각 노드의 깊이를 저장합니다.
# 주어진 두 노드의 깊이가 다르다면 같을 때 까지 깊이가 깊은 노드를 끌어올립니다.
# 그 후 동시에 하나씩 올리며 값이 같아질때까지 올리면 됩니다.
# 루트는 적어도 공통 조상이므로 항상 최소 공통 조상이 존재합니다.

import sys
input = sys.stdin.readline

sys.setrecursionlimit(10000)

def fill(n, d):
    depth[n] = d
    for i in child[n]:
        fill(i, d + 1)                  # 자식에 대해 깊이를 1증가시킨 후 재귀


T = int(input())
for tc in range(T):
    N = int(input())
    par = [0] * (N + 1)
    child = [[] for _ in range(N + 1)]
    depth = [0] * (N + 1)

    for _ in range(N - 1):
        a, b = map(int, input().split())
        par[b] = a
        child[a].append(b)

    start = -1
    for i in range(1, N + 1):                   # 부모가 없는 노드가 루트 노드
        if par[i] == 0:
            start = i
            break

    fill(start, 0)

    x, y = map(int, input().split())

    if depth[x] > depth[y]:                     # 편의를 위해 x가 깊이가 더 얕게 설정
        x, y = y, x

    cnt = depth[y] - depth[x]                   
    for _ in range(cnt):                        # 깊이 차이만큼 y를 끌어 올린다.
        y = par[y]

    while x != y:                               # x,y 둘다 끌어올리면서 같아질때까지 반복
        x = par[x]
        y = par[y]
    print(x)
