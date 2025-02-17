import sys
import heapq

input = sys.stdin.readline
pq = []
heapq.heapify(pq)
N = int(input())
for _ in range(N):
    x = int(input())
    if x == 0:
        if not pq:                      # 비어있으면 0을 출력
            print(0)
        else:
            print(heapq.heappop(pq))    # 비어있지 않으면 빼면서 출력
    else:
        heapq.heappush(pq, x)           # pq에 x 삽입
