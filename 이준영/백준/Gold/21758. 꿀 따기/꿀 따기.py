import sys

input = sys.stdin.readline
N = int(input())

arr = list(map(int, input().split()))

tot = sum(arr)

# 왼쪽 끝에 벌통 ( 오른쪽 끝은 벌 하나 고정)
left_max = sm = 2 * tot - (arr[N - 1] + arr[N - 2]) * 2

for k in range(N - 3, 0, -1):
    sm = sm + arr[k + 1] - 2 * arr[k]
    left_max = max(left_max, sm)

# 오른쪽 끝에 벌통 (왼쪽 끝은 벌 하나 고정)
right_max = sm = 2 * tot - (arr[0] + arr[1]) * 2

for k in range(2, N - 1):
    sm = sm + arr[k - 1] - 2 * arr[k]
    right_max = max(right_max, sm)

ans = max(right_max, left_max)
# N이 3일 때는 가운데 놓을 떄 클 수 도 있다.

if N == 3:
    tmp = 2 * arr[1]
    ans = max(ans, tmp)
    
print(ans)
