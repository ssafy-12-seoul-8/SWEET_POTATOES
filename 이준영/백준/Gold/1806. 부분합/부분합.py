# 투 포인터로 해결하였다. (각 원소들이 양수이기에 가능)
# 다 합한 것이 S보다 크거나 같다면 그 때 mn을 최신화하고 left를 1증가시킨다.
# S보다 작다면 right를 1늘린다.
import sys

input = sys.stdin.readline

N, S = map(int, input().split())
arr = list(map(int, input().split()))
mn = 100000

left = 0
right = 0
tot = arr[0]

while True:
    if tot >= S:
        mn = min(mn, right - left + 1)
        tot = tot - arr[left]
        left += 1
    else:
        right += 1
        if right >= N:
            break
        tot += arr[right]

if mn == 100000:
    print(0)
else:
    print(mn)
