def btk(lst):
    if len(lst) == M:
        print(*lst)
        return
    for i in range(len(num)):
        if dct[num[i]] >= 1:
            dct[num[i]] -= 1
            lst.append(num[i])
            btk(lst)
            lst.pop()
            dct[num[i]] += 1


N, M = map(int, input().split())
arr = list(map(int, input().split()))
dct = {}
for i in arr:
    if i in dct:
        dct[i] += 1
    else:
        dct[i] = 1
num = list(dct.keys())
num.sort()
btk([])
