# 리팩토링 코드
# 이동한 좌표 구하기 - 함수화
# 첫 말이 가장 먼저 움직이게
# 가지치기
def move(cur, d):
    if cur in blue:
        cur = blue[cur]
        for j in range(d - 1):
            cur = red[cur]
        return cur

    for j in range(d):
        if cur == 32:
            return 32
        cur = red[cur]
    return cur


def btk(cur, sm):
    global mx
    if sm + (10 - cur) * 40 <= mx:
        return
    if cur == 10:  # 이동 끝나면 최대값 갱신
        mx = sm
        return
    for i in range(4):
        if lst[i] == 32:  # 도착 지점에 있는 걸 움직이지 말자. (10번을 던질 떄 모든 말이 도착지점에)
            continue  # 오는건 불가능한게 한 말이 들어오려면 최소 3번 필요함
        else:
            start = lst[i]
            end = move(start, num[cur])

            if end != 32 and arr[end] != 0:  # 만약 도착 지점이 아닌데 다른 말이 있다면 이 말 못움직임
                continue
            lst[i] = end
            arr[start] -= 1
            arr[end] += 1
            btk(cur + 1, sm + score[end])
            lst[i] = start
            arr[end] -= 1
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

lst = [0, 0, 0, 0]  # 각 말이 어디에 있는가
arr = [0] * 33  # 각 좌표에 말이 몇 개 있는가
mx = 0  # 최대값
end = move(0, num[0])
lst[0] = end
arr[end] = 1
arr[0] = 3
btk(1, score[end])
print(mx)
