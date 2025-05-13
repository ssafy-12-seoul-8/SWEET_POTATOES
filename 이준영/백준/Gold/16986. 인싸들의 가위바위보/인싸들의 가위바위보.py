def btk(p1, p2):
    global ans
    if ans == 1:
        return

    if win[0] == K:
        ans = 1
        return

    if win[1] == K or win[2] == K:
        return

    if p1 + p2 == 3:
        res = result[arr[p1][order[p1]]][arr[p2][order[p2]]]
        order[p1] += 1
        order[p2] += 1
        if res == 2 or (res == 1 and p1 > p2):
            win[p1] += 1
            btk(p1, 3 - p1 - p2)
            win[p1] -= 1
        else:
            win[p2] += 1
            btk(p2, 3 - p1 - p2)
            win[p2] -= 1
        order[p1] -= 1
        order[p2] -= 1

    else:
        if p1 == 0:
            for i in range(1, N + 1):
                if visited[i] == 0:
                    visited[i] = 1
                    res = result[i][arr[p2][order[p2]]]
                    order[p2] += 1
                    if res == 2:
                        win[p1] += 1
                        btk(p1, 3 - p1 - p2)
                        win[p1] -= 1
                    else:
                        win[p2] += 1
                        btk(p2, 3 - p1 - p2)
                        win[p2] -= 1
                    visited[i] = 0
                    order[p2] -= 1
        else:
            for i in range(1, N + 1):
                if visited[i] == 0:
                    visited[i] = 1
                    res = result[arr[p1][order[p1]]][i]
                    order[p1] += 1
                    if res == 0:
                        win[p2] += 1
                        btk(p2, 3 - p1 - p2)
                        win[p2] -= 1
                    else:
                        win[p1] += 1
                        btk(p1, 3 - p1 - p2)
                        win[p1] -= 1
                    visited[i] = 0
                    order[p1] -= 1



N, K = map(int, input().split())

result = [[]] + [[0] + list(map(int, input().split())) for _ in range(N)]

ans = 0

arr = [[]] + [list(map(int, input().split())) for _ in range(2)]
win = [0, 0, 0]
order = [0, 0, 0]
visited = [0] * (N + 1)
btk(0, 1)
print(ans)
