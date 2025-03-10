# 리팩토링 코드
import sys

input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 1, 0, -1]  # 좌, 하, 우, 상
dx = [-1, 0, 1, 0]
tmp = [(-2, 0, 2), (-1, -1, 10), (-1, 0, 7), (-1, 1, 1), (0, -2, 5), (1, -1, 10), (1, 0, 7), (1, 1, 1), (2, 0, 2)]

sand = [[] for _ in range(4)]
for y, x, p in tmp:
    sand[0].append((y, x, p))
    sand[1].append((-x, y, p))
    sand[2].append((-y, -x, p))
    sand[3].append((x, -y, p))
d = 0  # 현재 방향
out = 0  # 밖으로 나간 모래 양
y = x = N // 2  # 토네이도의 위치

for l in range(1, N):  # 달팽이를 생각해보자 앞으로 전진하는 거리는
    for _ in range(2):  # 1,1,2,2,3,3 .... N-1,N-1 에 N-1한번 더 이다.
        for t in range(l):  # 각 직진이 끝날 때마다 반시계방향으로 회전한다.
            y = y + dy[d]
            x = x + dx[d]
            tot = arr[y][x]  # 현재 칸의 모래 양
            for i, j, p in sand[d]:
                tmp = arr[y][x] * p // 100  # 모래가 퍼져나가는 양
                ny = y + i
                nx = x + j
                if 0 <= ny < N and 0 <= nx < N:  # 범위 안에 있으면 더하고
                    arr[ny][nx] += tmp
                else:
                    out += tmp  # 아니면 밖으로 나간다.
                tot -= tmp  # 남은 모래 양을 줄인다.

            arr[y][x] = 0  # 현재 칸 비워주고
            ny = y + dy[d]  # 알파 칸을 보자
            nx = x + dx[d]
            if 0 <= ny < N and 0 <= nx < N:  # 만약 범위내에 있으면
                arr[ny][nx] += tot  # 남은 모래를 다 준다.
            else:
                out += tot  # 아니면 바깥에 기부

        d = (d + 1) % 4  # 방향 전환

for t in range(N - 1):  # 각 직진이 끝날 때마다 반시계방향으로 회전한다.
    y = y + dy[d]
    x = x + dx[d]
    tot = arr[y][x]  # 현재 칸의 모래 양
    for i, j, p in sand[d]:
        tmp = arr[y][x] * p // 100  # 모래가 퍼져나가는 양
        ny = y + i
        nx = x + j
        if 0 <= ny < N and 0 <= nx < N:  # 범위 안에 있으면 더하고
            arr[ny][nx] += tmp
        else:
            out += tmp  # 아니면 밖으로 나간다.
        tot -= tmp  # 남은 모래 양을 줄인다.

    arr[y][x] = 0  # 현재 칸 비워주고
    ny = y + dy[d]  # 알파 칸을 보자
    nx = x + dx[d]
    if 0 <= ny < N and 0 <= nx < N:  # 만약 범위내에 있으면
        arr[ny][nx] += tot  # 남은 모래를 다 준다.
    else:
        out += tot  # 아니면 바깥에 기부

d = (d + 1) % 4  # 방향 전환
print(out)
