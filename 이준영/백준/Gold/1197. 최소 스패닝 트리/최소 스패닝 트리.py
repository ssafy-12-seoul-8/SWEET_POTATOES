import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)

def find(x):
    if x != d[x]:
        d[x] = find(d[x])
    return d[x]


v, e = map(int, input().split())
d = [0] * (v + 1)
line = []
count = 0
distance = 0
for i in range(1, v + 1):
    d[i] = i
for i in range(e):
    a, b, c = map(int, input().split())
    line.append((c, a, b))
line.sort()
for i in range(e):
    if count == v - 1:
        break
    else:
        a, b, c = line[i]
        root1 = find(b)
        root2 = find(c)
        if root1 == root2:
            continue
        else:
            count = count + 1
            distance = distance + a
            d[root2] = root1
print(distance)
