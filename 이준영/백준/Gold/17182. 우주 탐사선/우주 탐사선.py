from heapq import heappush, heappop

N, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

dp = [[int(1e9)] * (1 << N) for _ in range(N)]

dp[K][1 << K] = 0
pq = []
heappush(pq, (0, K, 1 << K))

while pq:
    dis, des, state = heappop(pq)
    if dis > dp[des][state]:
        continue

    for i in range(N):
        if i == des:
            continue
        tmp_state = (state | (1 << i))
        if dp[i][tmp_state] > dis + arr[des][i]:
            dp[i][tmp_state] = dis + arr[des][i]
            heappush(pq, (dp[i][tmp_state], i, tmp_state))

mn = int(1e9)

for k in range(N):
    mn = min(mn, dp[k][(1 << N) - 1])

print(mn)