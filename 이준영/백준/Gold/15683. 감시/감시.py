def oob(y, x):
    return not (0 <= y < n and 0 <= x < m)


# 백트래킹 - 이번의 체스말이 가는 방향에 따른 비어있는 칸을 관리한다.
# (현재 결정할 체스말 번호, 지금까지 말에 의해 덮인 영역)
def btk(cur, cnt):
    global mx_go
    
    # 다 놨으면 갱신
    if cur == l:
        mx_go = max(mx_go, cnt)
        return


    num, y, x = chess[cur]
    for rotation in range(possible_num[num]):                   # 가능한 회전수만큼만 고려한다.
        stk = []                                                # 방향을 골랐을 때 그 방향으로 가면서 채워지는 빈칸의 좌표 리스트
        
        for d in direction[num]:                                
            tmp = (d + rotation) % 4                            # 회전을 고려한 방향
            ny = y
            nx = x
            
            while True:
                nny = ny + dy[tmp]
                nnx = nx + dx[tmp]
                
                if oob(nny, nnx) or board[nny][nnx] == 6:       # 범위를 벗어나거나 6을 만나면 그만 간다.
                    break
                    
                ny, nx = nny, nnx
                if board[ny][nx] == 0:                          # 그렇지 않다면 계속 가며, 빈 칸을 만나면 stk에 저장해두고 -1로 바꿈
                    board[ny][nx] = -1
                    stk.append((ny, nx))

        btk(cur + 1, cnt + len(stk))                            # 백트래킹하고
        for ny, nx in stk:                                      # -1로 바꾸었던 좌표들을 다시 빈칸으로 바꿔줌
            board[ny][nx] = 0


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
possible_num = [0, 4, 2, 4, 4, 1]
direction = [[], [0], [0, 2], [0, 1], [0, 1, 2], [0, 1, 2, 3]]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

chess = []                                                      # (체스말 번호,y좌표, x좌표) 리스트
tot = 0                                                         # 총 빈칸 수 
for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            tot += 1
            
        elif board[i][j] < 6:
            chess.append((board[i][j], i, j))

mx_go = 0
l = len(chess)
btk(0, 0)
print(tot - mx_go)