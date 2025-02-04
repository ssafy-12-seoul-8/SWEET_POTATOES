import sys
from collections import deque

input = sys.stdin.readline

dy = [-1, -2, -2, -1, 1, 2, 2, 1]
dx = [-2, -1, 1, 2, 2, 1, -1, -2]
T = int(input())
for tc in range(1, T + 1):
    l = int(input())
    visited = [[False] * l for _ in range(l)]
    s_y, s_x = map(int, input().split())
    e_y, e_x = map(int, input().split())

    dq = deque([(0, s_y, s_x)])                 # 초기값을 설정할 필요가 없는 이유는 나이트는 4*4이상의 체스판에서
    while dq:                                   # 항상 어디든지 갈 수 있기 때문입니다.
        dis, y, x = dq.popleft()                # 거리도 큐에 같이 넣어서 bfs를 돌렸습니다.
        if not visited[y][x]:
            visited[y][x] = True
            if (y, x) == (e_y, e_x):
                print(dis)
                break
            for k in range(8):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < l and 0 <= nx < l and not visited[ny][nx]:
                    dq.append((dis + 1, ny, nx))
