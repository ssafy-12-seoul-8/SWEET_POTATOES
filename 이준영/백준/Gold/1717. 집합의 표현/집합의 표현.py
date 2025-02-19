import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)

def find(a):
    if a != p[a]:           
        p[a] = find(p[a])                   # 내가 대표가 아니면 나의 조상들의 부모를 대표로 갱신

    return p[a]


n, m = map(int, input().split())
p = [i for i in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    d = find(b)
    e = find(c)

    if a == 0:                              # b,c가 속한 집합을 합치는 건 한 대표의 부모를 다른 대표로 설정하는 것
        if d == e:
            continue

        p[d] = e

    else:
        if d == e:                          # 대표가 같아야 같은 집합
            print("YES")
        else:
            print("NO")
