def btk(cur, cont, l_num, score):  # 몇번째, 연속한 횟수, 마지막 수, 점수
    global cnt

    if score - cur + 5 < 0:     # 다 맞아도 안됨
        return
    
    if cur == 10:               # 끝까지 왔다.
        if score >= 5:
            cnt += 1
        return

    if cont <= 1:               # 연속한 횟수가 1이하이면 아무거나 와도 된다.
        for i in range(1, 6):   
            tmp1 = cont         # 연속한 횟수와 점수는 조건문으로 관리
            tmp2 = score
            if i == l_num:
                tmp1 += 1
            else:
                tmp1 = 1
            if i == arr[cur]:
                tmp2 += 1
            btk(cur + 1, tmp1, i, tmp2)
    else:                       # 연속한 횟수가 2면 무조건 이전 번호와 다르게 찍는다.
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
