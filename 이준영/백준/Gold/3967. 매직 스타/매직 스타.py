def btk(cur):
    global flag

    if flag:
        return

    if cur == 12:
        flag = True
        for i in range(5):
            for j in range(9):
                ans[i][j] = arr[i][j]
        return

    y, x = lst[cur]
    if arr[y][x] != "x":
        btk(cur + 1)
        return

    for i in range(12):
        if a_visited[i] == 0:
            t_flag = True
            for j in change[cur]:
                if check[j][1] == 3 and (check[j][0] + i) != 22:
                    t_flag = False
                    break
            if t_flag:
                a_visited[i] = 1
                arr[y][x] = chr(ord("A") + i)
                for j in change[cur]:
                    check[j][1] += 1
                    check[j][0] += i
                btk(cur+1)
                a_visited[i] = 0
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
