import sys

input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

cross = {0: 5, 5: 0, 1: 3, 3: 1, 2: 4, 4: 2}

ans = 0
for l in range(6):
    tmp = 0
    down = arr[0][l]
    up = arr[0][cross[l]]
    for i in range(6, 0, -1):
        if i not in (up, down):
            tmp += i
            break
    for i in range(1, N):
        down = up
        for j in range(6):
            if arr[i][j] == down:
                loc = j
                break
        up = arr[i][cross[j]]

        for i in range(6, 0, -1):
            if i not in (up, down):
                tmp += i
                break

    ans = max(ans, tmp)

print(ans)
