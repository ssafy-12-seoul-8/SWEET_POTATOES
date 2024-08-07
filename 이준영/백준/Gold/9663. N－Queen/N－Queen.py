import sys
sys.setrecursionlimit(10000)
input=sys.stdin.readline
def queen(i,col):
    global count,n
    if col[0]==-1:
        for j in range(n):
            col[0]=j
            queen(0,col)
    else:
        f=0
        for j in range(i):
            if col[i]==col[j] or abs(col[i]-col[j])==i-j:
                f=1
                break
        if f==0:
            if i==n-1:
                count=count+1
            else:
                for j in range(n):
                    col[i+1]=j
                    queen(i+1,col)
n=int(input())
count=0
d=[-1]*n
queen(0,d)
print(count)