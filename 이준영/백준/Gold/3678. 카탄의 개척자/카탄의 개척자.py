arr = [[0] * 300 for _ in range(300)]

num = [0] * 20001
dy = [-1, -2, -1, 1, 2, 1]
dx = [1, 0, -1, -1, 0, 1]

cnt = [0] * 6
y, x = 150, 150
d = 0
cnt[1] = 1
arr[y][x] = 1
num[1] = 1
idx = 1
l = 1
while True:
    for d in range(6):
        if d == 1:
            length = l - 1
        else:
            length = l

        for _ in range(length):
            y = y + dy[d]
            x = x + dx[d]

            idx += 1
            mn_cnt = 20000
            st = set()
            for k in range(6):
                ny = y + dy[k]
                nx = x + dx[k]
                st.add(arr[ny][nx])

            want = -1
            for k in range(1, 6):
                if k not in st and cnt[k] < mn_cnt:
                    want = k
                    mn_cnt = cnt[k]

            arr[y][x] = want
            num[idx] = want
            cnt[want] += 1

    if idx > 10000:
        break
    l += 1

c = int(input())
for _ in range(c):
    n = int(input())
    print(num[n])
