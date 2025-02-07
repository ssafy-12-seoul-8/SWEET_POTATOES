from collections import deque

N, K = map(int, input().split())

dis = [[-1, 0] for _ in range(140000)]

dis[N] = [0, 1]
cnt = 0
dq = deque([N])
while dq:
    tmp_dq = []

    for i in dq:
        for j in (i - 1, i + 1, 2 * i):
            if 0 <= j < 140000:
                if dis[j][0] == -1:
                    dis[j] = [dis[i][0] + 1, dis[i][1]]
                    tmp_dq.append(j)
                elif dis[j][0] == dis[i][0] + 1:
                    dis[j][1] += dis[i][1]
                else:
                    continue
    dq = tmp_dq
print(dis[K][0])
print(dis[K][1])
