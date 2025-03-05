from collections import deque

N = int(input())
K = int(input())
dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]  # 오른쪽 시작, 왼쪽으로 회전
arr = [[0] * N for _ in range(N)]  # 0은 빈칸, 1은 사과, 2는 뱀
for _ in range(K):
    a, b = map(int, input().split())
    arr[a - 1][b - 1] = 1

arr[0][0] = 2
L = int(input())
action = {}
for _ in range(L):
    a, b = input().split()
    a = int(a)
    if b == "L":
        b = 1
    else:
        b = -1
    action[a] = b

time = 0
d = 0
dq = deque([(0, 0)])
while True:
    time += 1
    y, x = dq[0]
    ny = y + dy[d]
    nx = x + dx[d]
    if not (0 <= ny < N and 0 <= nx < N):
        break
    if arr[ny][nx] == 2:
        break
    y = ny
    x = nx
    dq.appendleft((y, x))
    if arr[y][x] != 1:
        t_y, t_x = dq.pop()
        arr[t_y][t_x] = 0
    arr[y][x] = 2

    if time in action:
        d = (d + action[time]) % 4

print(time)
