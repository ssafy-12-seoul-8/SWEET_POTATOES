TC = int(input())
for _ in range(TC):
    N, M, W = map(int, input().split())
    distance = [int(1e9)] * (N+1)
    distance[0] = 0
    road = {}
    for _ in range(M):
        a, b, c = map(int, input().split())
        if (a,b) in road:
            road[(a,b)] = min(road[(a,b)],c)
            road[(b,a)] = min(road[(b,a)],c)
        else:
            road[(a,b)] = c
            road[(b,a)] = c
    for _ in range(W):
        a, b, c = map(int, input().split())
        if (a, b) in road:
            road[(a, b)] = min(road[(a, b)], -c)
        else:
            road[(a,b)] = -c
    for i in range(1,N+1):
        road[(0,i)] = 0
    check = True
    for i in range(N+2):
        for info, t in road.items():
            start = info[0]
            end = info[1]
            if distance[end] > distance[start] + t:
                distance[end] = distance[start] + t
                if i == N+1:
                    check = False
                    break
    if check:
        print("NO")
    else:
        print("YES")

