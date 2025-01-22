import sys
import heapq
input = sys.stdin.readline
pq= []
heapq.heapify(pq)
N = int(input())
for _ in range(N):
    x = int(input())
    if x==0:
        if not pq:
            print(0)
        else:
            print(heapq.heappop(pq))
    else:
        heapq.heappush(pq,x)