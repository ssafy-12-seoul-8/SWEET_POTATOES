# 미리 각 0이 속한 곳에 있는 영역의 크기와 종류를 저장하였다 (나중에 벽에 대해 빈 공간을 더할 때 중복된 공간이 더해질 수 있기에
# 영역의 종류도 설정하였다.
# 이를 위해 원래의 맵에서 공간들을 자신이 속하는 영역 번호(2부터 시작)로 채워지게 수정하고 각 영역 번호의 크기를 딕셔너리에 저장하였다.
# 그리고 정답 배열을 만들 때 1이 아닌 곳은 0으로, 1인 곳은 주변의 영역들의 크기를 더하였고 이 때 집합을 사용하였다.
# 10으로 안나눠서 틀림
import sys
from collections import deque

input = sys.stdin.readline


def bfs(start_y, start_x):
    dq = deque([(start_y, start_x)])
    cnt = 0
    while dq:
        y, x = dq.popleft()
        if arr[y][x] == 0:
            arr[y][x] = cur                                         # 해당 영역을 영역번호로 칠하고
            cnt += 1                                                # 영역 크기 1 증가
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] == 0:
                    dq.append((ny, nx))
    return cnt


N, M = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(N)]
ans = [[0] * M for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
dct = {}
cur = 2

for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            tmp = bfs(i, j)
            dct[cur] = tmp                                              # 영역번호:영역크기 저장
            cur += 1

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            st = set([])
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] != 1:
                    st.add(arr[ny][nx])                                  # 인접 영역번호를 집합에 저장
            for k in st:
                ans[i][j] += dct[k]                                      # 다 더하고 자기자신도 포함해야 하므로 1 더함
            ans[i][j] += 1
            ans[i][j] = ans[i][j] % 10                                   # 10으로 안나눠서 틀림

for i in range(N):
    print(*ans[i], sep="")
