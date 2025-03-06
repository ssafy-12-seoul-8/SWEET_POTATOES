# 백트래킹으로 타순을 정하고 체크하는 식으로 문제를 해결하였다.
# 한 이닝에 얻을 수 있는 점수는 생각해보면 일단 3아웃전까지 다 저장하고 뒤에서부터 셌을 때 4이상이 되는 순간부터 처음까지 주자는 모두 들어오므로
# 그 때 세면 된다.
import sys

input = sys.stdin.readline


def btk(cur):                                   # 0번타자를 3번에 놓기 위해 나머지 타자를 1~8번에 놓은후
    if cur == 9:
        order[0] = order[3]                     # 마지막에만 둘을 바꿔주었다.
        order[3] = 0
        check()
        order[3] = order[0]                     # 체크하고 3번 타석에는 원래 있던 애가 오는 걸로 함
        return

    for i in range(1, 9):
        if visited[i] == 0:
            visited[i] = 1
            order[cur] = i
            btk(cur + 1)
            visited[i] = 0


def check():
    global mx
    score = 0
    start = 0
    for i in range(N):
        if mx >= score + 24 * (N - i):          # 한 이닝에 얻을 수 있는 최대 점수는 24점이므로 종료 조건 해주자
            return
        out = 0
        lst = []                                # 안타(홈런 포함)를 저장할 배열
        while out < 3:
            if arr[i][order[start]] == 0:
                out += 1
            else:
                lst.append(arr[i][order[start]])
            start = (start + 1) % 9

        l = len(lst)
        sm = 0
        for j in range(l - 1, -1, -1):
            sm = sm + lst[j]
            if sm >= 4:                         # 4이상이면 0번부터 j번까지 주자는 홈에 들어온다.
                score += (j + 1)
                break
    mx = max(mx, score)                         # 최대값 갱신


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

mx = 0
order = [0] * 9
visited = [0] * 9
btk(1)
print(mx)
