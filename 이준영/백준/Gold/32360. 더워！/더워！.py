from collections import deque
def oob(y,x):
    return not(0<=y<N and 0<=x<M)
N,M = map(int,input().split())
K,C = map(int,input().split())

arr = [list(input()) for _ in range(N)]

dy = [0,0,1,-1]
dx = [1,-1,0,0]
visited = [[100]*M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if arr[i][j] =="S":
            sy,sx = i,j
            arr[i][j]="H"

        elif arr[i][j]=="E":
            ey,ex = i,j
            arr[i][j] = "."

visited[sy][sx] = 0
dq = deque([(sy,sx,0)])

ans = -1
time = 0
while dq:

    for _ in range(len(dq)):
        y,x,B = dq.popleft()

        if (y,x)==(ey,ex):
            ans = time
            break
    
        if arr[y][x]=="H":
            tmp = max(0,B-K)
            if visited[y][x] > tmp:
                visited[y][x] = tmp
                dq.append((y,x,tmp))

        for k in range(4):
            ny = y+dy[k]
            nx = x+dx[k]
            if not oob(ny,nx) and arr[ny][nx]!="#":
                if arr[ny][nx] == "H":
                    tmp = max(0,B-K)
                    if visited[ny][nx] > tmp:
                        visited[ny][nx] = tmp
                        dq.append((ny,nx,tmp))
                else:
                    tmp = min(100,B+C)
                    if visited[ny][nx] > tmp:
                        visited[ny][nx] = tmp
                        dq.append((ny,nx,tmp))
    if ans!=-1:
        break
    time+=1
print(ans)
                            