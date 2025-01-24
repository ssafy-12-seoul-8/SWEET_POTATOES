import sys
input = sys.stdin.readline

H,W = map(int,input().split())
cloud = [0]*H
for i in range(H):
    cloud[i] = list(input().rstrip())
result = [[0 for _ in range(W)]for _ in range(H)]
for i in range(H):
    start = -1
    for j in range(W):
        if cloud[i][j]=="c":
            result[i][j]=0
            start = j
        else:
            if start==-1:
                result[i][j]=-1
            else:
                result[i][j]=j-start
for i in range(H):
    for j in range(W):
        print(result[i][j],end=" ")
    print()