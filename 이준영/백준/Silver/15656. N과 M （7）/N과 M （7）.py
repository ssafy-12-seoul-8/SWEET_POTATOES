def btk(lst):
    if len(lst) == M:
        print(*lst)
        return
    for i in range(N):
        lst.append(arr[i])
        btk(lst)
        lst.pop()


N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
btk([])
