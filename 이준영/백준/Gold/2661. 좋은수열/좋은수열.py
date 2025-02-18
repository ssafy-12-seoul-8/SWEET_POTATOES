# 그냥 작은 것부터 백트래킹하면 되지 않을까
# 대신에 찾으면 한번에 끝내기 위해 전역변수 flag사용
def btk(lst):
    global flag, ans

    if flag:
        return

    l = len(lst)
    if l == N:
        ans = int("".join(lst))
        flag = True
        return

    for i in range(1, 4):
        t_flag = True
        for j in range(l - 1, l // 2 - 1, -1):
            if lst[j] != str(i):
                continue

            t_flag2 = True
            for k in range(l - j - 1):
                if lst[j - k - 1] != lst[l - 1 - k]:
                    t_flag2 = False
                    break

            if t_flag2:
                t_flag = False

        if t_flag:
            lst.append(str(i))
            btk(lst)
            lst.pop()


N = int(input())
flag = False
ans = 0
btk(["1"])
print(ans)
