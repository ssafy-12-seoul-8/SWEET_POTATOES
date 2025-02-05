import sys
input=sys.stdin.readline
n=int(input())
a=[0]*n
b=[0]*n
c=[0]*n
d=[0]*n
count=0
e={}
for i in range(n):
    a[i],b[i],c[i],d[i]=map(int,input().split())
for i in a:
    for j in b:
        if i+j in e:
            e[i+j]+=1
        else:
            e[i+j]=1
for i in c:
    for j in d:
        if -i-j in e:
            count=count+e[(-i-j)]
print(count)