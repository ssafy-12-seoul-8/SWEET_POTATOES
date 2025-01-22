def check(length,y,x):
    global w_count, b_count
    if length==1:
        if paper[y][x] == 1:
            b_count+=1
        else:
            w_count+=1
        return
    for i in range(y,y+length):
        for j in range(x,x+length):
            if paper[y][x] != paper[i][j]:
                check(length//2,y,x)
                check(length//2,y,x+length//2)
                check(length//2,y+length//2,x)
                check(length//2,y+length//2,x+length//2)
                return
    if paper[y][x] == 1:
        b_count += 1
    else:
        w_count += 1
    return

import sys
input = sys.stdin.readline
n = int(input())
paper = [0]*n
w_count = 0
b_count = 0
for i in range(n):
    paper[i] = list(map(int,input().split()))

check(n,0,0)
print(w_count)
print(b_count)
