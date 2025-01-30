def btk(lst):
    if len(lst) == M:
        print(*lst)
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            lst.append(arr[i])
            btk(lst)
            lst.pop()
            visited[i] = False


N, M = map(int, input().split())
arr = list(map(int,input().split()))
arr.sort()
visited = [False]*N
btk([])
