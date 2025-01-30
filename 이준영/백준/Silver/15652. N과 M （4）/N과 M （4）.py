def btk(cur, lst):
    if len(lst) == M:
        print(*lst)
        return
    if cur >= N + 1:
        return
    for i in range(cur, N + 1):
        lst.append(i)
        btk(i, lst)
        lst.pop()


N, M = map(int, input().split())
btk(1, [])
