def btk(lst):
    if len(lst) == M:
        print(*lst)
        return
    for i in range(l):
        lst.append(num[i])
        btk(lst)
        lst.pop()


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
l = len(num)
btk([])
