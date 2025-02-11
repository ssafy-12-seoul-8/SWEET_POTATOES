def d(a, b):
    return abs(home[a][0] - home[b][0]) + abs(home[a][1] - home[b][1])


def btk(cur, st):
    if len(st) == K:
        check(st)
        return

    if N - cur + len(st) < K:
        return

    for i in range(cur, N):
        st.add(i)
        btk(i + 1, st)
        st.remove(i)


def check(st):
    global mn
    tmp_mx = 0
    for i in range(N):
        for j in range(N):
            if dis[i][j][1] in st:
                tmp_mx = max(tmp_mx, dis[i][j][0])
                break

    mn = min(mn, tmp_mx)


N, K = map(int, input().split())
home = [list(map(int, input().split())) for _ in range(N)]

dis = [[] for _ in range(N)]
for i in range(N):
    for j in range(N):
        dis[i].append((d(i, j), j))
    dis[i].sort()
mn = 200001

btk(0, set([]))

print(mn)
