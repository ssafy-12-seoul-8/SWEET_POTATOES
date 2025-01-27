from collections import deque
import sys
input=sys.stdin.readline
def D(n):
    return 2*n%10000
def S(n):
    return (n-1)%10000

def L(n):
    return n//1000+(n%1000)*10
def R(n):
    return (n%10)*1000+n//10
def DSLR(n):
    return (D(n),S(n),L(n),R(n))
def bfs(m,n):
    visited={}
    need_visited=deque([])
    need_visited.append(m)
    visited[m]=""
    while need_visited:
        a=need_visited.popleft()
        b=DSLR(a)
        for i in range(4):
            if b[i] not in visited:
                if b[i]==n:
                    return visited[a]+k[i]
                else:
                    c=[]
                    c.append(visited[a])
                    c.append(k[i])
                    visited[b[i]]="".join(c)
                    need_visited.append(b[i])
t=int(input())
for i in range(t):
    m,n=map(int,input().split())
    k=["D","S","L","R"]
    print(bfs(m,n))