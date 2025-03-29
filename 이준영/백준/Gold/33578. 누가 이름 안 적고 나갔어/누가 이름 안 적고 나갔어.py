import sys
input = sys.stdin.readline

def oob(y,x):
    return not(0<=y<N and 0<=x<M)
N,M = map(int,input().split())
arr = [list(input().rstrip()) for _ in range(N)]
dy = [0,0,1,-1]
dx = [1,-1,0,0]

for i in range(N):
    for j in range(M):
        if arr[i][j]=="J":
            jy,jx = i,j
            arr[i][j] ="."
        if arr[i][j]=="S":
            ey,ex = i,j
            arr[i][j]="."

j_dq = [[(jy,jx)],[]]
t_dq = []

j_visited = [[0]*M for _ in range(N)]
t_visited = [[0]*M for _ in range(N)]
ans = -1
time = 0
j_visited[jy][jx] = 1
while True:
    # print(time)
    # print(j_dq)
    # print(t_dq)
    # print("-"*50)
    cur_j_dq = j_dq.pop(0)

    tmp_j_dq = []
    if cur_j_dq:
        for y,x in cur_j_dq:
            if (y,x)==(ey,ex):
                ans = time
                break
            if arr[y][x]=="T":
                t_dq.append((y,x))
                arr[y][x]="."
                
            for k in range(4):
                ny = y+dy[k]
                nx = x+dx[k]
                if not oob(ny,nx) and arr[ny][nx]!="#" and t_visited[ny][nx]==0 and j_visited[ny][nx] == 0:
                    tmp_j_dq.append((ny,nx))
                    j_visited[ny][nx] =1

    if ans!=-1:
        break

    j_dq.append(tmp_j_dq)
    
    if t_dq:
        tmp_t_dq = []
        for y,x in t_dq:
            if (y,x)==(ey,ex):
                ans = time
                break
                
            for k in range(4):
                ny = y+dy[k]
                nx = x+dx[k]
                if not oob(ny,nx) and arr[ny][nx]!="#" and t_visited[ny][nx]==0:
                    t_visited[ny][nx] = 1
                    j_visited[ny][nx] = 1
                    tmp_t_dq.append((ny,nx))

        if ans!=-1:
            break

        t_dq = tmp_t_dq

    if ans!=-1:
        break


    if not j_dq[0] and not j_dq[1] and not t_dq:
        break

    time+=1

print(ans)