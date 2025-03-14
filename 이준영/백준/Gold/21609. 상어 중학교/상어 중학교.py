# 리팩토링 코드 (회전을 리스트 컴프리헨션으로, 불필요한 변수 제거)
# 대신에 기능별로 test.py에서 따로 검증해본게 도움이 된 것 같습니다.
# 제 코드에서 -2: 빈칸, -1: 검정, 0: 무지개 1이상: 노말 블록

# 중력이 작용하여 배열이 떨어지는 과정
# -1을 만나기전 까지 0이상인 블록들을 리스트에 저장함
# -1을 만나면 그 위로 리스트에 있는 블록들을 올려 놓는다. (가장 처음 넣은게 가장 위에 있게)
# 마지막까지 왔는데 리스트가 있다면 땅 위로 블록들을 올려 놓는다.

def drop(arr):
    b = [[-2] * N for _ in range(N)]  # 임시 배열 잡았는데 빈 칸을 -2로 하기에 기본값을 -2로 하였습니다.

    for j in range(N):
        stk = []
        for i in range(N):

            if arr[i][j] >= 0:  # 0이상이면 저장해야 할 블록이라서 저장
                stk.append(arr[i][j])

            elif arr[i][j] == -2:  # -2면 넘어감 (빈칸이라서)
                continue

            else:  # 검정 블록이면
                l = len(stk)

                for k in range(l):
                    b[i - l + k][j] = stk[k]  # 지금까지 모은 블록들을 위에 올려 놓고
                b[i][j] = -1  # 검은 블록도 임시 배열에 채우고
                stk = []  # 리스트 비우자

        if stk:  # 끝까지 왔는데 스택이 비어있다면
            l = len(stk)
            for k in range(l):  # 또 순서대로 비우자
                b[N - l + k][j] = stk[k]

    return b


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]  # -2: 빈칸, -1: 검정, 0: 무지개 1이상: 노말 블록

score = 0

while True:

    visited = [[0] * N for _ in range(N)]
    mx_score = -1  # 최대 점수
    mx_r = -1  # 그 때 최대 무지개 블록 수
    m_lst = []  # 지금까지 본 블록그룹 중 가장 우선순위가 높은 블록그룹의 블록 좌표 리스트

    for i in range(N):
        for j in range(N):  # 열우선, 행우선

            if arr[i][j] >= 1 and visited[i][j] == 0:  # 노말블록이고 아직 보지 않았다면
                lst = [(i, j)]  # 이 블록그룹에 속한 블록들
                idx = 0  # 지금 볼 인덱스
                visited[i][j] = 1  # 방문 처리
                cnt = 0  # 무지개 블록 수

                # 내가 bfs한 결과를 써야 할 때 이런 식으로 하는 경우가 좀 있습니다.
                while idx < len(lst):  # idx==len(lst)라는 건 lst의 원소를 다 봤다는 것

                    y, x = lst[idx]  # 이번에 내가 볼 좌표

                    for k in range(4):

                        ny = y + dy[k]
                        nx = x + dx[k]
                        # 범위 안에 있고 방문하지 않았고 레인보우 블록이거나 처음 블록과 같다면
                        if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and (
                                arr[ny][nx] == 0 or arr[ny][nx] == arr[i][j]):
                            visited[ny][nx] = 1  # 방문처리
                            lst.append((ny, nx))  # 블록그룹 리스트에 저장
                    idx += 1  # 다음 볼 거 보자

                for y, x in lst:

                    if arr[y][x] == 0:  # 무지개 블록이면
                        cnt += 1  # 무지개 블록 수 더하고
                        visited[y][x] = 0  # 방문처리를 풀어준다 (무지개 블록은 여러 블록 그룹에 속할 수 있다.)

                l = len(lst)  # 블록그룹의 수

                if l >= 2:  # 2이상이어야 유효

                    if l > mx_score:  # 기존 최대보다 크면 바로 바꿔
                        mx_score = l
                        mx_r = cnt
                        m_lst = lst

                    elif l == mx_score:     # 같다면
                        if cnt >= mx_r:     # 무지개 블록이 크거나 같을 때 바꾸자.
                            mx_score = l    # 이러면 행우선, 열우선이 자동으로 되는데 보는 순서가 행이 작은 순서대로, 열이 작은 순서대로
                            mx_r = cnt      # 이기 때문이다.
                            m_lst = lst     # 만약 기준 블록의 행번호가 작고, 열번호가 작은 게 각각 우선순위였다면 cnt>mx_r을 적으면 된다.

    if mx_score == -1:  # 블록 그룹이 없으니 그만
        break

    score += mx_score ** 2  # 있으면 점수 더하자

    for y, x in m_lst:  # 그리고 블록 그룹에 있는 것들 다 빈칸 처리
        arr[y][x] = -2

    arr = drop(arr)  # 떨어뜨리고

    arr = list(zip(*[row[::-1] for row in arr])) # 회전하고

    arr = drop(arr)  # 떨어뜨린다.

print(score)
