import sys
sys.setrecursionlimit(10000)
def start(cur):
    visited[cur] = 1
    for i in road[cur]:
        if visited[i] == 0:
            child[cur].append(i)
            start(i)


def fill_dp(cur):
    if not child[cur]:
        dp[cur][0] = lst[cur]
        return

    sm1, sm2 = 0, 0
    for i in child[cur]:
        fill_dp(i)
        sm1 += dp[i][1]
        sm2 += max(dp[i][0], dp[i][1])
    dp[cur][0] = sm1 + lst[cur]
    dp[cur][1] = sm2


N = int(input())

lst = [0] + list(map(int, input().split()))

road = [[] for _ in range(N + 1)]
child = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b = map(int, input().split())
    road[a].append(b)
    road[b].append(a)

visited = [0] * (N + 1)
start(1)

dp = [[0] * 2 for _ in range(N + 1)]  # 0: 내가 우수마을 1: 내가 우수마을 아님

fill_dp(1)
print(max(dp[1][0], dp[1][1]))
