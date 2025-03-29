from collections import deque
def oob(y,x):
    return not (0<=y<N and 0<=x<M)

N,M = map(int,input().split())
arr = [list(input()) for _ in range(N)]
dy = [1,1,-1,-1,0,0,1,-1,0]
dx = [1,-1,1,-1,1,-1,0,0,0]

for i in range(N):
    for j in range(M):
        if arr[i][j]=="A":
            ay,ax = i,j
            arr[i][j]="."
        elif arr[i][j]=="B":
            by,bx = i,j
            arr[i][j]="."

visited = set([(ay,ax,by,bx)])
ans = -1
dq = deque([(ay,ax,by,bx,0)])
while dq:
    cay,cax,cby,cbx,dis = dq.popleft()
    if (cay,cax) ==(by,bx) and (cby,cbx)==(ay,ax):
        ans = dis
        break
        
    for k1 in range(9):
        nay = cay + dy[k1]
        nax = cax + dx[k1]
        if not oob(nay,nax) and arr[nay][nax]==".":
            for k2 in range(9):
                if k1 == 0 and k2==0:
                    continue
                nby = cby+dy[k2]
                nbx = cbx+dx[k2]
                if not oob(nby,nbx) and arr[nby][nbx]=="." and (nay,nax,nby,nbx) not in visited:
                    if ((cay,cax) == (nby,nbx) and (cby,cbx) ==(nay,nax)) or (nby,nbx)==(nay,nax):
                        continue
                    
                    visited.add((nay,nax,nby,nbx))
                    dq.append((nay,nax,nby,nbx,dis+1))
                        
print(ans)