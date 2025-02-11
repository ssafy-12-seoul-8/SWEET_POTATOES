def btk(lst):
    if len(lst)==N:
        check(lst)
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True
            lst.append(i)
            btk(lst)
            visited[i] = False
            lst.pop()

def check(lst):
    global mx

    sm = 0
    for i in range(N-1):
        sm = sm + abs(arr[lst[i]]-arr[lst[i+1]])

    mx = max(sm,mx)

N = int(input())
arr = list(map(int,input().split()))
mx = 0
visited = [False] * N
btk([])
print(mx)