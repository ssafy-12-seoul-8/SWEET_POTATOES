# 리팩토링 코드 (1차원으로 바꿔보고 유효한 최대 인덱스 관리, 줄일 수 있는 코드 줄이기)
# 문제의 순서대로 구현을 하되 달팽이의 번호별 인덱스를 미리 저장하여 사용하였다.
# 전처리 과정 : 각 좌표를 key로 가지고 달팽이 번호를 value로 가지는 딕셔너리 생성
# 그리고 상어가 마법을 부리면 칸을 0으로 바꾸고
# 당기는 건 뒤에서부터 스택에 담아서 해결하였다.
# 4개 이상 연속하면 없애는 건 앞에서부터 연속한 그룹의 숫자를 세고 다른 색으로 바뀔 때마다 없애고 마지막에 없애주는 로직을 사용하였디.
# 마지막 변화는 스택에 저장하고 차례대로 넣어주었다.

# 앞으로 가며 idx에 채워주는 함수 - 현재 좌표, 방향, 갈 길이, 현재 번호를 입력하면 가면서 idx에 저장해주고
# 마지막 좌표, 방향, 번호를 리턴한다.
# 참고로 idx는 좌표를 번호로 바꿔주는 딕셔너리다.
def go(y, x, d, l, k):
    for _ in range(l):
        y = y + tdy[d]
        x = x + tdx[d]
        idx[(y, x)] = k
        k += 1
        lst.append(arr[y][x])
    d = (d + 1) % 4
    return y, x, d, k


# 당겨주는 함수
# 뒤에서부터 보며 0이 아닌 것들을 담아주고 앞에서부터 채워준다.
def pull():
    global mx_idx
    stk = []
    for i in range(mx_idx, -1, -1):
        if lst[i] != 0:
            stk.append(lst[i])
            lst[i] = 0

    mx_idx = len(stk) - 1
    for i in range(len(stk)):
        lst[i] = stk.pop()


# 폭발하는 함수
# 0번에 수가 없으면 바로 그만두고 있다면 그 점을 시작으로 하여 연속된 그룹을 셈
def check():
    global score
    if lst[0] == 0:
        return

    flag = False
    i = 1
    cnt = 1
    num = lst[0]

    while i <= mx_idx:
        if lst[i] == 0:  # 이미 당겨왔기 때문에 그만봐도 된다.
            break

        if lst[i] == num:  # 같으면 그냥  cnt를 늘린다.
            cnt += 1
        else:
            if cnt >= 4:  # 만약에 번호가 다른데 지금까지 cnt>=4이면
                flag = True  # 점수 더하고
                score += lst[i - 1] * cnt
                for j in range(i - cnt, i):
                    lst[j] = 0
            cnt = 1
            num = lst[i]
        i += 1

    if cnt >= 4:  # 만약 while문을 나왔는데 cnt>=4라는 것은 아직 없애야 할 것이 남았다는 것
        flag = True
        score += lst[i - 1] * cnt
        for j in range(i - cnt, i):
            lst[j] = 0

    return flag


# 다 끝나고 (그룹의 개수. 번호)를 채워주는 것
# 스택에 넣고 마지막에 넣어주는 형식으로 하였다.
def change():
    global mx_idx
    if lst[0] == 0:
        return

    stk = []
    cnt = 1
    num = lst[0]

    for i in range(1, mx_idx + 1):
        if lst[i] == 0:
            break

        if lst[i] == num:
            cnt += 1
        else:
            stk.extend((cnt, num))
            cnt = 1
            num = lst[i]
        lst[i] = 0

    if cnt > 0:
        stk.extend((cnt, num))

    mx_idx = min(len(stk), N ** 2 - 1) - 1
    for i in range(mx_idx + 1):
        lst[i] = stk[i]

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

idx = {}

y = x = N // 2
d = 0

tdy = [0, 1, 0, -1]  # 달팽이 채우기용 방향 함수
tdx = [-1, 0, 1, 0]
dy = [-1, 1, 0, 0]  # 실제 로직에 쓰일 방향 함수
dx = [0, 0, -1, 1]
k = 0

lst = []
for l in range(1, N):
    for _ in range(2):
        y, x, d, k = go(y, x, d, l, k)

go(y, x, d, N - 1, k)

mx_idx = N ** 2 - 2
score = 0
for _ in range(M):

    d, s = map(int, input().split())
    d = d - 1

    # 상어가 마법 시전
    for k in range(1, s + 1):
        y = N // 2 + dy[d] * k
        x = N // 2 + dx[d] * k
        l = idx[(y, x)]
        lst[l] = 0

        # 당겨주고
    pull()

    # 연쇄 폭발과 당김을 반복
    while True:
        if not check():
            break
        pull()
    change()

print(score)
