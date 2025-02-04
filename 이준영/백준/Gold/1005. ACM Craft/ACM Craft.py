# 위상정렬
# 만약 이전 조건이 모두 충족되었다면 pq에 넣는 방식으로 구상
import sys
import heapq

input = sys.stdin.readline

T = int(input())
for tc in range(1, T + 1):

    N, K = map(int, input().split())
    time = [0]
    time.extend(list(map(int, input().split())))
    cnt = [0] * (N + 1)
    nxt = [[] for _ in range(N + 1)]

    for _ in range(K):
        a, b = map(int, input().split())
        nxt[a].append(b)
        cnt[b] += 1

    W = int(input())

    pq = []
    for i in range(1, N + 1):
        if cnt[i] == 0:
            pq.append((time[i], i))

    heapq.heapify(pq)

    while pq:
        t, cur = heapq.heappop(pq)
        if cur == W:
            ans = t
        for i in nxt[cur]:
            if cnt[i] == 0:
                continue
            cnt[i] -= 1
            if cnt[i] == 0:
                heapq.heappush(pq, (t + time[i], i))

    print(ans)