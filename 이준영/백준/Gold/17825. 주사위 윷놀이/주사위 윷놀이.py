def btk(cur, sm):
    global mx
    if cur == 10:
        mx = max(mx, sm)
        return
    for i in range(4):
        if lst[i] == 32:
            continue
        else:
            start = tmp = lst[i]
            if tmp in blue:
                tmp = blue[tmp]
                for j in range(num[cur] - 1):
                    tmp = red[tmp]
                if arr[tmp] != 0:
                    continue
                lst[i] = tmp
                arr[start] -= 1
                arr[tmp] += 1
                btk(cur + 1, sm + score[tmp])
                lst[i] = start
                arr[tmp] -= 1
                arr[start] += 1
            else:
                for j in range(num[cur]):
                    if tmp == 32:
                        break
                    tmp = red[tmp]
                if tmp != 32 and arr[tmp] != 0:
                    continue
                lst[i] = tmp
                arr[start] -= 1
                arr[tmp] += 1
                btk(cur + 1, sm + score[tmp])
                lst[i] = start
                arr[tmp] -= 1
                arr[start] += 1


num = list(map(int, input().split()))

score = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 13, 16, 19, 25, 24, 22, 26, 27,
         28, 30, 35, 0]
red = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 32, 22, 23, 24, 30, 24, 25, 24, 27, 28,
       31, 20, 33]
blue = {5: 21, 10: 26, 15: 29}

lst = [0, 0, 0, 0]
arr = [0] * 33
arr[0] = 4
mx = 0
btk(0, 0)
print(mx)
