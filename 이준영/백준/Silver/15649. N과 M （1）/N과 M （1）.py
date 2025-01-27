def btk(lst):
    if len(lst)==M:
        print(*lst)
    for i in range(1,N+1):
        if not visited[i]:
            visited[i] = True
            lst.append(i)
            btk(lst)
            lst.pop()
            visited[i] = False

N, M = map(int,input().split())
visited = [False] * (N+1)
btk([])