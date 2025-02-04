T = int(input())
for tc in range(T):
    n = int(input())
    pick = [0]
    pick.extend(list(map(int, input().split())))
    check = [0] * (n + 1)  # 0은 체크전, 1은 팀이 있음, 2는 팀이 없음
    for i in range(1, n + 1):
        if check[i] != 0:
            continue

        cur = 0
        start = i
        dct = {i: 0}
        lst = [i]

        while True:
            cur += 1
            start = pick[start]
            if check[start] != 0:
                for k in lst:
                    check[k] = 2
                break
            if start not in dct:
                dct[start] = cur
                lst.append(start)
                continue
            for j in range(len(lst)):
                if j < dct[start]:
                    check[lst[j]] = 2
                else:
                    check[lst[j]] = 1
            break

    cnt = 0
    for i in range(1, n + 1):
        if check[i] == 2:
            cnt += 1
    print(cnt)
