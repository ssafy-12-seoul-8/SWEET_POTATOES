N = int(input())
arr = [0] * (N ** 2 + 1)
order = [0] * (N ** 2)
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
ans = [[0] * N for _ in range(N)]
for i in range(N ** 2):
    a, b, c, d, e = map(int, input().split())
    arr[a] = set([b, c, d, e])
    order[i] = a

for l in range(N ** 2):
    target = order[l]
    w_y = -1
    w_x = -1
    w_cnt = -1
    e_cnt = -1
    for i in range(N):
        for j in range(N):
            if ans[i][j] != 0:
                continue
            tw_cnt = 0
            te_cnt = 0
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < N and 0 <= nx < N:
                    if ans[ny][nx] == 0:
                        te_cnt += 1
                    elif ans[ny][nx] in arr[target]:
                        tw_cnt += 1

            if w_cnt < tw_cnt:
                w_cnt, e_cnt, w_y, w_x = tw_cnt, te_cnt, i, j
            elif w_cnt == tw_cnt and e_cnt < te_cnt:
                w_cnt, e_cnt, w_y, w_x = tw_cnt, te_cnt, i, j

    ans[w_y][w_x] = target

score = 0
for i in range(N):
    for j in range(N):
        cnt = 0
        for k in range(4):
            ny = i + dy[k]
            nx = j + dx[k]
            if 0 <= ny < N and 0 <= nx < N and ans[ny][nx] in arr[ans[i][j]]:
                cnt += 1

        if cnt == 0:
            continue
        else:
            score += 10 ** (cnt - 1)

print(score)
