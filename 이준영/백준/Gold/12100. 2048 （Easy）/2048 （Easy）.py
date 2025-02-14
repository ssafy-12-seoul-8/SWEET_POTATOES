import sys
input=sys.stdin.readline
def left(state,length):
    b=[[0 for _ in range(length)] for _ in range(length)]
    for i in range(length):
        stack=[]
        for j in range(length):
            k=0
            a=state[i][j]
            if a!=0:
                if not stack:
                    stack.append(a)
                elif a==stack[-1]:
                    stack[-1]=2*a
                    stack.append(0)
                else:
                    stack.append(a)
        for j in stack:
            if j!=0:
                b[i][k]=j
                k+=1
    return b
def right(state,length):
    b=[[0 for _ in range(length)] for _ in range(length)]
    for i in range(length):
        stack=[]
        for j in range(length-1,-1,-1):
            k=length-1
            a=state[i][j]
            if a!=0:
                if not stack:
                    stack.append(a)
                elif a==stack[-1]:
                    stack[-1]=2*a
                    stack.append(0)
                else:
                    stack.append(a)
        for j in stack:
            if j!=0:
                b[i][k]=j
                k-=1
    return b
def up(state,length):
    b=[[0 for _ in range(length)] for _ in range(length)]
    for j in range(length):
        stack=[]
        for i in range(length):
            k=0
            a=state[i][j]
            if a!=0:
                if not stack:
                    stack.append(a)
                elif a==stack[-1]:
                    stack[-1]=2*a
                    stack.append(0)
                else:
                    stack.append(a)
        for i in stack:
            if i!=0:
                b[k][j]=i
                k+=1
    return b
def down(state,length):
    b=[[0 for _ in range(length)] for _ in range(length)]
    for j in range(length):
        stack=[]
        for i in range(length-1,-1,-1):
            k=length-1
            a=state[i][j]
            if a!=0:
                if not stack:
                    stack.append(a)
                elif a==stack[-1]:
                    stack[-1]=2*a
                    stack.append(0)
                else:
                    stack.append(a)
        for i in stack:
            if i!=0:
                b[k][j]=i
                k-=1
    return b
def bt(state,length,count):
    global maximum
    if count==5:
        for i in range(length):
            for j in range(length):
                maximum=max(maximum,state[i][j])
    else:
        bt(up(state,length),length,count+1)
        bt(down(state,length),length,count+1)
        bt(left(state,length),length,count+1)
        bt(right(state,length),length,count+1)

n=int(input())     
d=[0]*n
maximum=0
for i in range(n):
    d[i]=list(map(int,input().split()))
bt(d,n,0)
print(maximum)