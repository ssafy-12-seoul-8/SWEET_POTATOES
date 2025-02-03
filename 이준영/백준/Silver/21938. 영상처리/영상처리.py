import sys
sys.setrecursionlimit(200000)
input = sys.stdin.readline
def dfs(y, x):              # 재귀로 구현
    visited[y][x] = True
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and arr[ny][nx] == 255:
            dfs(ny, nx)


N, M = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
arr = [[0] * M for _ in range(N)]
for i in range(N):
    lst = list(map(int, input().split()))
    for j in range(3 * M):
        arr[i][j//3] += lst[j]
T = int(input())
for i in range(N):
    for j in range(M):
        if arr[i][j] >= 3 * T:  # 합이 3*T보다 크거나 같으면 255로 아니면 0으로 바꿈
            arr[i][j] = 255
        else:
            arr[i][j] = 0
visited = [[False] * M for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 255 and not visited[i][j]:
            cnt += 1
            dfs(i, j)
print(cnt)