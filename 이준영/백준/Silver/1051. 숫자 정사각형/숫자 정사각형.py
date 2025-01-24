import sys
input = sys.stdin.readline

N,M = map(int,input().split())
rec = [0]*N
for i in range(N):
    rec[i] = list(map(int,input().strip()))
max_len = 0
for i in range(N-1):
    for j in range(M-1):
        for k in range(min(N-i,M-j)):
            if rec[i][j] == rec[i][j+k] == rec[i+k][j] == rec[i+k][j+k]:
                max_len = max(max_len,k)
print((max_len+1)**2)