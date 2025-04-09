def btk(cur, score1, score2, t1, t2):
    global mn
    if cur == N:
        if t1 and t2:
            mn = min(mn, abs(score1 - score2))
        return

    tmp1_score = 0
    tmp2_score = 0
    for y in t1:
        tmp1_score += (arr[cur][y] + arr[y][cur])
    for y in t2:
        tmp2_score += (arr[cur][y] + arr[y][cur])

    t1.append(cur)
    btk(cur + 1, score1 + tmp1_score, score2, t1, t2)
    t1.pop()
    t2.append(cur)
    btk(cur + 1, score1, score2 + tmp2_score, t1, t2)
    t2.pop()


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

mn = 40000
btk(1, 0, 0, [0], [])

print(mn)
