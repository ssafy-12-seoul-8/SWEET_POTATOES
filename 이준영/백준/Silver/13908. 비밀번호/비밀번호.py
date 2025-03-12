def btk(cur, remain):
    if n - cur < remain:
        return 0

    if remain == 0:
        return 10 ** (n - cur)

    tmp = (10 - remain) * btk(cur + 1, remain) + remain * btk(cur + 1, remain - 1)

    return tmp


n, m = map(int, input().split())
if m == 0:
    print(10 ** n)
else:
    lst = set(list(map(int, input().split())))
    cnt = btk(0, m)
    print(cnt)
