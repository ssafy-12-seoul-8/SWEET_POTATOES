# 최대힙을 구현하는 방법은 x대신 -x를 넣고 꺼내고 값을 쓸 때 다시 부호를 바꿔서 쓰는 것이다.
import sys
from heapq import heappop, heappush

input = sys.stdin.readline

N = int(input())
pq = []
for _ in range(N):
    x = int(input())
    if x == 0:
        if not pq:
            print(0)
        else:   
            print(-heappop(pq))         # 빼면서 부호바꿔서 출력

    else:
        heappush(pq, -x)                # 부호 바꾼 채로 삽입
