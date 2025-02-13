# 모든 수가 음수인 경우와 아닌 경우로 나누어 풀었다.
# 모든 수가 음수이면 가장 큰 값 하나가 최대값이다.
# 하나의 수라도 양수이면 최대값이 양수이고 따라서 지금까지의 합이 음수가 될때마다 버리는 작업을 해도 된다.

import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
flag = False

for i in range(n):
    if arr[i] >= 0:
        flag = True
        break
if flag:
    mx = 0
    sm = 0
    for i in range(n):
        if sm < 0:
            sm = 0

        sm = sm + arr[i]
        mx = max(mx, sm)

else:
    mx = -int(1e9)
    for i in range(n):
        if arr[i] > mx:
            mx = arr[i]

print(mx)
