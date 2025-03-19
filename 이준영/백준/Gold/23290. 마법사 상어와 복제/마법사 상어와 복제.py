# 냄새맵은 하나의 배열로 임시배열을 쓰지 않고 관리하였고, 물고기의 번호가 중요하지는 않기에 각 좌표와 방향 별 물고기 수를 관리하였다.
# 이 생각을 한 것은 복제를 하다보면 물고기가 엄청 많아질 수 있다고 생각해서이다.
# 상어도 위치만 관리해주었다.
# arr 배열은 원래 상어와 물고기 위치를 위해 놔두려고 했는데 실제 코드에서 쓰이지 않았다.

# 상어가 i,j,k 순으로 갈 수 있냐와 갈 수 있으면 물고기를 몇 개 먹는지를 반환

def go(i, j, k, y, x):
    lst = [i, j, k]
    st = set([])                                            # 같은 곳을 여러번 지날지도?
    for i in range(3):
        y = y + sdy[lst[i]]
        x = x + sdx[lst[i]]
        if not (0 <= y < 4 and 0 <= x < 4):                 # 범위를 벗어나면 유효하지 않은 이동이므로 -1,-1,-1 리턴
            return -1

        st.add((y, x))
    cnt = 0
    for i, j in st:
        for k in range(8):
            cnt = cnt + new_fish_loc[i][j][k]

    return cnt


M, S = map(int, input().split())

fish_loc = [[[0] * 8 for _ in range(4)] for _ in range(4)]  # (y,x)에서 d방향 물고기가 몇개 있는지
smell_map = [[0] * 4 for _ in range(4)]                     # 냄새 배열 (남은시간표시)

dy = [0, -1, -1, -1, 0, 1, 1, 1]                            # 물고기의 방향
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
sdy = [-1, 0, 1, 0]                                         # 상어의 방향 (우선순위 고려)
sdx = [0, -1, 0, 1]

for _ in range(M):
    y, x, c = map(int, input().split())
    fish_loc[y - 1][x - 1][c - 1] += 1                      # 그 좌표의 그 방향에 +1

s_y, s_x = map(int, input().split())
s_y -= 1
s_x -= 1

for _ in range(S):
    tmp_fish_loc = [[lst[:] for lst in row] for row in fish_loc]    # 현재 물고기의 상태(복제를 위한)
    new_fish_loc = [[[0] * 8 for _ in range(4)] for _ in range(4)]  # 바뀐 물고기 상태를 저장할 배열
    
    for i in range(4):
        for j in range(4):
            for l in range(8):
                
                if fish_loc[i][j][l] != 0:                          # 물고기가 있다면 시행하자
                    cnt = fish_loc[i][j][l]                         # 옮길 물고기 수

                    for k in range(8):
                        tmp = (l - k) % 8                           # 문제의 증가하는 방향이 아닌 반대로 가야 됨!
                        ny = i + dy[tmp]
                        nx = j + dx[tmp]
                                                                    # 격자를 벗어나지 않고 냄새와 상어가 없다면
                        if 0 <= ny < 4 and 0 <= nx < 4 and smell_map[ny][nx] == 0 and (ny, nx) != (s_y, s_x):
                            new_fish_loc[ny][nx][tmp] += cnt        # 이 방향으로 가자
                            break

                    else:                                           # 아니면 이동하지 못하니 기존 좌표와 방향에 더해주자
                        new_fish_loc[i][j][l] += cnt

    for i in range(4):                                              # 이제 냄새는 미리 빼줘도 된다. (상어의 이동에 영향을 미치지 못하므로)
        for j in range(4):
            if smell_map[i][j] > 0:
                smell_map[i][j] -= 1

    mx = -1

    for i in range(4):                                              # 위에서 방향의 우선순위를 고려해서 sdy,sdx를 선정해서
        for j in range(4):                                          # 순서대로 보면 된다.
            for k in range(4):
                ans = go(i, j, k, s_y, s_x)
                if ans > mx:                                        # 기존보다 갱신될 때만 상어의 이동방향을 수정해 준다.
                    mx = ans
                    s_move = [i, j, k]

    for i in s_move:                                                # 방향이 결정났으니 이 방향으로 움직이면서 가자
        s_y = s_y + sdy[i]
        s_x = s_x + sdx[i]
        flag = False                                                # 이 좌표에서 물고기가 죽었나?
        for k in range(8):
            if new_fish_loc[s_y][s_x][k] != 0:
                new_fish_loc[s_y][s_x][k] = 0
                flag = True

        if flag:                                                    # 죽었으면 냄새 남겨야지
            smell_map[s_y][s_x] = 2

    for i in range(4):
        for j in range(4):
            for k in range(8):
                new_fish_loc[i][j][k] += tmp_fish_loc[i][j][k]      # 복제했던 물고기 원상복구

    fish_loc = new_fish_loc                                         # fish_loc를 new_fish_loc로 바꿔줌

tot_cnt = 0
for i in range(4):
    for j in range(4):
        for k in range(8):
            tot_cnt += fish_loc[i][j][k]

print(tot_cnt)
