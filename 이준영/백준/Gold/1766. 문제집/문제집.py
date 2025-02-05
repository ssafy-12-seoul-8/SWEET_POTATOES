# 위상정렬 + 우선순위 큐 문제
# 가능한 문제 중 가장 낮은 걸 택해야 하기에 우선순위를 사용하였다.
# cnt배열로 풀기 위해 남은 문제수를 다루었으며 0이 되는 순가 pq에 넣었다.
import sys
import heapq

input = sys.stdin.readline

N, M = map(int, input().split())
cnt = [0] * (N + 1)
nxt = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    nxt[a].append(b)
    cnt[b] += 1

pq = []
for i in range(1, N + 1):
    if cnt[i] == 0:
        pq.append(i)

heapq.heapify(pq)
ans = []
while pq:
    tmp = heapq.heappop(pq)
    ans.append(tmp)
    for i in nxt[tmp]:
        cnt[i] -= 1
        if cnt[i] == 0:
            heapq.heappush(pq, i)

print(*ans)
