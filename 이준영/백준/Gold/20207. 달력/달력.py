import sys

input = sys.stdin.readline
N = int(input())
arr = [0] * 366
for _ in range(N):
    a, b = map(int, input().split())
    for j in range(a, b + 1):
        arr[j] += 1

cnt = 0
mx = 0
start = -1
for i in range(366):
    if arr[i] == 0:
        if mx == 0:
            continue
        cnt += mx * (i - start)
        start = -1
        mx = 0
    else:
        if mx == 0:
            mx = arr[i]
            start = i
        else:
            mx = max(mx, arr[i])

if start != -1:
    cnt += mx * (366 - start)

print(cnt)
