# 상어가 어느 칸을 가야지 최고인지 모르기 때문에 가능한 칸을 가는 경우를 모두 해봐야 한다.
# 물고기들이 일괄적으로 움직이는 함수를 만들고 상어가 먹는 경우의 수에 대한 백트래킹 코드를 짰다.
# arr에는 각 물고기의 번호 (0:상어, -1:빈칸, 1~16: 물고기)를 담았고,
# loc에는 1~ 16까지의 y,x,d정보를 담았다. (단, 물고기가 죽었을 경우 -1,-1,-1)이 된다.

# 물고기들의 이동
def fish_move():
    for i in range(1, 17):
        
        if loc[i][0] != -1:                 # 물고기가 살아있다면
            y, x, d = loc[i]                # 물고기의 좌표와 방향 정보 불러오자
            for k in range(8):              # 회전을 해볼건데
                tmp = (d + k) % 8           # 임시 방향
                ny = y + dy[tmp]
                nx = x + dx[tmp]

                # 이 방향이 범위를 벗어나지 않고 상어가 없다면
                if 0 <= ny < 4 and 0 <= nx < 4 and arr[ny][nx] != 0:
                    t_num = arr[ny][nx]
                    arr[ny][nx] = i         # 이동한다. (arr과 loc정보 업데이트)
                    loc[i] = [ny, nx, tmp]
                    arr[y][x] = t_num

                    if t_num > 0:           # 그 곳이 빈칸이 아니었다면
                        loc[t_num] = [y, x, loc[t_num][2]]  # 그 물고기의 정보도 업데이트 해줘야 한다.
                    break

# 백트래킹 (상어의 좌표, 상어의 방향, 현재 점수)
def btk(y, x, d, score):
    global mx, arr, loc

    t_arr = [row[:] for row in arr]             # 원래 수조의 물고기 상태
    t_loc = [row[:] for row in loc]             # 원래 물고기의 위치 정보
    flag = False                                # 상어 이동 가능여부를 담는 것
    
    for k in range(1, 4):                       # 최대 3칸까지만 이동 가능 (이걸 실수로 3으로 해서 틀림)
        ny = y + dy[d] * k
        nx = x + dx[d] * k
        
        if not (0 <= ny < 4 and 0 <= nx < 4):   # 범위를 벗어나면 더 가봐야 의미 없음 (계속 범위를 벗어날거니까)
            break

        if arr[ny][nx] > 0:                     # 범위를 안벗어났는데 그 칸에 물고기 있으면 먹어보자
            flag = True
            num = arr[ny][nx]                   # 그 물고기 번호
            t_d = loc[num][2]                   # 그 물고기 방향
            loc[num] = [-1, -1, -1]             # 물고기 사망 처리
            arr[ny][nx] = 0                     # 그 칸으로 상어 이동
            arr[y][x] = -1                      # 상어가 원래 있던 칸은 빈 칸 처리
            fish_move()                         # 물고기 이동
            btk(ny, nx, t_d, score + num)       # 백트래킹
            
            loc = [row[:] for row in t_loc]     # 원상 복귀
            arr = [row[:] for row in t_arr]         
    
    if not flag:                                # 한 곳도 갈 수 없었다면 집 갈 시간
        mx = max(mx, score)                     # 최대값 갱신


dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
arr = [[0] * 4 for _ in range(4)]               # 물고기 번호만 담을 거다.

loc = [0] * 17                                  # [물고기y좌표, x좌표, 방향] 담을거다.

for i in range(4):
    lst = list(map(int, input().split()))

    for j in range(4):
        num = lst[2 * j]                        # 2개 단위로 보자
        d = lst[2 * j + 1] - 1
        arr[i][j] = num                         # 번호 적어놓고
        loc[num] = [i, j, d]                    # 위치 정보 저장하고

tot = arr[0][0]                                 # 처음에 물고기 먹음
loc[0] = [0, 0, loc[tot][2]]                    # 상어 위치정보 갱신 (이후에 안쓰임)
loc[arr[0][0]] = [-1, -1, -1]                   # 물고기 사망처리

mx = 0                                          # 상어 물고기 먹는 최대값
arr[0][0] = 0                                   # 0,0에 상어가 들어갔다.

fish_move()                                     # 일단 물고기 이동

btk(0, 0, loc[0][2], tot)                       # 백트래킹 시작

print(mx)
