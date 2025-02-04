# dp문제로 dp[i][j]는 B[:i]와 A[:j]의 lcs다
import sys

input = sys.stdin.readline

A = input().rstrip()
B = input().rstrip()
l1 = len(A)
l2 = len(B)

dp = [["" for _ in range(l1 + 1)] for _ in range(l2 + 1)]
for i in range(1, l2 + 1):
    for j in range(1, l1 + 1):
        if B[i - 1] == A[j - 1]:
            if len(dp[i - 1][j - 1]) + 1 > len(dp[i][j - 1]):
                dp[i][j] = "".join([dp[i - 1][j - 1], B[i - 1]])
            else:
                dp[i][j] = dp[i][j - 1]
        else:
            if len(dp[i][j - 1]) > len(dp[i - 1][j]):
                dp[i][j] = dp[i][j - 1]
            else:
                dp[i][j] = dp[i - 1][j]

if len(dp[l2][l1]) == 0:
    print(0)
else:
    print(len(dp[l2][l1]))
    print(dp[l2][l1])
