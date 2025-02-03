import sys

input = sys.stdin.readline

T = int(input())
dy = [0, 0, 1, -1]  # 4방 탐색을 위한 dy
dx = [1, -1, 0, 0]  # 4방 탐색을 위한 dx
for tc in range(T):
    count = 0
    M, N, K = map(int, input().split())
    ground = [[0 for _ in range(M)] for _ in range(N)]  # 배추가 있는 곳
    visited = [[False] * M for _ in range(N)]
    for i in range(K):
        X, Y = map(int, input().split())
        ground[Y][X] = 1
    for i in range(N):
        for j in range(M):
            if ground[i][j] == 1 and not visited[i][j]:
                count += 1
                stk = [(i, j)]
                while stk:
                    tmp = stk.pop()
                    if not visited[tmp[0]][tmp[1]]:
                        visited[tmp[0]][tmp[1]] = True
                        for k in range(4):
                            ny = tmp[0] + dy[k]
                            nx = tmp[1] + dx[k]
                            if 0 <= ny < N and 0 <= nx < M and ground[ny][nx] == 1 and not visited[ny][nx]:  # 범위 및 배추, 방문 여부
                                stk.append((ny, nx))
    print(count)
