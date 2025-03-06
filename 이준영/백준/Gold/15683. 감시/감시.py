# 문제에서 감시카메라의 개수가 최대 8개이고 맵의 크기가 64까지 되므로 감시카메라의 방향을 일일이 설정하고 그떄 그때 사각지대를 계산해도
# 되겠다고 판단하였다.
# 이를 위해 감시카메라의 좌표들을 받아 놓고 각 감시카메라의 방향을 설정하는 방법으로 코드를 짰다.

def btk(cur):                                                               # idx배열에 방향을 채운다.
    if cur == l:                                                            # 다 채우면 검사
        check()
        return
    for i in range(C[cur][3]):                                              # 여기서 복구를 안해도 되는건
        idx[cur] = i                                                        # 어차피 덮어 씌워지기 떄문이다.
        btk(cur + 1)


def check():                                                                # CCTV의 방향이 설정되고 사각지대의 개수를 세자
    global mn
    visited = [[0] * M for _ in range(N)]                                   # 단순히 CCTV에 의해 보인 곳만 1로 표시
    for i in range(l):
        num, s_y, s_x, _ = C[i]                                             # CCTV번호, y좌표, x좌표
        d = idx[i]                                                          # CCTV의 방향 (0~3)
        for k in dct[num]:                                                  # k를 d만큼 돌려야 한다.
            tmp = (k + d) % 4                                               # 돌린 방향에 대해 CCTV가 보는 곳을 탐색
            y = s_y
            x = s_x
            while True:
                ny = y + dy[tmp]
                nx = x + dx[tmp]
                if 0 <= ny < N and 0 <= nx < M:                             # 범위를 벗어나지 않았을 떄
                    if arr[ny][nx] != 6:                                    # 벽을 만나지 않으면 방문표시하고 계속
                        visited[ny][nx] = 1
                        y = ny
                        x = nx
                    else:                                                   # 아니면 그만가자
                        break
                else:                                                       # 범위 벗어나면 그만하자
                    break
    cnt = 0
    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0 and arr[i][j] == 0:                       # 방문배열은 벽이나 CCTV를 고려하지 않으므로
                cnt += 1                                                    # 원본 배열과 조건을 합쳐 cnt를 세야 한다.

    mn = min(mn, cnt)                                                       # 최소값 갱신


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dy = [-1, 0, 1, 0]                                                          # 상, 우, 하, 좌
dx = [0, 1, 0, -1]

dct = [[0],
       [1],
       [1, 3],
       [0, 1],
       [0, 1, 2],
       [0, 1, 2, 3]]

pos = [0, 4, 2, 4, 4, 1]
C = []                                                                      # CCTV의 정보를 담을 배열

for i in range(N):
    for j in range(M):
        if 0 < arr[i][j] < 6:                                               # CCTV면
            C.append((arr[i][j], i, j, pos[arr[i][j]]))

l = len(C)
idx = [0] * l                                                               # 각 CCTV의 방향을 저장
mn = 65
btk(0)
print(mn)
