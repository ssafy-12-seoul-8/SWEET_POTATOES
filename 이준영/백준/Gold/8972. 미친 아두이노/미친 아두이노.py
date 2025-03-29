def delta(y,ny):
    if y>ny:
        return -1
    elif y<ny:
        return 1
    return 0

def myprint():
    tmp_arr = [row[:] for row in arr]
    tmp_arr[sy][sx] = "I"
    for i in range(R):
        print(*tmp_arr[i],sep="")

    print("-"*50)
        
R,C = map(int,input().split())
arr =[list(input()) for _ in range(R)]
lst = list(map(int,input()))
dy = [0,1,1,1,0,0,0,-1,-1,-1]
dx = [0,-1,0,1,-1,0,1,-1,0,1]

ard = []
for i in range(R):
    for j in range(C):
        if arr[i][j]=="I":
            sy,sx = i,j
            arr[i][j]="."
        if arr[i][j]=="R":
            ard.append((i,j))

res = True


for time in range(len(lst)):
    num = lst[time]
    ny = sy+dy[num]
    nx = sx+dx[num]

    if arr[ny][nx]=="R":
        res = False
        break

    sy,sx = ny,nx
    will_del = set()
    tmp_arr = [["."]*C for _ in range(R)]
    
    for i in range(len(ard)):
        if ard[i][0]==-1:
            continue

        y,x = ard[i]

        if arr[y][x]==".":
            ard[i] = [-1,-1]
            continue

        nny = y+delta(y,sy)
        nnx = x+delta(x,sx)
        
        
        if (nny,nnx) == (sy,sx):
            res = False
            break
            
        elif tmp_arr[nny][nnx]==".":
            tmp_arr[nny][nnx]="R"
            ard[i] = [nny,nnx]
        else:
            will_del.add((nny,nnx))
            ard[i] = [-1,-1]

    for y,x in will_del:
        tmp_arr[y][x] = "."
        
    if not res:
        break
    arr= tmp_arr    

if not res:
    print(f'kraj {time+1}')

else:
    arr[sy][sx] = "I"
    for i in range(R):
        print(*arr[i],sep="")

        
        