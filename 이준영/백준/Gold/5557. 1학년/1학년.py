# dp[i][j] i번 인덱스까지 연산했을 때 점수가 j인 경우의 수
# N-2번 인덱스까지의 계산 결과가 arr[N-1]이면 된다. (중간에 0이상 20이하여야 함)
N = int(input())
arr = list(map(int, input().split()))

dp = [[0] * 21 for _ in range(N - 1)]

dp[0][arr[0]] = 1

for i in range(N - 2):
    for j in range(21):
        if j + arr[i + 1] < 21:                     # 값이 20을 초과하지 않으면
            dp[i + 1][j + arr[i + 1]] += dp[i][j]

        if j - arr[i + 1] >= 0:                     # 값이 음수가 안되면
            dp[i + 1][j - arr[i + 1]] += dp[i][j]

print(dp[N - 2][arr[N - 1]])
