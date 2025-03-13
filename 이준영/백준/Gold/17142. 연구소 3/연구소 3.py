# 백트래킹문제 가능한 바이러스 중 M개를 골라 거기서 시작하는 bfs를 돌려 걸리는 시간을 측정한다.
# 이 때 모든 빈 칸을 채워야 하므로 처음에 전체 빈칸의 개수를 저장하고 bfs가 끝난 후 채운 빈칸의 수와 비교하여 끝낸다.
# 이 때 유의할 건 비활성 바이러스가 있는 곳이 안채워져도 빈칸만 다 채워지면 끝나는 것
from collections import deque


def btk(cur, lst):                              # lst에 M개가 뽑힐 때마다 check해준다.
    if len(lst) == M:
        check(lst)
        return

    for i in range(cur, l + len(lst) - M + 1):  # 이번에 써본건데 앞으로 M-len(lst)-1만큼 뽑아야 되므로 저기까지 밖에 못 뽑는다.
        lst.append(i)
        btk(i + 1, lst)
        lst.pop()


def check(lst):                                 # lst에 있는 인덱스의 바이러스를 활성화시킬 때 걸리는 시간 측정
    global mn
    visited = [[0] * N for _ in range(N)]
    dq = deque([])
    t_cnt = 0
    for i in lst:
        y, x = virus[i]
        dq.append((y, x))
        visited[y][x] = 1

    for t in range(mn + 1):
        if not dq or t_cnt == cnt:                        # 빈칸만 다 채웠으면 끝낸다.
            break
        l = len(dq)
        for _ in range(l):
            y, x = dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] != 1:
                    visited[ny][nx] = 1
                    dq.append((ny, nx))
                    if arr[ny][nx] == 0:
                        t_cnt += 1              # 빈칸일 때만 t_cnt 증가

    if t_cnt != cnt:                            # 둘이 다르면 다 못채운 것
        return

    mn = min(t, mn)                             # 다 채웠으면 갱신


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
cnt = 0
virus = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 2:
            virus.append((i, j))
        elif arr[i][j] == 0:
            cnt += 1

l = len(virus)

mn = 2501
btk(0, [])

if mn == 2501:
    print(-1)
else:
    print(mn)
