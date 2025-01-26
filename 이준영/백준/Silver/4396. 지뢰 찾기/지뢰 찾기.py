dy = [0, -1, -1, -1, 0, 1, 1, 1]        # 지뢰가 몇개 있는지 세기 위한 방향 설정
dx = [-1, -1, 0, 1, 1, 1, 0, -1]        

n = int(input())

arr = [[0] * n for _ in range(n)]
click = [[0] * n for _ in range(n)]
result = [["."] * n for _ in range(n)]  # 일단 "."으로 초기화하고 바꿀 부분만 바꾸도록 했습니다.

for i in range(n):
    arr[i] = list(input())
for i in range(n):
    click[i] = list(input())

bomb_check = False  # 지뢰를 밟았는지 체크하는 변수

for i in range(n):
    for j in range(n):
        if click[i][j] == "x" and arr[i][j] == "*":
            bomb_check = True
            break
    if bomb_check:
        break
for i in range(n):
    for j in range(n):
        if click[i][j] == "x":
            if arr[i][j] == ".":                 # 지뢰 안 밟으면 근처 지뢰 갯수 델타 탐색으로 구해서 출력
                count = 0
                for k in range(8):
                    ny = i + dy[k]
                    nx = j + dx[k]
                    if 0 <= ny < n and 0 <= nx < n and arr[ny][nx] == "*":
                        count += 1
                result[i][j] = count
            if arr[i][j] == "*":                 # 지뢰 밟으면 바로 * 표시
                result[i][j] = "*"
        else:
            if arr[i][j] == "*" and bomb_check:  # 안 밟았어도 다른 지뢰를 밟으면 *로 출력
                result[i][j] = "*"

for i in range(n):
    for j in range(n):
        print(result[i][j], end="")
    print()
