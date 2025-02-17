from heapq import heappop, heappush

V, E, P = map(int, input().split())

road = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    road[a].append((b, c))
    road[b].append((a, c))

distance = [[int(1e9), False] for _ in range(V + 1)]
pq = []

if P == 1 or P == V:
    distance[1] = [0, True]
    heappush(pq, (0, 1, True))
else:
    distance[1] = [0, False]
    heappush(pq, (0, 1, False))

while pq:
    dis, des, check = heappop(pq)

    if distance[des][0] < dis:
        continue

    for tmp_des, tmp_dis in road[des]:
        tmp = check
        if tmp_des == P:
            tmp = True
        if distance[tmp_des][0] == dis + tmp_dis:
            if tmp and not distance[tmp_des][1]:
                distance[tmp_des][1] = True
                heappush(pq, (distance[tmp_des][0], tmp_des, True))
        elif distance[tmp_des][0] > dis + tmp_dis:
            distance[tmp_des] = [dis + tmp_dis, tmp]
            heappush(pq, (distance[tmp_des][0], tmp_des, tmp))


if distance[V][1]:
    print("SAVE HIM")
else:
    print("GOOD BYE")
