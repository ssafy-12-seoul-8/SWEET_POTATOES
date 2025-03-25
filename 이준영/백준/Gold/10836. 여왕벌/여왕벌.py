import sys

input = sys.stdin.readline
N, M = map(int, input().split())

arr = [[1] * N for _ in range(N)]
acc = [0] * (2 * N - 1)
for _ in range(M):
    a, b, c = map(int, input().split())
    for i in range(a, a + b):
        acc[i] += 1
    for i in range(a + b, 2 * N - 1):
        acc[i] += 2

for i in range(N):
    arr[i][0] += acc[N - 1 - i]
for j in range(1, N):
    arr[0][j] += acc[N - 1 + j]
for i in range(1, N):
    for j in range(1, N):
        arr[i][j] += acc[N - 1 + j]

for i in range(N):
    print(*arr[i])
