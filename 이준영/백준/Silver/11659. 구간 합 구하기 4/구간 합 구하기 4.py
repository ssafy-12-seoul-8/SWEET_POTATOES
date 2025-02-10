import sys

input = sys.stdin.readline
N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr2 = [0] * (N + 1)
for i in range(1, N + 1):
    arr2[i] = arr2[i - 1] + arr[i - 1]

for _ in range(M):
    a, b = map(int, input().split())
    print(arr2[b] - arr2[a - 1])
