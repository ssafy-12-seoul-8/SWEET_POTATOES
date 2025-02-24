# 문제를 봤을 때 가로로 긁었는가와 세로로 긁었는가가 중요하여 이 상태를 저장해 놓으면 좋겠다고 생각하여 비트마스킹으로 관리하자고 생각했습니다.
# 그리고 입력에 따른 가는 방향이 정해져 있어 이를 딕셔너리로 관리하였고
# 세로로 그은건지 가로로 그은건지를 판별하기 위한 딕셔너리를 하나 더 만들었습니다.
N = int(input())
lst = list(input())
arr = [[0] * N for _ in range(N)]  # 가로는 1, 세로는 2, 가로+세로는 3
d = {"D": (1, 0), "U": (-1, 0), "L": (0, -1), "R": (0, 1)}
change = {"D": 2, "U": 2, "L": 1, "R": 1}

y = 0
x = 0
for s in lst:
    dy, dx = d[s]
    ny = y + dy
    nx = x + dx
    if 0 <= ny < N and 0 <= nx < N:                 # ny,nx를 잡아야 갈지 말지를 결정하고 y,x를 바꿀지를 결정하기에 이렇게 하였습니다.
        arr[y][x] = (arr[y][x] | change[s])
        y = ny
        x = nx
        arr[y][x] = (arr[y][x] | change[s])

for i in range(N):
    for j in range(N):
        if arr[i][j] == 0:
            arr[i][j] = "."
        elif arr[i][j] == 1:
            arr[i][j] = "-"
        elif arr[i][j] == 2:
            arr[i][j] = "|"
        else:
            arr[i][j] = "+"

        print(arr[i][j], end="")
    print()
