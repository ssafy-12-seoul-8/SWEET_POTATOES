# 리팩토링 코드(함수화, 상어 이동 수정, 물고기 수 배열 추가)
# 냄새맵은 하나의 배열로 임시배열을 쓰지 않고 관리하였고, 물고기의 번호가 중요하지는 않기에 각 좌표와 방향 별 물고기 수를 관리하였다.
# 이 생각을 한 것은 복제를 하다보면 물고기가 엄청 많아질 수 있다고 생각해서이다.
# 상어도 위치만 관리해주었다.
# arr 배열은 원래 상어와 물고기 위치를 위해 놔두려고 했는데 실제 코드에서 쓰이지 않았다.

# 상어의 이동들 중 가장 먹이를 많이 먹는 좌표 리스트를 s_move에 저장함
# 현재 상어좌표, 지나온 길
def btk(y, x, lst):
    global mx

    if len(lst) == 3:                       # 3칸 갔다.
        cnt = 0
        st = set(lst)

        for i, j in st:
            cnt += new_fish_cnt[i][j]

        if cnt > mx:                        # 원래보다 많으면 s_move를 갱신해준다.
            mx = cnt
            for i in range(3):
                s_move[i] = lst[i][:]
        return

    for k in range(4):                      # 여기서 k순서대로 btk를 하고 위에서 cnt>mx일 때만 갱신해주기 떄문에 가장 많은 먹이를 먹는
        ny = y + sdy[k]                     # 좌표순서중 우선 순위가 가장 높은 것이 s_move에 담긴다.
        nx = x + sdx[k]

        if 0 <= ny < 4 and 0 <= nx < 4:
            lst.append((ny, nx))
            btk(ny, nx, lst)
            lst.pop()


M, S = map(int, input().split())

fish_cnt = [[0] * 4 for _ in range(4)]  # 좌표별 물고기 수
fish_loc = [[[0] * 8 for _ in range(4)] for _ in range(4)]  # (y,x)에서 d방향 물고기가 몇개 있는지
smell_map = [[0] * 4 for _ in range(4)]  # 냄새 배열 (남은시간표시)

dy = [0, -1, -1, -1, 0, 1, 1, 1]  # 물고기의 방향
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
sdy = [-1, 0, 1, 0]  # 상어의 방향 (우선순위 고려)
sdx = [0, -1, 0, 1]

for _ in range(M):
    y, x, c = map(int, input().split())
    fish_loc[y - 1][x - 1][c - 1] += 1  # 그 좌표의 그 방향에 +1
    fish_cnt[y - 1][x - 1] += 1

s_y, s_x = map(int, input().split())
s_y -= 1
s_x -= 1

for _ in range(S):
    tmp_fish_cnt = [row[:] for row in fish_cnt]
    new_fish_cnt = [[0] * 4 for _ in range(4)]  # 바뀐 물고기 수
    tmp_fish_loc = [[lst[:] for lst in row] for row in fish_loc]  # 현재 물고기의 상태(복제를 위한)
    new_fish_loc = [[[0] * 8 for _ in range(4)] for _ in range(4)]  # 바뀐 물고기 상태를 저장할 배열

    for i in range(4):
        for j in range(4):
            for l in range(8):

                if fish_loc[i][j][l] != 0:  # 물고기가 있다면 시행하자
                    cnt = fish_loc[i][j][l]  # 옮길 물고기 수

                    for k in range(8):
                        tmp = (l - k) % 8  # 문제의 증가하는 방향이 아닌 반대로 가야 됨!
                        ny = i + dy[tmp]
                        nx = j + dx[tmp]
                        # 격자를 벗어나지 않고 냄새와 상어가 없다면
                        if 0 <= ny < 4 and 0 <= nx < 4 and smell_map[ny][nx] == 0 and (ny, nx) != (s_y, s_x):
                            new_fish_loc[ny][nx][tmp] += cnt  # 이 방향으로 가자
                            new_fish_cnt[ny][nx] += cnt
                            break

                    else:  # 아니면 이동하지 못하니 기존 좌표와 방향에 더해주자
                        new_fish_loc[i][j][l] += cnt
                        new_fish_cnt[i][j] += cnt

    for i in range(4):  # 이제 냄새는 미리 빼줘도 된다. (상어의 이동에 영향을 미치지 못하므로)
        for j in range(4):
            if smell_map[i][j] > 0:
                smell_map[i][j] -= 1

    mx = -1

    s_move = [0] * 3

    btk(s_y, s_x, [])
    for y, x in s_move:  # 방향이 결정났으니 이 방향으로 움직이면서 가자
        flag = False  # 이 좌표에서 물고기가 죽었나?
        for k in range(8):
            if new_fish_loc[y][x][k] != 0:
                new_fish_cnt[y][x] -= new_fish_loc[y][x][k]
                new_fish_loc[y][x][k] = 0
                flag = True

        if flag:  # 죽었으면 냄새 남겨야지
            smell_map[y][x] = 2
    s_y, s_x = s_move[2]

    # 복제했던 물고기 원상복구
    for i in range(4):
        for j in range(4):
            new_fish_cnt[i][j] += tmp_fish_cnt[i][j]
            for k in range(8):
                new_fish_loc[i][j][k] += tmp_fish_loc[i][j][k]

    fish_loc = new_fish_loc  # fish_loc를 new_fish_loc로 바꿔줌
    fish_cnt = new_fish_cnt

tot_cnt = sum(map(sum, fish_cnt))

print(tot_cnt)
