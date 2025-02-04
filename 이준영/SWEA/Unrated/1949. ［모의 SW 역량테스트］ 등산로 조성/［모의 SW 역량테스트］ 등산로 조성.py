# 풀이시간: 13분
# 제출횟수: 1회
# 시간: 176ms
# 메모리: 76916kb
# 자바로 풀었던 문제라 수월하게 풀린 것 같습니다.
# 일단 처음에 순회를 하여 최대 봉우리의 높이를 계산 후
# 최대 봉우리인 곳에서 백트래킹을 하여 최대 등산로를 찾아보았습니다.
# 만약 내 근방에 나보다 작은 봉우리가 있다면 그곳으로 갈 수 있고
# 나보다 크지만 K이상 크지 않은 봉우리가 있고 지금까지 공사한 적이 없으면 갈 수 있다는 점을 이용하였습니다.
# 제가 처음 문제를 풀 때는 가장 높은 봉우리가 깎여서 최대 봉우리가 바뀔 수도 있지 않을까 하였지만 그런 경우는 문제에서 고려하지 않습니다.

def btk(cnt, dis, y, x):                                        # (공사횟수, 등산로길이, y좌표, x좌표)

    global mx_len
    mx_len = max(mx_len, dis)                                   # 매 시행마다 mx_len을 최신화하였습니다.

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx]: # 방문한 적이 없고 범위내에 있을 경우

            if arr[ny][nx] < arr[y][x]:                         # 나보다 작은 봉우리는 항상 갈 수 있습니다.
                visited[ny][nx] = True
                btk(cnt, dis + 1, ny, nx)                       # 백트래킹을 할 때는 내가 한 행위를 다시 돌려놔야 한다는게 중요
                visited[ny][nx] = False

            elif arr[ny][nx] < arr[y][x] + K and cnt == 0:      # 공사한 적이 없고 공사할 때 갈 수 있다면
                tmp = arr[ny][nx]
                arr[ny][nx] = arr[y][x] - 1                     # 지금 봉우리보다 1작게만 공사하는게 제일 좋습니다.
                visited[ny][nx] = True
                btk(cnt + 1, dis + 1, ny, nx)
                arr[ny][nx] = tmp
                visited[ny][nx] = False

            else:
                continue


T = int(input())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
for tc in range(1, T + 1):

    N, K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    mx = 0                                    # 최대 봉우리 높이

    for i in range(N):
        for j in range(N):
            mx = max(mx, arr[i][j])

    mx_len = 0
    visited = [[False] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if arr[i][j] == mx:               # 최대 봉우리에서만 백트래킹
                visited[i][j] = True
                btk(0, 1, i, j)               # 깎은 횟수, 거리, y좌표, x좌표
                visited[i][j] = False

    print(f'#{tc} {mx_len}')
