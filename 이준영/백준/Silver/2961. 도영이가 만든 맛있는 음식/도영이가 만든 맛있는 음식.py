# 11:35 ~
def btk(cur, s, b, check):
    global mn

    if cur == N:
        if check:
            mn = min(mn, abs(s - b))
        return

    btk(cur + 1, s, b, check)
    btk(cur + 1, s * arr[cur][0], b + arr[cur][1], True)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
mn = abs(arr[0][0] - arr[0][1])

btk(0, 1, 0, False)

print(mn)
