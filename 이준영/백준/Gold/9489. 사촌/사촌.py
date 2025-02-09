from collections import deque

while True:
    n, k = map(int, input().split())
    if n == 0:
        break
    lst = list(map(int, input().split()))
    root = lst[0]
    child = {}
    par = {}
    dq = deque([root])
    cur = 1
    while dq and cur < n:
        a = dq.popleft()
        child[a] = []

        while cur < n - 1 and lst[cur + 1] == lst[cur] + 1:
            child[a].append(lst[cur])
            dq.append(lst[cur])
            par[lst[cur]] = a
            cur += 1
        child[a].append(lst[cur])
        dq.append(lst[cur])
        par[lst[cur]] = a
        cur += 1

    cnt = 0
    if k not in par or par[k] not in par:
        cnt = 0
    else:
        p = par[k]
        q = par[p]
        for tmp in child[q]:
            if tmp != p and tmp in child:
                cnt += len(child[tmp])

    print(cnt)
