# 이미 연결된 통로가 있기 때문에 서로소 집합의 초기 상태가 다르다.
import sys, math

input = sys.stdin.readline


def find(a):
    if a != p[a]:
        p[a] = find(p[a])

    return p[a]


N, M = map(int, input().split())
arr = [[0]] + [list(map(int, input().split())) for _ in range(N)]                       # 인덱스를 맞추기 위해 앞에 0 추가

road = []
for i in range(1, N):
    for j in range(i + 1, N + 1):
        dis = math.sqrt((arr[i][0] - arr[j][0]) ** 2 + (arr[i][1] - arr[j][1]) ** 2)    # 각 행성 간 거리를 모두 road에 넣는다.
        road.append((dis, i, j))

road.sort()

p = [i for i in range(N + 1)]
cnt = 0
for _ in range(M):                                                                      # 초기 서로소집합의 갱신
    a, b = map(int, input().split())

    c = find(a)
    d = find(b)

    if c == d:
        continue

    else:
        p[c] = d
        cnt += 1

sm = 0
for dis, a, b in road:
    c = find(a)
    d = find(b)

    if c == d:
        continue

    else:
        p[c] = d
        sm += dis
        cnt += 1

        if cnt == N - 1:
            break

print("%.2f" % sm)
