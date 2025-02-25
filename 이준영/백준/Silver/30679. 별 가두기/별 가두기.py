# 각 열에서 별을 출발시키며 가둬지는지 아닌지를 판단한다.
# 방문배열을 잡되 나가는 방향까지 고려하였다. 이 때 방문배열에 방문 표시를 몇번째 열에서 나갔는지로 표시한다 (1 ~ N)
# 만약 이미 그 방향으로 나간적이 없다면 계속해야 하고
# 그 방향으로 나간적이 있는데 만약 현재 열에서 나간 것이거나 갇혀진 곳에서 나간 적이 있는거라면 갇힌거다.
# 하지만 갇히지 않았던 곳에서의 시행이었다면 가두지 못한 것이다.
# 밖으로 나가면 나간거다.
import sys

input = sys.stdin.readline
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]                                              # 오른쪽, 아래, 왼쪽, 위 (시작은 오른쪽 발사)

ans = []                                                        # 가둬진 열번호 리스트   
st = set([])                                                    # 가둬진 열번호 집합

visited = [[[0] * 4 for _ in range(M)] for _ in range(N)]       # arr[y][x][d] y,x에서 d방향으로 나간적 있는지 (나간적이 있다면 몇번 열에서)
                                                                # 나갔을 때 나간건지
for i in range(N):

    d = 0

    if visited[i][0][d] != 0:                                   # 만약 시작점부터 이전에 오른쪽으로 방향으로 지난 적이 있다면
        if visited[i][0][d] in st:                              # 그 때 갇혀지면 이번에도 갇힐것이다.
            ans.append(i+1)
            st.add(i+1)
        continue                                                # 아니면 지금도 못 가둔다.

    visited[i][0][d] = i + 1                                    # d방향으로 방문처리
    y = i
    x = 0
    flag = True
    while True:
        y, x = y + dy[d] * arr[y][x], x + dx[d] * arr[y][x]

        if not (0 <= y < N and 0 <= x < M):                     # 벗어나면 가두기 실패
            flag = False
            break
        d = (d + 1) % 4                                         # 방향 전환

        if visited[y][x][d] == i + 1:                           # (이번 열 발사에서)이전에 이 방향으로 발사한 적이 있다면 성공
            break

        if visited[y][x][d] == 0:                               # 발사한 적 없다면 방문처리만
            visited[y][x][d] = i + 1

        else:                                                   # 이 방향으로 이 칸에서 발사한 적이 있다면
            if visited[y][x][d] in st:                          # 예전에 가두면 이번에도 가둠
                break
            else:                                               # 예전에 못가뒀다면 지금도 못가둔다.
                flag = False
                break

    if flag:                                                    # 가두기 성공했으니 ans에 더한다.
        ans.append(i + 1)
        st.add(i + 1)

print(len(ans))
for i in ans:
    print(i, end=" ")
