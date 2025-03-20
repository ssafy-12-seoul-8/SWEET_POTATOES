def go(one, two, three):
    global mx
    tmp = [row[:] for row in arr]
    lst = [one, two, three]
    cnt = 0
    for _ in range(N):
        st = set([])
        for l in lst:
            y, x = find(l, tmp)
            if y != -1:
                st.add((y, x))

        for y, x in st:
            tmp[y][x] = 0
            cnt += 1

        for i in range(N - 1, -1, -1):
            for j in range(M):
                if tmp[i][j] == 1:
                    tmp[i][j] = 0
                    if i != N - 1:
                        tmp[i + 1][j] = 1
    mx = max(mx, cnt)


def find(l, arr):
    for dis in range(1, D + 1):
        for k in range(l + 1 - dis, l + dis):
            y, x = N - (dis - abs(l - k)), k
            if 0 <= y < N and 0 <= x < M and arr[y][x] == 1:
                return y, x
    return -1, -1


N, M, D = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

mx = 0
for i in range(M - 2):
    for j in range(i + 1, M - 1):
        for k in range(j + 1, M):
            go(i, j, k)

print(mx)
