# 15:17

def btk(cur, cnt, sm):
    global res

    if cnt == 7:
        fin = 0
        for i in range(3):
            fin += abs(sm[i] // 7 - target[i])

        res = min(res, fin)
        return

    if cur == N:
        if cnt <= 1:
            return

        fin = 0
        for i in range(3):
            fin += abs(sm[i] // cnt - target[i])

        res = min(res, fin)
        return

    btk(cur + 1, cnt, sm)
    tmp = [0] * 3
    for i in range(3):
        tmp[i] = sm[i] + arr[cur][i]

    btk(cur + 1, cnt + 1, tmp)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

target = list(map(int, input().split()))

res = 800
btk(0, 0, [0, 0, 0])

print(res)
