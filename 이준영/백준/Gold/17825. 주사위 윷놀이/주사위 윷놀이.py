# 오랜만에 초기 배열 설정을 길게 한 거 같다. (반복할 수 있는 부분도 손으로 다 썼다).
# 처음 가는 애는 그냥 1을 가게 해도 되지만... 그냥 했다.
# 이동을 함수화시키면 더 좋을 듯
def btk(cur, sm):                           
    global mx
    if cur == 10:                                       # 이동 끝나면 최대값 갱신
        mx = max(mx, sm)
        return
    for i in range(4):
        if lst[i] == 32:                                # 도착 지점에 있는 걸 움직이지 말자. (10번을 던질 떄 모든 말이 도착지점에)
            continue                                    # 오는건 불가능한게 한 말이 들어오려면 최소 3번 필요함
        else:
            start = tmp = lst[i]                        # 시작 좌표
            if tmp in blue:                             # 파란 화살표 스타트면
                tmp = blue[tmp]                         # 일단 가고
                for j in range(num[cur] - 1):
                    tmp = red[tmp]                      # 이 때 파란 화살표 좌표에서 5번안에 도착지점 못가서 확인 안해도 됨
                if arr[tmp] != 0:                       # 이미 말 있으면 이 말 못 움직여
                    continue
                lst[i] = tmp                            # i번 말 좌표 옮기고
                arr[start] -= 1                         # start에 있는 말의 개수 빼고
                arr[tmp] += 1                           # tmp에 추가
                btk(cur + 1, sm + score[tmp])           # 백트래킹하고
                lst[i] = start                          # 원상 복구
                arr[tmp] -= 1
                arr[start] += 1
            else:
                for j in range(num[cur]):               # 파란색 위치에 안서있다면
                    if tmp == 32:                       # 32에 도달하는 즉시 멈춰야 함
                        break
                    tmp = red[tmp]                      # 아니면 빨간 화살표 따라가자
                if tmp != 32 and arr[tmp] != 0:         # 만약 도착 지점이 아닌데 다른 말이 있다면 이 말 못움직임
                    continue
                lst[i] = tmp                            # 위와 동일
                arr[start] -= 1
                arr[tmp] += 1
                btk(cur + 1, sm + score[tmp])
                lst[i] = start
                arr[tmp] -= 1
                arr[start] += 1


num = list(map(int, input().split()))
# 점수 배열 i번 칸의 점수
score = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 13, 16, 19, 25, 24, 22, 26, 27,
         28, 30, 35, 0]
# i번 칸에서 빨간 화살표를 따라갈 때 나오는 번호
red = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 32, 22, 23, 24, 30, 24, 25, 24, 27, 28,
       31, 20, 33]
# 파란 화살표는 3개 있으니 딕셔너리 처리
blue = {5: 21, 10: 26, 15: 29}

lst = [0, 0, 0, 0]      # 각 말이 어디에 있는가
arr = [0] * 33          # 각 좌표에 말이 몇 개 있는가
mx = 0                  # 최대값
start = num[0]
arr[0] = 3
arr[start] = 1
lst[0] = start
btk(1, score[start])
print(mx)
