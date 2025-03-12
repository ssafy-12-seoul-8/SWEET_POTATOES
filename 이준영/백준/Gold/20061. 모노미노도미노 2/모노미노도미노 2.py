# 문제의 조건이 너무 복잡한 거 같아서 최대한 실수가 안나게 구현한 것 같습니다.
# 10*10 배열을 그냥 잡고 풀었습니다. (board[4:][4:]는 사용하지 않았습니다.)
# 반복되는 부분이 많은데 리팩토링 때 하나로 묶겠습니다.
N = int(input())
score = 0   
board = [[0] * 10 for _ in range(10)]                           # 타일의 유무 판단
shape = [[], [(0, 0)], [(0, 0), (0, 1)], [(0, 0), (1, 0)]]      # t = 1,2,3일 때 타일의 좌표 (0,0)이 y,x좌표라고 생각하면 됨 
for _ in range(N):
    t, y, x = map(int, input().split())
    start = []
    for dy, dx in shape[t]:
        start.append((y + dy, x + dx))                          # 타일의 시작 좌표들을 넣자

    d = 1                                                       # 얼마만큼 아래로 가는 지 (정확히는 그런 길이+1)
    # 아래로 넣는거
    while True:
        flag = True
        for y, x in start:
            if y + d >= 10:                                     # 범위를 벗어나거나
                flag = False
                break
            elif board[y + d][x] == 1:                          # 이미 타일이 있다면 d가 늘어날 수 없음
                flag = False
                break
        if not flag:
            break
        d += 1                                                  # 둘다 해당하지 않는다면 d증가
                                                                # 결국 d는 타일이 없을 때까지 혹은 범위 넘을떄까지 증가하니까
    for y, x in start:
        board[y + d - 1][x] = 1                                 # 각 좌표를 d - 1만큼 움직여서 넣으면 된다.
    # 오른쪽에 넣기
    d = 1                                                       # 오른쪽으로 넘기는 것도 동일
    while True:                                                 # 위와 로직은 동일
        flag = True
        for y, x in start:
            if x + d >= 10:
                flag = False
                break
            elif board[y][x + d] == 1:
                flag = False
                break
        if not flag:
            break
        d += 1

    for y, x in start:
        board[y][x + d - 1] = 1

    # 아래 테트리스
    cnt = 0                                                     # 테트리스가 몇칸 생겼는지
    start = 0                                                   # 테트리스가 생긴 가장 큰 좌표
    for i in range(6, 10):                                      # 테트리스가 있는지 보자
        flag = True
        for j in range(4):
            if board[i][j] == 0:                                # 이 줄엔 없다.
                flag = False
                break
        if flag:                                                # 있다면
            start = i                                           # start 갱신
            cnt += 1                                            # cnt증가
            score += 1                                          # 1점 추가 (cnt에를 나중에 더해도 됨)
            for j in range(4):                                  # 다 0으로 바꾸자
                board[i][j] = 0
    # 테트리스 후 이동
    if cnt > 0:                                                 # 테트리스가 일어났다면 이동을 해야겠지
        for j in range(4):
            for i in range(9, 3, -1):
                if board[i][j] == 1 and i < start:              # 근데 start보다 작은 애들만 이동해야 한다. start보다 큰 애들은
                    board[i][j] = 0                             # 테트리스가 있어도 자리 유지하므로
                    board[i + cnt][j] = 1
    # 연한 곳 체크
    cnt = 0                                                     # 밀어야 하는 줄이 몇개인지 세자
    for i in (4, 5):
        for j in range(4):
            if board[i][j] == 1:                                # 1이 하나라도 있으면 밀어야 된다.
                cnt += 1                                        # 바로 break해야지 한 줄에 여러 개가 있어도 한 줄만 민다.
                break
    # 연한 곳 있는 만큼 이동
    if cnt > 0:                                                 # 밀림이 있다면
        for j in range(4):                                      
            for i in range(9, 3, -1):
                if board[i][j] == 1:
                    board[i][j] = 0
                    if i + cnt <= 9:                            # 미는데 없어질 수도 있음 (범위 벗어나면 없어진거)
                        board[i + cnt][j] = 1
    # 오른쪽 테트리스                                              # 아래로 미는 것과 동일
    cnt = 0
    start = 0
    for j in range(6, 10):
        flag = True
        for i in range(4):
            if board[i][j] == 0:
                flag = False
                break
        if flag:
            cnt += 1
            score += 1
            start = j
            for i in range(4):
                board[i][j] = 0
    # 오른쪽 밀기
    if cnt > 0:
        for i in range(4):
            for j in range(9, 3, -1):
                if board[i][j] == 1 and j < start:
                    board[i][j] = 0
                    board[i][j + cnt] = 1
    # 오른쪽 연한 부분
    cnt = 0
    for j in (4, 5):
        for i in range(4):
            if board[i][j] == 1:
                cnt += 1
                break

    if cnt > 0:
        for i in range(4):
            for j in range(9, 3, -1):
                if board[i][j] == 1:
                    board[i][j] = 0
                    if j + cnt <= 9:
                        board[i][j + cnt] = 1

    # for i in range(10):                                       # 디버깅용 코드
    #     print(*board[i])
    # print("-" * 50)
ans2 = sum(map(sum, board))                                     # 어차피 100번 연산이나 64번 연산이나 비슷할 듯

print(score)
print(ans2)
