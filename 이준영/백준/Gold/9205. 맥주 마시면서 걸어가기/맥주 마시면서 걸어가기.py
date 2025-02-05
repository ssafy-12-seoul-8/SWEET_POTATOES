# 집과 락 페스티벌은 1개이고 편의점에 들릴때마다 갈 수 있는 거리가 1000으로 된다.
# 따라서 집과 락 페스티벌장소까지 거리가 1000이하인 편의점을 들리며 갈 수 있다면 갈 수 있는거다.
# 한번 지난 편의점은 다시 지날 필요가 없다.
import sys
from collections import deque

input = sys.stdin.readline

t = int(input())

for tc in range(t):
    n = int(input())
    h_y, h_x = map(int, input().split())
    road = [list(map(int, input().split())) for _ in range(n)]
    r_y, r_x = map(int, input().split())
    road.append([r_y, r_x])
    visited = set([])               # 집합으로 방문여부 저장

    dq = deque([[h_y, h_x]])
    ans = "sad"
    while dq:
        y, x = dq.popleft()
        if (y, x) not in visited:
            visited.add((y, x))
            if (y, x) == (r_y, r_x):
                ans = "happy"
                break
            for t_y, t_x in road:
                if (t_y, t_x) not in visited and abs(y - t_y) + abs(x - t_x) <= 1000:
                    dq.append((t_y, t_x))

    print(ans)
