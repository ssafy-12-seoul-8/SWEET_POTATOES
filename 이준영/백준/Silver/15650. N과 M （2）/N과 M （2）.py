def btk(cur,lst):
    if len(lst)==M:
        print(*lst)
        return
    if cur>N:
        return
    lst.append(cur)
    btk(cur+1,lst)
    lst.pop()
    btk(cur+1,lst)

N, M = map(int,input().split())
btk(1,[])