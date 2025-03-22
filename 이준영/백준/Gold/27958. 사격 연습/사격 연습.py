def myprint(arr):
    for i in range(N):
        print(*arr[i])
    print("-" * 50)


def btk(cur, score, arr):
    global mx_score
    mx_score = max(mx_score, score)

    if cur == K:
        return

    tmp = [[row2[:] for row2 in row] for row in arr]

    for i in range(N):
        for j in range(N):
            if 0 < tmp[i][j][0] < 10:
                if tmp[i][j][1] > atk[cur]:
                    tmp[i][j][1] -= atk[cur]
                    btk(cur + 1, score, tmp)
                    tmp[i][j][1] += atk[cur]
                else:
                    t_tmp = tmp[i][j][:]
                    t_score = score + tmp[i][j][0]
                    hp = tmp[i][j][0] // 4
                    tmp[i][j] = [0, 0]
                    if hp > 0:
                        for k in range(4):
                            ny = i + dy[k]
                            nx = j + dx[k]
                            if 0 <= ny < N and 0 <= nx < N and tmp[ny][nx][0] == 0:
                                tmp[ny][nx] = [hp, hp]

                    btk(cur + 1, t_score, tmp)
                    if hp > 0:
                        tmp = [[row2[:] for row2 in row] for row in arr]
                    else:
                        tmp[i][j] = t_tmp
                break
            elif tmp[i][j][0] >= 10:
                t_score = tmp[i][j][0]
                tmp[i][j] = [0, 0]
                btk(cur + 1, score + t_score, tmp)
                tmp[i][j] = [t_score, t_score]
                break


N = int(input())
K = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
for i in range(N):
    for j in range(N):
        arr[i][j] = [arr[i][j], arr[i][j]]
atk = list(map(int, input().split()))

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

mx_score = 0

btk(0, 0, arr)

print(mx_score)
