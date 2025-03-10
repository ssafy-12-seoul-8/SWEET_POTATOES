# 결국엔 그냥 백트래킹으로 풀었습니다.
# index나 조건문 범위를 잘못적어서 많이 틀린 것 같습니다..
import sys

input = sys.stdin.readline

    
def btk(cur, cnt, m_cnt):                               # 현재 몇번째 칸, 사다리개수, 최대 허용 사다리 수
    global ans, f_check                                 # 답, 모든 경우의 수를 셌는지 체크하기 위한 디버깅 변수
    if ans != 4:
        return

    y = cur // (N - 1)                          
    x = cur % (N - 1)

    if cnt == m_cnt:                                    # 사다리를 다 썻다면 검사하자
        f_check += 1
        t_arr = [0] * (N + 1)
        for i in range(1, N + 1):                       
            t_arr[i] = start[i]
        if y <= H - 1:
            for t_x in vt[y]:   
                if t_x >= x:                            # 생각해보니 등호를 붙여야 하는걸 깨달아서.. 그 줄에서 사다리 반영
                    swap(t_arr, t_x + 1)
        for k in range(y + 1, H):                       # 다음 줄부터 사다리 반영
            for t_x in vt[k]:
                swap(t_arr, t_x + 1)

        for i in range(1, N + 1):
            if t_arr[i] != i:                           # 만약 답과 다르다면 실패
                return
        ans = m_cnt                                     # 성공
        return

    if cur == (N - 1) * H:                              # 끝까지 갔는데 못 채움
        return  

    if check[y][x] != 0:                                # 여기를 채울 수 없다면
        if check[y][x] == 1:                            # 1이라면 스왑하고 넘어가자
            swap(start, x + 1)
            btk(cur + 1, cnt, m_cnt)
            swap(start, x + 1)
        else:
            btk(cur + 1, cnt, m_cnt)
        return

    check[y][x] = 1                                     # 일단 채워보자
    if x + 1 < N - 1:                                   # 다음 상태를 바꿔야 한다면 바꾸고 백트래킹
        origin = check[y][x + 1]
        check[y][x + 1] = -1
        swap(start, x + 1)
        btk(cur + 1, cnt + 1, m_cnt)
        check[y][x + 1] = origin
        swap(start, x + 1)
    else:                                               # 아니면 스왑만 하고 백트래킹
        swap(start, x + 1)
        btk(cur + 1, cnt + 1, m_cnt)
        swap(start, x + 1)
    check[y][x] = 0                                     # 이 사다리를 안 채울 경우
    btk(cur + 1, cnt, m_cnt)                            # 그냥 다음으로 넘어간다


def swap(arr, a):                                       # a와 a+1을 바꿈
    arr[a], arr[a + 1] = arr[a + 1], arr[a]


N, M, H = map(int, input().split())

vt = [[] for _ in range(H)]
check = [[0] * (N - 1) for _ in range(H)]

for _ in range(M):
    a, b = map(int, input().split())                    # check용과 기존의 사다리 배열을 따로 관리한다.
    vt[a - 1].append(b - 1)                             # vt는 각 행별 사다리의 위치 배열

    check[a - 1][b - 1] = 1                             # 0은 사다리를 놓을 수 있는 칸, 1은 사다리, -1은 사다리 인접 칸
    for tmp in (b - 2, b):
        if 0 <= tmp < N - 1:
            check[a - 1][tmp] = -1

ans = 0
f_check = 0
start = [i for i in range(N + 1)]
for y in range(H):
    for x in vt[y]:
        swap(start, x + 1)

for i in range(1, N + 1):                               # 한 칸도 안 놓아도 되나 판단
    if start[i] != i:
        ans = 4
        break
                                                        # 만약 위에서 break가 안일어났다면 ans=0이므로 아래 for문에서 break하고 
for i in range(1, 4):                                   # 출력된
    if ans != 4:
        break
    start = [i for i in range(N + 1)]                   # 혹시 몰라서 start 갱신했지만 안해도 백트래킹에서 돌아옴
    btk(0, 0, i)                                        

if ans == 4:
    print(-1)
else:
    print(ans)
