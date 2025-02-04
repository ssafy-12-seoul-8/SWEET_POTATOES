# 크루스칼 알고리즘을 이용하여 mst을 구한 후 가장 큰 도로를 하나 제거하여 문제를 해결하였습니다.
import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline

def find(a):
    if p[a] == a:
        return a
    p[a] = find(p[a])                           # 최적화를 위해 p[a]의 값을 최신화 하였습니다.
    return p[a]

N, M = map(int, input().split())
road = []

for _ in range(M):
    a, b, c = map(int, input().split())
    road.append((c, a, b))  # (거리, 집1, 집2)

road.sort()
p = [i for i in range(N + 1)]

mst = []

for i in range(M):
    if len(mst) == N - 1:
        break
    dist, a, b = road[i]

    c = find(a)
    d = find(b)
    if c == d:                  # 조상이 같다면 이미 연결되어 있으므로 추가 불가
        continue
    else:                       # 조상이 다르면 도로를 추가하고 p배열 최신화
        mst.append(dist)
        p[d] = c

tot = 0
mx = 0
for i in mst:
    tot += i
    if mx < i:
        mx = i

print(tot - mx)
