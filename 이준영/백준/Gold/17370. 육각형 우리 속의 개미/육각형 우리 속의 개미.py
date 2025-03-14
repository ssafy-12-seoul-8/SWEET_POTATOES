def btk(cur, y, x, d):
    global cnt

    if (y, x) in st:
        if cur == N:
            cnt += 1
        return

    if cur == N:
        return

    st.add((y, x))
    for k in nd[d]:
        ny = y + dy[k]
        nx = x + dx[k]
        btk(cur + 1, ny, nx, k)

    st.remove((y, x))


N = int(input())
dy = [1, -1, -1, 1, 1, -1]
dx = [0, -1, 1, -1, 1, 0]
nd = [[3, 4], [3, 5], [4, 5], [0, 1], [0, 2], [1, 2]]
cnt = 0
if N <= 4:
    print(0)
else:
    st = set([(0, 0), (-1, 0)])
    btk(1, -2, 1, 2)
    print(2 * cnt)
