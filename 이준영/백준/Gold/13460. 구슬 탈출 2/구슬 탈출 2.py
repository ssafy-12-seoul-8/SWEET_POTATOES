# 빨간 사탕과 파란 사탕의 위치만 중요하기에 두 위치만 빼고 .으로 바꿔주었습니다.
# 백트래킹으로 상하좌우 가는 것을 보았습니다.
# 파란색 공이 O에 들어가면 바로 실패이고
# 그렇지 않은 경우 중 빨간색이 먼저 들어가면 시간을 갱신해줍니다.

def btk(cur, ry, rx, by, bx, ld):  # 이번에 움직일 횟수, 빨간공좌표, 파란공 좌표
    global ans
    if ans <= cur:  # 이미 답을 갱신못하므로 리턴
        return

    for k in nd[ld]:
        sry, srx = move(ry, rx, k)  # 빨간 공을 움직이고
        sby, sbx = move(by, bx, k)  # 파란 공 움직이자.
        if arr[sby][sbx] == "O":  # 파란공이 들어가면 실패
            continue
        if arr[sry][srx] == "O":  # 그게 아니고 빨간 공이 들어가면 성공
            ans = cur
            return

        if sry == sby and srx == sbx:  # 둘다 안들어갔는데 좌표가 겹친다는 것은 같은 행에 있었는데 가로 이동을 하거나 같은 열에 있었는데 세로 이동을 한 것
            if k == 0:  # 오른쪽으로 갈 때는 원래 왼쪽에 있던게 한 칸 왼쪽으로 가야 됨
                if rx < bx:
                    srx -= 1
                else:
                    sbx -= 1
            elif k == 1:  # 왼쪽으로 갈 때는 원래 오른쪽에 있던 게 한 칸 오른쪽으로 가야 함
                if rx < bx:
                    sbx += 1
                else:
                    srx += 1
            elif k == 2:  # 아래로 갈 때는 원래 위에 있던 게 한 칸 위로 가야 함
                if ry < by:
                    sry -= 1
                else:
                    sby -= 1
            else:  # 위로 갈 때는 원래 아래에 있던 게 한 칸 아래로 가야 함
                if ry < by:
                    sby += 1
                else:
                    sry += 1
        if (ry, rx) == (sry, srx) and (by, bx) == (sby, sbx):  # 근데 좌표가 안바꼈다면 이 방향으로는 안가봐도 됨
            continue
        btk(cur + 1, sry, srx, sby, sbx, k)  # 그렇지 않으면 함 가보자


def move(y, x, d):  # (y,x)를 d방향으로 움직이는 함수
    while True:
        ny = y + dy[d]
        nx = x + dx[d]
        if arr[ny][nx] == ".":  # .이면 이동
            y = ny
            x = nx
        else:
            if arr[ny][nx] == "O":  # O면 이동해서 리턴
                return ny, nx
            else:  # 벽이면 멈춰서 리턴
                return y, x


N, M = map(int, input().split())

arr = [list(input()) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

for i in range(N):
    for j in range(M):
        if arr[i][j] == "R":  # 빨간공과
            ry, rx = i, j
            arr[i][j] = "."
        elif arr[i][j] == "B":  # 파란공의 좌표만 빼주고 빈 칸으로 만듦
            by, bx = i, j
            arr[i][j] = "."

ans = 11

nd = [[2, 3], [2, 3], [0, 1], [0, 1], [0, 1, 2, 3]]
btk(1, ry, rx, by, bx, 4)
if ans == 11:  # 11 갱신안되면 실패
    print(-1)
else:
    print(ans)
