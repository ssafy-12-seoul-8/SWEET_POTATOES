import sys

input = sys.stdin.readline


def find(a):                                                 # 대표를 찾으며 방문한 노드들의 부모를 대표로 바꿈
    if a != p[a]:   
        p[a] = find(p[a])

    return p[a]


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

road = []
p = [i for i in range(N)]

for i in range(N - 1):
    for j in range(i + 1, N):
        road.append((arr[i][j], i, j))                      # 모든 도로를 리스트에 넣는다.

road.sort()

sm = 0
cnt = 0

for dis, a, b in road:
    c = find(a)
    d = find(b)

    if c == d:
        continue

    else:                                                   # 서로 다른 집합에 있는 두 행성만 연결한다.
        p[c] = d
        cnt += 1
        sm += dis

        if cnt == N - 1:
            break

print(sm)
