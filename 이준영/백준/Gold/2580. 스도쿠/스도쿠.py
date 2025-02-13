# 백트래킹으로 가능한 수를 하나씩 넣어봐서 끝까지 가면 ans에 저장한다.
# flag를 써서 한 번 찾으면 남은 모든 함수에서 리턴하게 하였다.
def btk(cur):
    global check

    if check:
        return

    if cur == 81:
        check = True

        for i in range(9):
            for j in range(9):
                ans[i][j] = arr[i][j]

        return

    y = cur // 9
    x = cur % 9

    if arr[y][x] != 0:
        btk(cur + 1)
    else:
        for i in range(1, 10):
            if row[y][i] == 0 and col[x][i] == 0 and square[(y // 3) * 3 + x // 3][i] == 0:
                arr[y][x] = i
                row[y][i] = col[x][i] = square[(y // 3) * 3 + x // 3][i] = 1
                btk(cur + 1)
                arr[y][x] = 0
                row[y][i] = col[x][i] = square[(y // 3) * 3 + x // 3][i] = 0


arr = [list(map(int, input().split())) for _ in range(9)]
row = [[0] * 10 for _ in range(9)]                                  # 행
col = [[0] * 10 for _ in range(9)]                                  # 열
square = [[0] * 10 for _ in range(9)]                               # 3*3으로 구역을 나눴을 떄 사각형

for i in range(9):
    for j in range(9):
        if arr[i][j] != 0:
            row[i][arr[i][j]] = 1
            col[j][arr[i][j]] = 1
            square[(i // 3) * 3 + j // 3][arr[i][j]] = 1

check = False
ans = [[0] * 9 for _ in range(9)]
btk(0)

for i in range(9):
    print(*ans[i])
