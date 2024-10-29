import sys
input=sys.stdin.readline
n=int(input())
home=[0]*n
board=[0]*n
for i in range(n):
    home[i]=list(map(int,input().split()))
    board[i]=[0]*n #가로 세로 대각으로 끝나는
for i in range(n):
    for j in range(n):
        board[i][j]=[0,0,0]
for i in range(1,n):
    if home[0][i]==0:
        board[0][i][0]=1
    else:
        break
for i in range(1,n):
    for j in range(2,n):
        if home[i][j]==1:
            continue
        else:
            board[i][j][0]=board[i][j-1][0]+board[i][j-1][2]
            if i==1:
                board[i][j][1]=0
            else:
                board[i][j][1]=board[i-1][j][1]+board[i-1][j][2]
            if home[i][j-1]==1 or home[i-1][j]==1:
                board[i][j][2]=0
            else:
                board[i][j][2]=board[i-1][j-1][0]+board[i-1][j-1][1]+board[i-1][j-1][2]
c,d,e=board[n-1][n-1]
print(c+d+e)