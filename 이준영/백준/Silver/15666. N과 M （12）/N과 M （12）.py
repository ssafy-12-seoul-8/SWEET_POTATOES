def btk(cur,lst):
    if len(lst) == M:
        print(*lst)
        return
    if cur>=l:
        return
    for i in range(cur,l):
        lst.append(num[i])
        btk(i,lst)
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
btk(0,[])
