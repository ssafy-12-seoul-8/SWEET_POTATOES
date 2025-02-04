# 위상정렬
# 일반 리스트를 사용해도 상관없지만 deque 사용
import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
nxt = [[] for _ in range(N + 1)]
cnt = [0] * (N + 1)
for _ in range(M):
    a, b = map(int, input().split())
    nxt[a].append(b)
    cnt[b] += 1

q = deque([])
ans = []
for i in range(1, N + 1):
    if cnt[i] == 0:        
        q.append(i)         

while q:
    tmp = q.popleft()
    ans.append(tmp)
    for i in nxt[tmp]:
        cnt[i] -= 1
        if cnt[i] == 0:      # 조건을 만족했으므로 q에 넣는다
            q.append(i)

print(*ans)
