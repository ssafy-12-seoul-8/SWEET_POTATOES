N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
home = []
chicken = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            home.append((i, j))
        elif arr[i][j] == 2:
            chicken.append((i, j))
h_len = len(home)
c_len = len(chicken)
dis = [[0] * c_len for _ in range(h_len)]
for i in range(h_len):
    for j in range(c_len):
        dis[i][j] = (abs(home[i][0] - chicken[j][0]) + abs(home[i][1] - chicken[j][1]), j)  # (거리, 치킨집인덱스)
    dis[i].sort()

mn = 100000
for l in range(1 << c_len):  # 비트마스킹
    cnt = 0
    check = 0
    for i in range(c_len):
        if (l & (1 << i)) != 0:
            check += 1
    if check != M:           # 고른 치킨집이 M개 일 때만 체크
        continue
    for i in range(h_len):
        for j in range(c_len):
            if (l & (1 << dis[i][j][1])) != 0:  # 미리 정렬을 했기에 조건 만족하는 치킨집있으면 바로 반영
                cnt = cnt + dis[i][j][0]
                break
    mn = min(mn, cnt)
print(mn)
