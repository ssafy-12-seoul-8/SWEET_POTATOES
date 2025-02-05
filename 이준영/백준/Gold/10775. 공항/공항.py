import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)


def fill(a):
    if a == 0:
        return 0
    if a == nxt[a]:
        nxt[a] = nxt[a - 1]
        return a
    nxt[a] = fill(nxt[a])
    return nxt[a]


G = int(input())
P = int(input())
plane = [0]
plane = [int(input()) for _ in range(P)]
nxt = [i for i in range(G + 1)]

ans = 0
for i in range(P):
    start = plane[i]
    res = fill(start)
    if res == 0:
        ans = i
        break
else:
    ans = P

print(ans)
