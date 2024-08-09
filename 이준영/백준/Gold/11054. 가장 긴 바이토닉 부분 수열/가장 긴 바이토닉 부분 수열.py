import sys
input=sys.stdin.readline
n=int(input())
c=list(map(int,input().split()))
d=list(reversed(c))
e=[1]*n
f=[1]*n
m=0
for i in range(n):
    for j in range(0,i):
        if c[i]>c[j]:
            e[i]=max(e[i],e[j]+1)
for i in range(n):
    for j in range(0,i):
        if d[i]>d[j]:
            f[i]=max(f[i],f[j]+1)
for i in range(n):
    m=max(m,e[i]+f[n-i-1])
print(m-1)