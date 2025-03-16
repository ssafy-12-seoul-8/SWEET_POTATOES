# 근데 이제 위로 한칸 갔을 때 좌우로 가는 건 항상 대칭이니까 한쪽만 하고 *2했다.

# 방향 바꾼 횟수,현재 y좌표, 현재 x좌표, 방향
def btk(cur, y, x, d):
    global cnt

    if visited[y][x] == 1:
        if cur == N:                                # N번 방향 바꿨으면 카운트 증가
            cnt += 1
        return                                      # 아니면 실패

    if cur == N:                                    # 위의 경우가 아닌데 N오면 실패
        return

    visited[y][x] = 1                                # 현재 좌표 추가
    for k in nd[d]:                                 # 갈 수 있는 방향에 대해
        ny = y + dy[k]
        nx = x + dx[k]
        btk(cur + 1, ny, nx, k)                     # 가보자

    visited[y][x] = 0                              # 현재 좌표 빼자


N = int(input())
dy = [1, -1, -1, 1, 1, -1]
dx = [0, -1, 1, -1, 1, 0]
nd = [[3, 4], [3, 5], [4, 5], [0, 1], [0, 2], [1, 2]]           # nd[d]: d방향으로 왔을 때 갈 수 있는 방향들의 인덱스
visited = [[0]*50 for _ in range(50)]
cnt = 0                                                         # 경우의 수
if N <= 4:                                                      # 절대 안 끝남
    print(0)
else:
    visited[25][25] = 1
    visited[24][25] = 1
    btk(1, 23, 26, 2)                                            # 좌표는 (-2,1) 방향은 2
    print(2 * cnt)                                              # 2배해서 출력
