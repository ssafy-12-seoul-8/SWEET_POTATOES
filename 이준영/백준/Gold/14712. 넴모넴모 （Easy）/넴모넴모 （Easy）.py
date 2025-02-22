# dp같다는 생각을 해보았습니다.
# 이전 줄의 상태만 다음 줄에 영향을 주지 그 이전은 영향을 주지 않기 떄문입니다.
# 따라서 이전 줄의 상태수가 적을 수록 시간복잡도가 유리하다고 생각하였고 그래서
# 세로줄이 항상 더 길거나 같게 설정하였습니다.

N, M = map(int, input().split())

if N < M:
    N, M = M, N

dp = [[0] * (2 ** M) for _ in range(N)]                     # 각 줄의 상태를  0,1로 표시하는 비트마스킹 사용
                                                            # j번째 줄의 상태가 i일 가능한 경우의 수 dp[i][j]
for i in range(2 ** M):                                     # 첫 줄은 다 가능
    dp[0][i] = 1

dct = {}                                                    # dct[j] = [현재 줄의 상태가 j일 때 가능한 전 줄의 상태의 모음]
for j in range(2**M):
    dct[j] = []
    for k in range(2**M):
        tmp = j & k                                         # 둘다 1인 경우만 따지자
        flag = True
        cnt = 0                                             # 연속한 1의 수
        while tmp > 0:                                      # 오른쪽부터 셀거다
            if tmp % 2 == 0:                                # 0이 나오면 1의 수 초기화
                cnt = 0
            else:                                           # 1이 나오면 cnt 증가
                cnt += 1
                if cnt == 2:                                # 이전에 1나왔으면 실패
                    flag = False
                    break
            tmp = tmp // 2                                  # 다음 수 검사
        if flag:                                            # 검사 통과시 가능
            dct[j].append(k)

for i in range(1, N):
    for j in range(2 ** M):
        for k in dct[j]:
            dp[i][j] += dp[i - 1][k]

ans = 0
for j in range(2 ** M):
    ans += dp[N - 1][j]

print(ans)
