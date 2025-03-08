def btk(cur):
    if cur == l:
        print("".join(idx))
        return

    for i in lst:
        if dct[i] > 0:
            dct[i] -= 1
            idx[cur] = i
            btk(cur + 1)
            dct[i] += 1


N = int(input())
for _ in range(N):
    s = input()
    l = len(s)
    dct = {}
    for i in s:
        if i in dct:
            dct[i] += 1
        else:
            dct[i] = 1

    lst = sorted(list(dct.keys()))
    idx = [0] * l
    btk(0)
