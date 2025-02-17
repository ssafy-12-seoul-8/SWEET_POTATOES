# dp를 활용한 방법
# dp[i] : i번 인덱스 돌까지 갈 수 있는 최소의 K
# 그 전에 j번 인덱스 돌을 밟을 때와 비교하여 더 작은 값으로 갱신하면 된다.
import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

dp = [1_000_000] * N                    # 한 칸 갈 때 최대 10^6만큼 들기에 이 값이 최대값이다.

dp[0] = 0
for i in range(1, N):
    for j in range(i):
        dp[i] = min(dp[i], max(dp[j], (i - j) * (1 + abs(A[i] - A[j]))))

print(dp[N - 1])
