def btk(cur):
    global flag

    if flag:
        return

    if cur == 15:
        flag = True
        return

    p1, p2 = l[cur]

    for k in range(3):
        if arr[p1][k] > 0 and arr[p2][2 - k] > 0:
            arr[p1][k] -= 1
            arr[p2][2 - k] -= 1
            btk(cur + 1)
            arr[p1][k] += 1
            arr[p2][2 - k] += 1


k = 0
l = [0] * 15
for i in range(6):
    for j in range(i + 1, 6):
        l[k] = (i, j)
        k += 1
for _ in range(4):
    lst = list(map(int, input().split()))
    arr = [[0] * 3 for _ in range(6)]
    for i in range(6):
        for j in range(3):
            arr[i][j] = lst[3 * i + j]

    check = True
    for i in range(6):
        if arr[i][0]+arr[i][1]+arr[i][2]!=5:
            check = False
            break
    if not check:
        print(0, end=" ")
    else:

        flag = False

        btk(0)
        if flag:
            print(1, end=" ")
        else:
            print(0, end=" ")
