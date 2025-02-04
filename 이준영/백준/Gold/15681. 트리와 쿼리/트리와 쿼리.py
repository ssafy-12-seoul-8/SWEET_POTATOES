# 재귀적으로 문제를 해결
# 자식 노드에서 서브 트리의 수를 계산한 결과를 더하여 부모 노드 서브 트리의 수를 계산함.
import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

def tree(R):
    visited[R] = True
    s = 1
    for i in road[R]:
        if not visited[i]:
            s = s + tree(i)
    cnt[R] = s
    return s


N, R, Q = map(int, input().split())
road = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b = map(int, input().split())
    road[a].append(b)
    road[b].append(a)

visited = [False] * (N + 1)
cnt = [0] * (N + 1)

tree(R)
for _ in range(Q):
    u = int(input())
    print(cnt[u])
