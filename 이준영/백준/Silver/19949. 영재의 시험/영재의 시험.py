def btk(cur, cont, l_num, score):   # 몇번째, 연속한 횟수, 마지막 수, 점수
    global cnt

    if cur == 10:
        if score >= 5:
            cnt += 1
        return

    if cont <= 1:
        for i in range(1, 6):
            tmp1 = cont
            tmp2 = score
            if i == l_num:
                tmp1 += 1
            else:
                tmp1 = 1
            if i == arr[cur]:
                tmp2 += 1
            btk(cur + 1, tmp1, i, tmp2)
    else:
        for i in range(1, 6):
            if i == l_num:
                continue
            tmp2 = score
            if i == arr[cur]:
                tmp2 += 1
            btk(cur + 1, 1, i, tmp2)


arr = list(map(int, input().split()))
cnt = 0
btk(0, 0, 0, 0)
print(cnt)
