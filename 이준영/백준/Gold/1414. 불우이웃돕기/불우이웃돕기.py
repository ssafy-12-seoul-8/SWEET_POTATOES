# 전체 랜선의 길이를 저장하고 최소스패닝 트리의 길이를 빼면 된다.
# 최소 스패닝 트리를 위한 길들을 정할 때 (i,j) 혹은 (j,i)에 있는 것 중 0이 아니면서 작은 값이 두 컴퓨터를 연결하는 랜선이 된다.
# 둘다 0이면 직접 연결하는 랜선은 없는거다.

import sys

input = sys.stdin.readline


def change(s):                                          # 문자열을 문제의 조건에 맞는 길이로 바꿔주는 함수
    if s == "0":
        return 0

    if s.isupper():
        return ord(s) - ord('A') + 27

    return ord(s) - ord('a') + 1


def find(a):                                            # 대표를 찾으며 조상들의 부모를 대표로 바꿈
    if a != p[a]:
        p[a] = find(p[a])

    return p[a]


N = int(input())

arr = [list(input().rstrip()) for _ in range(N)]
p = [i for i in range(N)]
road = []
tot = 0

for i in range(N):
    tot += change(arr[i][i])                                    # 아래에서 tot에 더할 때는 (i,i)가 들어가지 않아 따로 더해줌

for i in range(N - 1):
    for j in range(i + 1, N):
        tmp1 = change(arr[i][j])
        tmp2 = change(arr[j][i])
        tot += (tmp1 + tmp2)                                    # 전체 랜선의 길이 갱신
        
        if tmp1 == 0:
            if tmp2 == 0:
                continue
            else:
                road.append((tmp2, i, j))

        else:
            if tmp2 == 0:
                road.append((tmp1, i, j))
            else:
                road.append((min(tmp1, tmp2), i, j))

cnt = 0
sm = 0
road.sort()
for dis, a, b in road:

    c = find(a)
    d = find(b)

    if c == d:
        continue

    p[c] = d
    sm += dis
    cnt += 1

    if cnt == N - 1:
        break

if cnt == N - 1:
    print(tot - sm)
else:
    print(-1)

