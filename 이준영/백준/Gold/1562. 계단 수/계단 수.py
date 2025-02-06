# 비트마스킹과 dp를 사용하여 풀었습니다. 
# 0과 9가 나온것과 0~9가 모두 나온것이 동치조건임을 활용
N = int(input())
mod = 1000000000
if N < 10:
    print(0)
else:
    dp = [[[0] * 4 for _ in range(10)] for _ in range(N + 1)]   # dp[N][cur][4] 크기이고 첫 변수는 현재 자리수, cur은 현재 숫자
    dp[1][9][1] = 1                                             # 4는 00~11까지 0,9가 나왔는지 판별
    for i in range(1, 9):
        dp[1][i][0] = 1

    for i in range(2, N + 1):
        for j in (2, 3):
            dp[i][1][j] = (dp[i][1][j] + dp[i - 1][0][j]) % mod  # 직전 자리가 0일 때
        for j in (1, 3):
            dp[i][8][j] = (dp[i][8][j] + dp[i - 1][9][j]) % mod  # 직전 자리가 9일 때 
        for j in range(1, 9):
            for k in (-1, 1):
                tmp = j + k
                if tmp == 0:                                     # 직전자리가 1, 현재가 0
                    for l in range(4):
                        dp[i][0][(2 | l)] = (dp[i][0][(2 | l)] + dp[i - 1][1][l]) % mod # 무조건 현재에는 0방문
                elif tmp == 9:                                   # 직전자리가 9, 현재가 8
                    for l in range(4):
                        dp[i][9][(1 | l)] = (dp[i][9][(1 | l)] + dp[i - 1][8][l]) % mod # 무조건 현재에서 9방문
                else:                                            # 나머지
                    for l in range(4):
                        dp[i][tmp][l] = (dp[i][tmp][l] + dp[i - 1][j][l]) % mod
    ans = 0
    for i in range(10):
        ans += dp[N][i][3]
    ans = ans % mod
    print(ans)