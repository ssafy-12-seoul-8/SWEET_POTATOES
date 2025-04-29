# lst는 내가 정할 시드 문자열
# 어떤 문자를 넣었을 때 기존 score와 동일하면 통과
def btk(lst):
    global flag, ans
    if flag:                # 답을 찾았다면 그만
        return

    l = len(lst)
    if l == 9:              # lst의 길이가 9라는 건 lst가 조건을 만족한다는 뜻 (word를 sort한 후 앞에서부터 했으므로 사전순 가장 앞이 보장됨)
        flag = True
        ans = lst[:]        # 답을 복사
        return

    for i in range(9):
        if visited[i] == 0: # 방문하지 않았고
            if check(i) == score[l]:    # i번째를 고름으로 인해 얻은 점수가 얻어야 할 점수가 같을 떄 이 길을 선택한다.
                visited[i] = 1          # 방문처리하고
                lst.append(word[i])     # lst에 추가하고
                btk(lst)                # 백트래킹하고
                lst.pop()               # 원복하자
                visited[i] = 0
            roll_back(i)                # check 함수내에 col,row, diag의 상태를 변화시키는 코드가 포함되어 있으므로 항상 롤백해야 한다.

# i번째 수를 넣었을 때 row,col,diag의 변화
# 얻은 점수를 리턴
def check(i):
    cur = word[i]
    y, x = loc[cur]
    cnt = 0
    row[y] += 1                         # y행에서 택한 수의 개수 증가
    if row[y] == 3:                     # 빙고완성시 1점 획득
        cnt += 1

    col[x] += 1                         # 열에 대해서도 똑같이 하고
    if col[x] == 3:
        cnt += 1

    if y + x == 2:                      # 양 대각선에 대해서도 똑같이 해준다.
        diag[0] += 1
        if diag[0] == 3:
            cnt += 1

    if y == x:
        diag[1] += 1
        if diag[1] == 3:
            cnt += 1

    return cnt

# i번째 문자를 뺏을 때 col,row,diag를 원상 복귀한다.
def roll_back(i):
    cur = word[i]
    y, x = loc[cur]
    row[y] -= 1
    col[x] -= 1
    if y + x == 2:
        diag[0] -= 1
    if y == x:
        diag[1] -= 1


T = int(input())
for _ in range(T):
    word = list(input())                            # 처음 시드 문자열
    loc = {}                                        # 문자: (y,x) 딕셔너리
    board = [list(input()) for _ in range(3)]       # board판

    for i in range(3):
        for j in range(3):
            loc[board[i][j]] = (i, j)               # 일단 딕셔너리 채워준다.

    score = [0] * 9
    row = [0] * 3
    col = [0] * 3
    diag = [0] * 2

    for i in range(9):
        score[i] = check(i)                         # 초기 시드 문자열로 인한 점수 배열 생성

    word.sort()
    visited = [0] * 9
    row = [0] * 3
    col = [0] * 3
    diag = [0] * 2
    ans = []
    flag = False
    btk([])
    print(*score, sep="", end=" ")
    print(*ans, sep="")