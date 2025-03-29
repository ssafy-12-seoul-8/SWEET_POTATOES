from collections import deque

N = int(input())

visited = [[] for _ in range(N)]

visited[N - 1].append(1)

dq = deque([(N - 1, 1)])

while dq:
    cur, num = dq.popleft()

    if cur == 0:
        continue

    nxt = [2 * num]

    if num % 6 == 4 and num > 4:
        nxt.append(num // 3)

    for n_num in nxt:
        visited[cur - 1].append(n_num)
        dq.append((cur - 1, n_num))

visited[0].sort()
print(len(visited[0]))
for i in visited[0]:
    print(i)