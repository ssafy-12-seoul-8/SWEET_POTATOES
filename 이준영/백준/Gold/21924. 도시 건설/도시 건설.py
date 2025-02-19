import sys

input = sys.stdin.readline

def find(a):
    if p[a] == a:
        return a

    p[a] = find(p[a])
    return p[a]

N, M = map(int, input().split())

road = [[] for _ in range(N + 1)]

tot = 0
road = []
for _ in range(M):
    a, b, c = map(int, input().split())
    road.append((c, a, b))
    tot += c

road.sort()

p = [i for i in range(N + 1)]
cnt = 0
price = 0
for c, a, b in road:
    d = find(a)
    e = find(b)
    if d == e:
        continue

    cnt += 1
    price += c
    p[e] = d
    if cnt == N - 1:
        break

if cnt != N - 1:
    print(-1)

else:
    print(tot - price)
