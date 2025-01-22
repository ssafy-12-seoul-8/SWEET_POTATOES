def conquer(n,y,x):
    global count
    if n==0:
        return
    if y>2**(n-1):
        if x>2**(n-1):
            count = count + 3*2**(2*n-2)
            conquer(n-1,y-2**(n-1),x-2**(n-1))
        else:
            count = count + 2*2**(2*n-2)
            conquer(n-1,y-2**(n-1),x)
    else:
        if x > 2 ** (n - 1):
            count = count + 2 ** (2*n - 2)
            conquer(n - 1, y, x - 2 ** (n - 1))
        else:
            conquer(n - 1, y, x)

import sys
input = sys.stdin.readline
N, r, c = map(int,input().split())
count = 0
conquer(N,r+1,c+1)
print(count)