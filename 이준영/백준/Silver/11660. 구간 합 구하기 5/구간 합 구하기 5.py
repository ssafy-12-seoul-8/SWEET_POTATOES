import sys
input = sys.stdin.readline
N, M = map(int,input().split())
arr = [0]* N
pre_sum = [[0]*(N+1) for _ in range(N+1)]   # 누적합 배열 (1,1) 부터 (i,j)까지의 직사각형 영역의 합이 pre_sum[i][j]에 저장됨

for i in range(N):
    arr[i] = list(map(int,input().split()))

for i in range(1,N+1):
    for j in range(1,N+1):
        pre_sum[i][j] = pre_sum[i][j-1] + pre_sum[i-1][j] - pre_sum[i-1][j-1] + arr[i-1][j-1]
# 누적합 배열을 채우는 방법은 왼쪽 직사각형, 위쪽 직사각형의 합에서 대각선위 직사각형을 빼고 본래 원소를 더하는 것

for i in range(M):
    x1, y1, x2, y2 = map(int,input().split())
    ans = pre_sum[x2][y2] - pre_sum[x2][y1-1] - pre_sum[x1-1][y2] + pre_sum[x1-1][y1-1]
    # (x1,y1) ~ (x2,y2) 직사각형의 합은 (x2,y1-1)직사각형과 (x1-1,y2) 직사각형의 합에서 x1-1, y1-1 직사각형의 합을 뺀 것
    print(ans)