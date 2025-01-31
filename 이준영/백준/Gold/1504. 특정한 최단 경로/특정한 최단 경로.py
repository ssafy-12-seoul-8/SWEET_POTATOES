import sys
input=sys.stdin.readline
def dijk(start):
    distance=[int(1e9)]*(n+1)
    distance[start]=0
    queue=[]
    heapq.heappush(queue,(0,start))
    while queue:
        a,b=heapq.heappop(queue)
        if a>distance[b]:
            continue
        else:
            for c,d in check[b].items():
                if a+d<distance[c]:
                    distance[c]=a+d
                    heapq.heappush(queue,(a+d,c))
    return distance
import heapq
n,e=map(int,input().split())
count=0
check={}
for i in range(1,n+1):
    check[i]={i:0}
for i in range(e):
    a,b,c=map(int,input().split())
    check[a][b]=c
    check[b][a]=c
v1,v2=map(int,input().split())
d=dijk(1)
e=dijk(v1)
f=dijk(v2)
count=min(d[v1]+e[v2]+f[n],d[v2]+f[v1]+e[n])
if count>=int(1e9):
    print(-1)
else:
    print(count)