import sys

input = sys.stdin.readline

sys.setrecursionlimit(200000)
def find(x):
    if x == p[x]:
        return x
    p[x] = find(p[x])
    return p[x]


n, m = map(int, input().split())
p = [i for i in range(n)]
ans = 0
for j in range(1, m + 1):
    a, b = map(int, input().split())
    if ans > 0:
        continue

    c = find(a)
    d = find(b)

    if c == d:
        ans = j
    else:
        p[d] = c

print(ans)
