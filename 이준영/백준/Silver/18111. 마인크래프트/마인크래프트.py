import sys
input=sys.stdin.readline
n,m,b=map(int,input().split())
c=[0]*257
e=[]
for i in range(n):
    d=list(map(int,input().split()))
    e=e+d
    for j in range(m):
        c[d[j]]=c[d[j]]+1
f=(sum(e)+b)//(n*m)
f=min(f,max(e))
g=min(e)
time=256*500*500*2
height=256
for i in range(f,g-1,-1):
    h=0
    for j in range(i):
        h=h+c[j]*(i-j)
    for j in range(i,257):
        h=h+2*c[j]*(j-i)
    if h<time:
        time=h
        height=i
print(time,height)