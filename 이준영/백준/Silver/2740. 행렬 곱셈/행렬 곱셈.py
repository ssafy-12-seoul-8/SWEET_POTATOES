N, M = map(int,input().split())
A = [0] * N
for i in range(N):
    A[i] = list(map(int,input().split()))

M, K = map(int,input().split())
B = [0] * M
for i in range(M):
    B[i] = list(map(int,input().split()))

for i in range(N):
    for j in range(K):
        sm = 0
        for k in range(M):
            sm += A[i][k] * B[k][j]
        print(sm,end=" ")
    print()