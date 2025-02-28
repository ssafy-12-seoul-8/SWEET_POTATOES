N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]

pos = [[-1] * M for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
lst = []
for i in range(N):
    for j in range(M):
        if arr[i][j] == "#":
            tmp = 0
            for l in range(1, min(i, j, N - 1 - i, M - 1 - j) + 1):
                cnt = 0
                for k in range(4):
                    ny = i + dy[k] * l
                    nx = j + dx[k] * l
                    if arr[ny][nx] != "#":
                        break
                    cnt += 1

                if cnt != 4:
                    break
                tmp = l
            pos[i][j] = tmp
            for v in range(tmp + 1):
                lst.append((v, i, j))

lst.sort()
mx = 1
l = len(lst)

for _ in range(l):
    s, y, x = lst.pop()
    if (1 + 4 * s) ** 2 <= mx:
        break

    for k in range(len(lst) - 1, -1, -1):
        s2, y2, x2 = lst[k]
        if (1 + 4 * s) * (1 + 4 * s2) <= mx:
            break

        if y == y2:
            if abs(x - x2) > s + s2:
                mx = (1 + 4 * s) * (1 + 4 * s2)

        elif x == x2:
            if abs(y - y2) > s + s2:
                mx = (1 + 4 * s) * (1 + 4 * s2)

        elif max(abs(y - y2), abs(x - x2)) > s or min(abs(y - y2), abs(x - x2)) > s2:
            mx = (1 + 4 * s) * (1 + 4 * s2)

print(mx)
