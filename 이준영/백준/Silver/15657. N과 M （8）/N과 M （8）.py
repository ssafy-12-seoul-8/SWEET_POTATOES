def btk(cur, lst):
    if len(lst) == M:
        print(*lst)
        return
    for i in range(cur,N):
        lst.append(arr[i])
        btk(i,lst)
        lst.pop()


N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
btk(0,[])
