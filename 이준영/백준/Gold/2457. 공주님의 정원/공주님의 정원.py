import sys
from heapq import heappush, heappop

input = sys.stdin.readline
N = int(input())
lst = [0] * N
for i in range(N):
    a, b, c, d = map(int, input().split())
    lst[i] = (a * 100 + b, c * 100 + d)

lst.sort()
pq = []
start = 301
cnt = 0
idx = 0
while True:
    if start > 1130 or idx >= N:
        break

    while idx < N and lst[idx][0] <= start:
        heappush(pq, -lst[idx][1])
        idx += 1

    if not pq:
        break

    while pq:
        a = heappop(pq)
        if -a > start:
            start = -a
            cnt += 1
            break

if start <= 1130:
    print(0)
else:
    print(cnt)
