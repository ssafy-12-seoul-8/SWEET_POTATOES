from collections import deque

F, S, G, U, D = map(int, input().split())

dis = [-1] * (F + 1)

dq = deque([S])
dis[S] = 0
d = [U, -D]
while dq:
    x = dq.popleft()
    for dx in d:
        nx = x + dx
        if 1 <= nx <= F and dis[nx] == -1:
            dis[nx] = dis[x] + 1
            dq.append(nx)
            if nx == G:
                break

if dis[G] == -1:
    print("use the stairs")
else:
    print(dis[G])
