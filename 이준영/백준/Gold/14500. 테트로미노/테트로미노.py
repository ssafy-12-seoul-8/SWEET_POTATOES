# 마지막 모양을 제외하고는 끝점에서 dfs를 통해 찾을 수 있는 모양들이다.
# 따라서 dfs를 각 점에서 수행하여 최대값을 갱신한 후
# 마지막 모양에 대해서는 따로 for문을 돌려 최대값을 갱신해야 한다.
# 이중 for문을 도는 걸 잘 생각해보면 백트래킹시 위로 가는 방향은 고려하지 않아도 된다.

import sys

input = sys.stdin.readline

# 마지막 모양을 제외하고 모두 탐색가능
def btk(y, x, cnt, sm):                                             # 현재 y좌표, x좌표, 지난 칸수, 합
    global mx
    if cnt == 4:                                                    # 4칸이면 최대값 갱신
        mx = max(mx, sm)
        return

    for k in range(3):                                              # 윗방향은 빼고 생각해도 된다.
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < n and 0 <= nx < m and visited[ny][nx] == 0:    # 범위 안에 있고 방문하지 않았다면 백트래킹 요소
            visited[ny][nx] = 1
            btk(ny, nx, cnt + 1, sm + arr[ny][nx])
            visited[ny][nx] = 0


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

mx = 0

dy = [0, 0, 1, -1]                                                  # 마지막을 윗방향으로 일부러 설정
dx = [1, -1, 0, 0]

visited = [[0] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        visited[i][j] = 1                                           # i,j가 시작점이 되는 백트래킹 시작
        btk(i, j, 1, arr[i][j])
        visited[i][j] = 0

# 마지막 모양에 대해 최대값 갱신
for i in range(n):
    for j in range(m):
        for k in range(4):                                          # k방향을 제외하고 더할 거다.
            sm = arr[i][j]                                          # 가운데값
            flag = True
            for l in range(4):                                      # 더할 방향들
                if k == l:
                    continue
                ny = i + dy[l]
                nx = j + dx[l]
                if 0 <= ny < n and 0 <= nx < m:
                    sm += arr[ny][nx]                               # 하나라도 범위밖에 있으면 무효이다.
                else:
                    flag = False
                    break
            if flag:                                                # 유효한 값이면 갱신
                mx = max(mx, sm)

print(mx)
