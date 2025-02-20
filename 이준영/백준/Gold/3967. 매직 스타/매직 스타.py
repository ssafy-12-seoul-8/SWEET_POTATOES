# 미리 각 좌표를 지정하고 해결하였습니다.
# 각 좌표가 어떤 줄에 속하는지, 어떤 알파벳이 쓰여있는지 등을 관리하였습니다.
# 문제랑 다르게 A를 0으로 하였고 합을 22가 되게 하였습니다.
def btk(cur):
    global flag                             # 답을 찾았는가

    if flag:
        return

    if cur == 12:                           # 다 채웠으니 ans배열에 답을 채워넣습니다.
        flag = True
        for i in range(5):
            for j in range(9):
                ans[i][j] = arr[i][j]
        return

    y, x = lst[cur]
    if arr[y][x] != "x":                    # 이미 채워져있으면 넘어갑니다.
        btk(cur + 1)
        return

    for i in range(12):
        if a_visited[i] == 0:               # 만약 이 알파벳을 쓴적이 없다면
            t_flag = True
            for j in change[cur]:
                if check[j][1] == 3 and (check[j][0] + i) != 22:    # 각 줄에 대해 위배되는 사항이 있으면 안됨
                    t_flag = False
                    break
            if t_flag:                      # 위배되는 사항이 없다면 넣어보자
                a_visited[i] = 1            # 이 알파벳 방문
                arr[y][x] = chr(ord("A") + i)   # 채워넣고
                for j in change[cur]:       # 각 줄의 정보 갱신
                    check[j][1] += 1
                    check[j][0] += i
                btk(cur+1)
                a_visited[i] = 0            # 그 다음 복구 작업
                arr[y][x] = "x"
                for j in change[cur]:
                    check[j][1] -= 1
                    check[j][0] -= i

arr = [list(input()) for _ in range(5)]
ans = [[0] * 9 for _ in range(5)]
lst = [(0, 4), (1, 1), (1, 3), (1, 5), (1, 7), (2, 2), (2, 6), (3, 1), (3, 3), (3, 5), (3, 7), (4, 4)]  # 0~11번 인덱스
a_visited = [0] * 12  # 알파뱃 썼나
change = [(3, 4), (0, 1), (0, 3), (0, 4), (0, 2), (1, 3), (2, 4), (3, 5), (1, 5), (2, 5), (4, 5), (1, 2)]  # 각 인덱스가 속한 줄
check = [[0, 0] for _ in range(6)]  # (합,개수)

for i in range(12):
    y, x = lst[i]
    if arr[y][x] != "x":
        for j in change[i]:
            tmp = ord(arr[y][x]) - ord('A')
            check[j][0] += tmp
            check[j][1] += 1
            a_visited[tmp] = 1

flag = False

btk(0)

for i in range(5):
    print(*ans[i],sep="")
