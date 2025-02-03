M, N, K = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
arr = [[0] * M for _ in range(N)]  # 문제의 가로, 세로 바꿔서 생각 (문제에서 주어지는 좌표와 그림에 맞게 설정한 것)
visited = [[False] * M for _ in range(N)]
for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            arr[i][j] = 1

ans = []
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0 and not visited[i][j]:
            cnt = 0
            stk = [(i, j)]
            while stk:
                x, y = stk.pop()
                if not visited[x][y]:
                    visited[x][y] = True
                    cnt += 1
                    for k in range(4):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and arr[nx][ny] == 0:
                            stk.append((nx, ny))
            ans.append(cnt)
ans.sort()
print(len(ans))
print(*ans)
