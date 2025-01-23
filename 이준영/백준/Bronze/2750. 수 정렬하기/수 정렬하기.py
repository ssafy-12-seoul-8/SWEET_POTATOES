n=input()
n=int(n)
c=[0]*n
d=[0]*n
for i in range(n):
    e=input()
    c[i]=int(e)
for i in range(n):
    f=0
    for j in range(n):
        if c[i]>c[j]:
            f=f+1
    d[f]=c[i]        
for i in range(n):
    print(d[i])