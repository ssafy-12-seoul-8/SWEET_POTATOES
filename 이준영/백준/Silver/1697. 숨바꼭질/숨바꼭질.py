# bfs의 아이디어
# N으로부터의 거리를 딕셔너리에 저장하여 visited 역할을 동시에 했다.
from collections import deque

N, K = map(int, input().split())
dis = {}

dq = deque([N])
dis[N] = 0

while dq:
    cur = dq.popleft()
    if cur == K:
        print(dis[K])
        break
    for tmp in (cur - 1, cur + 1, 2 * cur):
        if tmp in dis:                          # dis를 dq로 잘못 써서 틀림
            continue
        if tmp < 0 or tmp > 140000:             # 14만 이상이 되는 거면 기존보다 무조건 오래 걸림
            continue
        dis[tmp] = dis[cur] + 1
        dq.append(tmp)


