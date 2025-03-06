# 각 시간 별 인구 이동을 구현했다.

N, L, R = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

time = 0
dy = [-1, 0, 0, 1]
dx = [0, 1, -1, 0]

while True:
    flag = False
    visited = [[0] * N for _ in range(N)]                   # 방문배열
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                idx = 0                                     # dq에 다 저장하려고 idx로 관리 (혜민 프로님 아이디어)
                visited[i][j] = 1
                dq = [(i, j)]
                sm = arr[i][j]                              # 국경이 열린 곳들의 인구합
                while idx < len(dq):
                    y, x = dq[idx]
                    idx += 1
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]                      # 아직 방문하지 않았고
                        if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0:
                            if L <= abs(arr[ny][nx] - arr[y][x]) <= R:
                                flag = True                 # 차이가 L이상 R이하면 연합에 추가한다.
                                sm += arr[ny][nx]
                                visited[ny][nx] = 1
                                dq.append((ny, nx))
                target = sm // len(dq)                     # 각 연합의 인구 수
                for y, x in dq:
                    arr[y][x] = target                  # 연합에 채워준다.

    if flag:
        time += 1
    else:
        break

print(time)
