import sys

input = sys.stdin.readline
sys.setrecursionlimit(10000)


def fill_cnt(cur):
    if cur == -1:
        return 0
    l = fill_cnt(child[cur][0])
    r = fill_cnt(child[cur][1])
    child_cnt[cur] = [l, r]
    return l + r + 1


def fill_width(dep, cur, left):
    if cur == -1:
        return
    l = child_cnt[cur][0]
    depth[dep].append(left + l)
    fill_width(dep + 1, child[cur][0], left)
    fill_width(dep + 1, child[cur][1], left + l + 1)


N = int(input())

child = [[0] * 2 for _ in range(N + 1)]
possible = [0] * (N + 1)
for _ in range(N):
    a, b, c = map(int, input().split())
    child[a] = [b, c]
    if b != -1:
        possible[b] = 1
    if c != -1:
        possible[c] = 1

for i in range(1, N + 1):
    if possible[i] == 0:
        root = i
        break

child_cnt = [[0] * 2 for _ in range(N + 1)]

fill_cnt(root)

depth = [[] for _ in range(N + 2)]
fill_width(1, root, 1)
mx = -1
mx_idx = -1
for i in range(1, N + 2):
    if not depth[i]:
        continue
    tmp = depth[i][-1] - depth[i][0] + 1
    if mx < tmp:
        mx = tmp
        mx_idx = i

print(mx_idx, mx)
