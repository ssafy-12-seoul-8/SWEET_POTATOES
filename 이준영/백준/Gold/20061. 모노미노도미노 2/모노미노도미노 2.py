N = int(input())
score = 0
board = [[0] * 10 for _ in range(10)]
shape = [[], [(0, 0)], [(0, 0), (0, 1)], [(0, 0), (1, 0)]]
for _ in range(N):
    t, y, x = map(int, input().split())
    start = []
    start = []
    for dy, dx in shape[t]:
        start.append((y + dy, x + dx))

    d = 1
    # 아래로 넣는거
    while True:
        flag = True
        for y, x in start:
            if y + d >= 10:
                flag = False
                break
            elif board[y + d][x] == 1:
                flag = False
                break
        if not flag:
            break
        d += 1

    for y, x in start:
        board[y + d - 1][x] = 1
    # 오른쪽에 넣기
    d = 1
    while True:
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
    cnt = 0
    start = 0
    for i in range(6, 10):
        flag = True
        for j in range(4):
            if board[i][j] == 0:
                flag = False
                break
        if flag:
            start = i
            cnt += 1
            score += 1
            for j in range(4):
                board[i][j] = 0
    # 테트리스 후 이동
    if cnt > 0:
        for j in range(4):
            for i in range(9, 3, -1):
                if board[i][j] == 1 and i < start:
                    board[i][j] = 0
                    board[i + cnt][j] = 1
    # 연한 곳 체크
    cnt = 0
    for i in (4, 5):
        for j in range(4):
            if board[i][j] == 1:
                cnt += 1
                break
    # 연한 곳 있는 만큼 이동
    if cnt > 0:
        for j in range(4):
            for i in range(9, 3, -1):
                if board[i][j] == 1:
                    board[i][j] = 0
                    if i + cnt <= 9:
                        board[i + cnt][j] = 1
    # 오른쪽 테트리스
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

    # for i in range(10):
    #     print(*board[i])
    # print("-" * 50)
ans2 = sum(map(sum, board))

print(score)
print(ans2)
