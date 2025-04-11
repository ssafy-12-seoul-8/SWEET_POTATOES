from collections import deque

N, T, W = map(int, input().split())
dq = deque([list(map(int, input().split())) for _ in range(N)])
M = int(input())
lst = [list(map(int, input().split())) for _ in range(M)]

lst.sort(lambda x: -x[2])
time = 0
remain = T
ans = []
while time < W:
    if lst and lst[-1][2] == time:
        p, t, c = lst.pop()
        dq.append([p, t])

    p, t = dq.popleft()
    if t == 0:
        remain = T - 1
        dq[0][1] -= 1
        ans.append(dq[0][0])
    elif remain == 0:
        remain = T - 1
        dq.append([p, t])
        dq[0][1] -= 1
        ans.append(dq[0][0])
    else:
        ans.append(p)
        remain -= 1
        dq.appendleft([p, t - 1])

    time += 1

print(*ans, sep="\n")
