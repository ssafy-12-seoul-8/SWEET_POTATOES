def check(left, right):
    t_cnt = 0
    while True:
        if 0 <= left and right <= l - 1 and lst[left][0] == lst[right][0] and lst[left][1] + lst[right][1] >= 4:
            t_cnt += (lst[left][1] + lst[right][1])
            left -= 1
            right += 1
            continue
        else:
            break
    return t_cnt


N = int(input())
cnt = 1
cur = int(input())
lst = []
for _ in range(N - 1):
    a = int(input())
    if a == cur:
        cnt += 1
    else:
        lst.append([cur, cnt])
        cnt = 1
        cur = a
lst.append([cur, cnt])

if N <= 3:
    print(N)
else:
    mx = 0

    l = len(lst)

    for i in range(l):
        if l - 1 > i > 0:
            if lst[i][1] == 1:
                if lst[i - 1][0] == lst[i + 1][0] and lst[i - 1][1] + lst[i + 1][1] >= 3:
                    cnt = 1 + lst[i - 1][1] + lst[i + 1][1] + check(i - 2, i + 2)
                    mx = max(mx, cnt)
                else:
                    if lst[i - 1][1] == 3:
                        cnt = 4 + check(i - 2, i + 1)
                        mx = max(mx, cnt)
                    if lst[i + 1][1] == 3:
                        cnt = 4 + check(i - 1, i + 2)
            else:
                lst[i][1] -= 1
                if lst[i - 1][1] == 3:
                    cnt = 4 + check(i - 2, i)
                    mx = max(mx, cnt)
                if lst[i + 1][1] == 3:
                    cnt = 4 + check(i, i + 2)
                    mx = max(mx, cnt)
                lst[i][1] += 1

        elif i == 0:
            if lst[0][1] == 1:
                if lst[1][1] == 3:
                    mx = max(mx, 4)
            elif lst[1][1] == 3:
                lst[0][1] -= 1
                cnt = 4 + check(0, 2)
                mx = max(mx, cnt)
                lst[0][1] += 1
        else:
            if lst[i][1] == 1:
                if lst[i - 1][1] == 3:
                    mx = max(mx, 4)
            elif lst[i - 1][1] == 3:
                lst[i][1] -= 1
                cnt = 4 + check(i - 2, i)
                lst[i][1] += 1

    print(N - mx)
