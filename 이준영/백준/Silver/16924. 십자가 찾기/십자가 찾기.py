import sys

input = sys.stdin.readline

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
N, M = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(N)]
visited = [[-1] * M for _ in range(N)]  # 빈 곳,방문안한 십자가,방문한 십자가: -1,0,1,

for i in range(N):
    for j in range(M):
        if arr[i][j] == "*":
            visited[i][j] = 0

ans = []

for i in range(N):
    for j in range(M):
        if arr[i][j] == "*":
            success = 0
            for k in range(1, min(i, j, N - 1 - i, M - 1 - j)+1):
                flag = True
                for l in range(4):
                    ny = i + dy[l] * k
                    nx = j + dx[l] * k
                    if arr[ny][nx] == ".":
                        flag = False
                        break

                if flag:
                    for l in range(4):
                        ny = i + dy[l] * k
                        nx = j + dx[l] * k
                        visited[ny][nx] = 1
                    success = k
                else:
                    break
            if success == 0:
                continue
            else:
                visited[i][j] = 1
                ans.append((i + 1, j + 1, success))

t_flag = True
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0:
            t_flag = False
            break
    if not t_flag:
        break

if t_flag:
    print(len(ans))
    for i, j, k in ans:
        print(i, j, k)

else:
    print(-1)
