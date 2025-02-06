import sys
input=sys.stdin.readline
c=input().strip()
l=len(c)
dp=[int(1e9)]*l
check=[[0 for _ in range(l)] for _ in range(l)]
if l==1:
    print(1)
elif l==2:
    if c[0]==c[1]:
        print(1)
    else:
        print(2)
else:   
    check[l-1][l-1]=1
    for i in range(l-1):
        check[i][i]=1
        if c[i]==c[i+1]:
            check[i][i+1]=1
    for j in range(2,l):
        for i in range(l-j):
            if c[i]==c[i+j] and check[i+1][i+j-1]==1:
                check[i][i+j]=1
    dp[0]=1
    if c[0]==c[1]:
        dp[1]=1
    else:
        dp[1]=2
    for i in range(2,l):
        if check[0][i]==1:
            dp[i]=1
        else:
            for k in range(1,i+1):
                if check[k][i]==1:
                    dp[i]=min(dp[i],1+dp[k-1])
    print(dp[l-1])