import heapq
from collections import deque
import sys
input=sys.stdin.readline
n,k=map(int,input().split())
jew=[]
bag=[]
save=[]
visit=[False]*(n+1)
price=0
for i in range(n):
    a,b=map(int,input().split())
    jew.append((a,b))
for i in range(k):
    bag.append(int(input()))
jew.sort()
jew=deque(jew)
bag.sort()
for i in bag:
    while jew and jew[0][0]<=i:
        a=jew.popleft()
        heapq.heappush(save,-a[1])
    if save:
        price=price-heapq.heappop(save)
print(price)