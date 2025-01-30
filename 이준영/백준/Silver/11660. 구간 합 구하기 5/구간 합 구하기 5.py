N, M = map(int,input().split())
arr = [0]* N
pre_sum = [[0]*(N+1) for _ in range(N+1)]

for i in range(N):
    arr[i] = list(map(int,input().split()))

for i in range(1,N+1):
    for j in range(1,N+1):
        pre_sum[i][j] = pre_sum[i][j-1] + pre_sum[i-1][j] - pre_sum[i-1][j-1] + arr[i-1][j-1]

for i in range(M):
    x1, y1, x2, y2 = map(int,input().split())
    ans = pre_sum[x2][y2] - pre_sum[x2][y1-1] - pre_sum[x1-1][y2] + pre_sum[x1-1][y1-1]
    print(ans)