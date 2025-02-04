# dp 문제로 dp[i][j]를 arr[i+1:j+2]가 팰린드롬인지 아닌지 여부에 따라 True/False로 한다.
# 길이가 1,2인 것은 직접 입력해주고 그 이후부터는 for문으로 채운다음 쿼리에 답하면 된다.
import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
dp = [[False] * N for _ in range(N)]

for i in range(N):
    dp[i][i] = True
for i in range(N - 1):
    if arr[i] == arr[i + 1]:
        dp[i][i + 1] = True
for i in range(2, N):
    for j in range(N - i):
        if arr[j] == arr[i + j] and dp[j + 1][i + j - 1]:
            dp[j][j + i] = True

M = int(input())
for _ in range(M):
    s, e = map(int, input().split())
    if dp[s - 1][e - 1]:
        print(1)
    else:
        print(0)
