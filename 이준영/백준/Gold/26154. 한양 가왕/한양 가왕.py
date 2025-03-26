N, M = map(int, input().split())

lst = [list(map(int, input().split())) for _ in range(N)]

if M == 0:
    for i in range(N):
        a, b = lst[i]
        print(min(a, b), max(a, b))
else:
    for time in range(M):
        tmp_lst = [[] for _ in range(N)]
        flag = True
        a, b = lst[0]
        if a > b:
            a, b = b, a

        tmp_lst[0].append(b)
        tmp_lst[N - 1].append(a)

        if b != 2 * N:
            flag = False

        if a <= N - 1:
            flag = False

        for i in range(1, N):
            a, b = lst[i]
            if a > b:
                a, b = b, a

            tmp_lst[i].append(a)
            tmp_lst[i - 1].append(b)
            if b <= N - 1:
                flag = False

        lst = tmp_lst
        if flag:
            break

    remain = M - 1 - time

    lst1 = []
    lst2 = []
    a, b = lst[0]
    if a > b:
        a, b = b, a
    lst1.append(b)
    lst2.append(a)
    for i in range(1, N):
        a, b = lst[i]
        if a > b:
            a, b = b, a
        lst1.append(a)
        lst2.append(b)

    lst3 = [0] * N
    for i in range(N):
        lst3[i] = lst2[(i + remain) % N]

    print(lst3[0], lst1[0])
    for i in range(1, N):
        print(lst1[i], lst3[i])
