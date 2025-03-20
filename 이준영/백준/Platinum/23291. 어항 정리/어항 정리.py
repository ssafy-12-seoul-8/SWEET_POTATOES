# 리팩토링 코드 (첫 어항 쌓기로 lst의 각 어항이 갈 좌표를 미리 저장해 놓고 시작
# 시작과 동시에 어항의 최대, 최소의 차이가 K개이하일 수 있으니 시작할 때 합니다.
# check를 할 떄 최소값 리스트를 같이 관리하는게 좋을 것 같아 check에서 조건을 만족하지 않으면 물고기가 적은 어항들에
# 물고기를 추가하고 False를 리턴하고, 조건을 만족하면 그냥 True를 리턴하였습니다.
# 첫번쨰 어항 쌓기의 경우 일단 한번 쌓고 지금 어항의 최대 높이를 y, 높이가 y인 것의 개수를 x, 높이가 1인 것의 개수를 z라 두고 while문
# 을 실행하였습니다. (자세한 건 함수에서)
# 물고기를 나누는 과정은 배열의 크기와 관계없이 일어나고 lst로 바꿀 수 있게 들어갈 때마다 그 배열의 가로와 세로 길이를 관리하였습니다.
# 두번째 어항 쌓기는 무조건 4* N//4배열이 되고 각 행을 채우는 lst의 인덱스를 구하는 게 쉬워서 직접 계산했습니다.

# myprint는 2차원 배열 출력 함수입니다.
# 이 문제에서는 출력할 배열의 크기가 유기적으로 변하기 때문에 항상 가로와 세로를 함수 내부에서 계산합니다.
def myprint(arr):
    for i in range(len(arr)):
        for j in range(len(arr[i])):
            print("%-3s" % arr[i][j], end="")
        print()
    print("-" * 50)


# 체크함수입니다.
# 순회를 하며 최소값 리스트를 같이 들고 다닙니다.
# 만약 조건을 만족한다면 True를 라턴하고
# 그렇지 않다면 lst의 최소값들에 1씩 추가하고 False를 리턴합니다.
def check():
    mx = -1
    mn = int(1e9)
    mn_lst = []
    for i in range(N):
        if mx < lst[i]:
            mx = lst[i]

        if mn == lst[i]:
            mn_lst.append(i)
        elif mn > lst[i]:
            mn = lst[i]
            mn_lst = [i]

    if mx - mn <= K:
        return True
    for i in mn_lst:
        lst[i] += 1
    return False

# 전처리 함수
# 리스트의 각 인덱스가 첫 어항 쌓기에서 어떤 배열을 만드는지 미리 저장해 놓은 것이다.
# 새로운 베열의 가로길이, 세로길이, 각 리스트의 원소가 어디로 가는지 저장한 배열을 리턴한다.
def make_changeset():
    arr = [[0] * (N - 2) for _ in range(2)]  # 일단 한번 쌓고 시작하려고 2*N-2배열을 잡았다.
    arr[1] = [i for i in range(3, N + 1)]
    arr[0][0], arr[0][1] = 2, 1  # 0행 0열, 0행 1열은 1번째, 0번째 수이다.

    y, x, z = 2, 2, N - 4  # 각각 arr에서 최대 높이, 최대 높이의 개수, 높이가 1인 어항의 개수 이다.

    while True:
        if y > z:  # 만약 최대높이가 높이가 1인 어항의 수보다 많으면 쌓지 못한다.
            break  # 끝

        t_arr = [[0] * z for _ in range(x + 1)]  # 아니면 쌓을 수 있는데 이 때 배열은 x+1*z가 된다. (그림으로 확인해볼것)
        t_arr[x] = arr[y - 1][x:]  # 마지막 행은 arr의 마지막행의 x인덱스부터 끝까지이다

        for i in range(x):
            for j in range(y):
                t_arr[i][j] = arr[y - 1 - j][i]  # 0~x-1열, 0~y-1행 부분은 arr의 0~x-1열, 0~y-1행까지를 시계방향으로 90도 회전한 것

        x, y, z = y, x + 1, z - y  # x,y,z를 갱신해준다.
        arr = t_arr  # 배열도 갱신해준다.

    idx = [0] * N
    for i in range(y):
        for j in range(x + z):
            if arr[i][j] != 0:
                idx[arr[i][j] - 1] = (i, j)

    return y, x + z, idx


# 첫번째 로직으로 어항을 쌓는 함수
# 1차원 리스트를 받아서 어항이 쌓인 상태인 2차원 배열을 반환한다.
def change1(lst):
    arr = [[0] * m for _ in range(n)]  # 앞에서 미리 계산한 결과를 이용하여
    for i in range(N):
        y, x = idx[i]                  # i번째 어항을 정해진 곳에 채워준다.
        arr[y][x] = lst[i]
    return arr


# 2차원 배열이 주어질 때 물고기를 분배하고 결과를 1차원으로 돌려주는 배열
# 처음 divide와 나중 divide를 모든 이차원 배열에 대해 일반화시켰다.
# 온도를 바꿀 때는 원본 배열을 복사하고 복사 배열의 값을 기준으로 원본 배열의 값을 바꾸었다. (각 칸에 대한 4방 탐색)
def divide(arr):
    n = len(arr)  # 가로 길이
    m = len(arr[0])  # 세로 길이
    tmp_arr = [row[:] for row in arr]  # 원래 온도를 저장할 배열

    for i in range(n):
        for j in range(m):

            if tmp_arr[i][j] == 0:  # 어항이 아니다.
                continue

            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]  # 어항인 곳과만 교류가 있어야 한다.

                if 0 <= ny < n and 0 <= nx < m and tmp_arr[ny][nx] > 0:
                    if tmp_arr[ny][nx] > tmp_arr[i][j]:
                        arr[i][j] += ((tmp_arr[ny][nx] - tmp_arr[i][j]) // 5)
                    else:
                        arr[i][j] -= ((tmp_arr[i][j] - tmp_arr[ny][nx]) // 5)

    t_lst = [0] * N  # 어항을 다시 펼칠거다.
    k = 0
    for j in range(m):  # 열 번호가 작은게 우선
        for i in range(n - 1, -1, -1):  # 행 번호가 큰게 우선
            if k == N:
                break
            if arr[i][j] > 0:  # 어항이면 추가해주자.
                t_lst[k] = arr[i][j]
                k += 1

        if k == N:
            break

    return t_lst


# 1*N배열을 4*(N//4)배열로 규칙에 맞게 바꾸는 함수이다.
# 잘 생각해보면 아래와 같은 규칙성을 찾을 수 있다.
def change2(lst):
    k = N // 4
    tmp_arr = [[0] * k for _ in range(4)]
    for j in range(k):  # j열 채우기
        tmp_arr[0][j] = lst[3 * k - 1 - j]  # 0행 ~ 3행까지
        tmp_arr[1][j] = lst[k + j]
        tmp_arr[2][j] = lst[k - 1 - j]
        tmp_arr[3][j] = lst[3 * k + j]

    return tmp_arr


N, K = map(int, input().split())
lst = list(map(int, input().split()))
t = 0
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
n, m, idx = make_changeset()

while True:
    if check():
        break

    t += 1
    arr = change1(lst)
    lst = divide(arr)
    arr = change2(lst)
    lst = divide(arr)

print(t)
