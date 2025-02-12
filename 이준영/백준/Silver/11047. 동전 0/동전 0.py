N, K = map(int, input().split())
arr = [int(input()) for _ in range(N)]
cnt = 0

for i in range(N - 1, -1, -1):
    tmp = K // arr[i]
    cnt = cnt + tmp
    K = K - tmp * arr[i]

print(cnt)
