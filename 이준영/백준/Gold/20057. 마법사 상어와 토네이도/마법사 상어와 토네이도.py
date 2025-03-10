# 처음엔 딕셔너리로 관리하려고 하였으나 실수를 하기 쉽다고 판단하여 배열로 관리하였습니다. (토네이도로 인한 변화를)
# 실수계산이 느리니 자연수로 연산을 하도록 하였습니다.

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 1, 0, -1]                                                  # 좌, 하, 우, 상
dx = [-1, 0, 1, 0]
tmp = [[0, 0, 2, 0, 0],
       [0, 10, 7, 1, 0],
       [5, 0, 0, 0, 0],
       [0, 10, 7, 1, 0],
       [0, 0, 2, 0, 0]]

sand = [0] * 4
sand[0] = [row[:] for row in tmp]                                   # sand[d]는 d방향으로 바람이 불 때 변화량입니다.
                                                                    # tmp배열을 반시계 방향으로 회전하며 sand배열안에 넣었습니다.
for l in range(1, 4):
    b = [[0] * 5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            b[i][j] = tmp[j][4 - i]
    sand[l] = b
    tmp = b

d = 0                                                               # 현재 방향
out = 0                                                             # 밖으로 나간 모래 양
y = x = N // 2                                                      # 토네이도의 위치

for l in range(1, N):                                               # 달팽이를 생각해보자 앞으로 전진하는 거리는
    for _ in range(2):                                              # 1,1,2,2,3,3 .... N-1,N-1 에 N-1한번 더 이다.
        for t in range(l):                                          # 각 직진이 끝날 때마다 반시계방향으로 회전한다.
            y = y + dy[d]                                            
            x = x + dx[d]
            tot = arr[y][x]                                         # 현재 칸의 모래 양
            for i in range(5):
                for j in range(5):
                    if sand[d][i][j] == 0:                          # 0인 곳은 모래가 퍼지지 않는다.
                        continue
                    else:
                        tmp = arr[y][x] * sand[d][i][j] // 100      # 모래가 퍼져나가는 양
                        ny = y + i - 2                              # (2,2)를 기준으로 y,x 좌표 변화량을 세야 한다.
                        nx = x + j - 2
                        if 0 <= ny < N and 0 <= nx < N:             # 범위 안에 있으면 더하고
                            arr[ny][nx] += tmp
                        else:
                            out += tmp                              # 아니면 밖으로 나간다.
                        tot -= tmp                                  # 남은 모래 양을 줄인다.

            arr[y][x] = 0                                           # 현재 칸 비워주고
            ny = y + dy[d]                                          # 알파 칸을 보자
            nx = x + dx[d]
            if 0 <= ny < N and 0 <= nx < N:                         # 만약 범위내에 있으면
                arr[ny][nx] += tot                                  # 남은 모래를 다 준다.
            else:
                out += tot                                          # 아니면 바깥에 기부

        d = (d + 1) % 4                                             # 방향 전환

for t in range(N - 1):                                              # 마지막 왼쪽으로 N-1번 전진
    y = y + dy[d]
    x = x + dx[d]
    tot = arr[y][x]
    for i in range(5):
        for j in range(5):
            if sand[d][i][j] == 0:
                continue
            else:
                tmp = arr[y][x] * sand[d][i][j] // 100
                ny = y + i - 2
                nx = x + j - 2
                if 0 <= ny < N and 0 <= nx < N:
                    arr[ny][nx] += tmp
                else:
                    out += tmp
                tot -= tmp

    arr[y][x] = 0
    ny = y + dy[d]
    nx = x + dx[d]
    if 0 <= ny < N and 0 <= nx < N:
        arr[ny][nx] += tot
    else:
        out += tot

print(out)
