import sys
input=sys.stdin.readline
def calc():
    global minimum
    count=0
    for i in house:
        distance=101
        for j in remain:
            distance=min(distance,abs(i[0]-j[0])+abs(i[1]-j[1]))
        count=count+distance
    minimum=min(minimum,count)
def choose(a,b):
    if b==m:
        calc()
        return
    elif a>l-1:
        return
    else:
        f=remain[b]
        remain[b]=chicken[a]
        choose(a+1,b+1)
        remain[b]=f
        choose(a+1,b)
n,m=map(int,input().split())
minimum=int(1e9)
c=[0]*n
house=[]
chicken=[]
remain=[0]*m
for i in range(n):
    c[i]=list(map(int,input().split()))
for i in range(n):
    for j in range(n):
        if c[i][j]==1:
            house.append((i,j))
        elif c[i][j]==2:
            chicken.append((i,j))
l=len(chicken)
choose(0,0)
print(minimum)