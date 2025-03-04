n, m, k = map(int, input().split())

dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 1, 1, 1, 0, -1, -1, -1]

lst = [0] * m
for i in range(m):
    x, y, m, s, d = map(int, input().split())
    lst[i] = [x - 1, y - 1, m, s, d]

for _ in range(k):
    arr = [[[] for _ in range(n)] for _ in range(n)]
    tmp_lst = []
    for y, x, m, s, d in lst:
        y = (y + s * dy[d]) % n
        x = (x + s * dx[d]) % n
        arr[y][x].append((m, s, d))

    for i in range(n):
        for j in range(n):
            if len(arr[i][j]) == 0:
                continue
            elif len(arr[i][j]) == 1:
                tmp = arr[i][j][0]
                tmp_lst.append([i, j, tmp[0], tmp[1], tmp[2]])
            else:
                cnt = 0
                even = 0
                speed = 0
                weight = 0
                for m, s, d in arr[i][j]:
                    weight += m
                    speed += s
                    cnt += 1
                    if d % 2 == 0:
                        even += 1

                weight = weight // 5
                speed = speed // cnt
                if even == cnt or even == 0:
                    start = 0
                else:
                    start = 1

                if weight == 0:
                    continue
                else:
                    for k in range(4):
                        tmp_lst.append([i, j, weight, speed, k * 2 + start])

    lst = tmp_lst

tot = 0
for y, x, m, s, d in lst:
    tot += m
print(tot)
