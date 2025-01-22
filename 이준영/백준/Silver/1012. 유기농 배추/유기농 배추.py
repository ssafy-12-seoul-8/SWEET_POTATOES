import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
dy = [0,0,1,-1]
dx = [1,-1,0,0]
for tc in range(T):
    count = 0
    M, N, K = map(int,input().split())
    ground =[[0 for _ in range(M)]for _ in range(N)]
    visited = [[False for _ in range(M)]for _ in range(N)]
    for i in range(K):
        X,Y = map(int,input().split())
        ground[Y][X] = 1
    for i in range(N):
        for j in range(M):
            if ground[i][j]==1:
                count+=1
                dq = deque([(i,j)])
                while(dq):
                    tmp = dq.popleft()
                    for k in range(4):
                        ny = tmp[0] + dy[k]
                        nx = tmp[1] + dx[k]
                        if(0<=ny<N and 0<=nx<M and ground[ny][nx]==1):
                            ground[ny][nx] = 0
                            dq.append([ny,nx])
    print(count)

