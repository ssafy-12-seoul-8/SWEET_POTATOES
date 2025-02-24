# 오셀로를 뒀을 때 고려할 방향은 8가지이다.
# 매번 문자열을 옮기기보다는 숫자가 더 익숙하여 숫자를 사용하고 마지막에 결과를 출력할 때만 문자로 바꾸었다.
# 빈칸 없이 출력해야 한다.
N = int(input())
dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]

arr = [[0] * 7 for _ in range(7)]           # 0은 빈칸, 1은 흑돌, 2는 백돌
arr[3][3] = 2
arr[4][4] = 2
arr[3][4] = 1
arr[4][3] = 1

for l in range(N):
    s_y, s_x = map(int, input().split())
    if l % 2 == 0:                          # 흑돌
        arr[s_y][s_x] = 1
    else:                                   # 백돌
        arr[s_y][s_x] = 2

    for k in range(8):
        flag = True
        y = s_y + dy[k]
        x = s_x + dx[k]
        lst = []                            # 지나온 길을 저장할 배열
        while 1 <= y < 7 and 1 <= x < 7:
            if arr[y][x] == 3 - arr[s_y][s_x]: # 다른 색을 만나면 계속 탐사
                lst.append((y, x))
                y += dy[k]
                x += dx[k]
            elif arr[y][x] == 0:                # 빈 곳을 만나면 무효
                flag = False
                break
            else:                               # 나랑 같은 색 만나면 스톱
                break

        if not (1 <= y < 7 and 1 <= x < 7):     # 범위를 벗어났다는 거는 같은 색을 만나지 못하고 계속 갔다는것이므로 무효
            flag = False

        if flag:                                # 유효한 방향이면
            for y, x in lst:                    # 이 안에 있는 것들의 색을 내것으로 바꿈
                arr[y][x] = arr[s_y][s_x]

b_count = 0
w_count = 0
for i in range(1, 7):
    for j in range(1, 7):
        if arr[i][j] == 0:
            arr[i][j] = "."
        elif arr[i][j] == 1:
            arr[i][j] = "B"
            b_count += 1
        else:
            arr[i][j] = "W"
            w_count += 1

        print(arr[i][j], end="")
    print()

if w_count < b_count:
    print("Black")
else:
    print("White")
