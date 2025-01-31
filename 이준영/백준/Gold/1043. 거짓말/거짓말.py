import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
know = list(map(int, input().split()))
party = [list(map(int, input().split())) for _ in range(M)]
if len(know) == 1:
    print(M)
else:
    st = set([])
    dq = deque(know[1:])
    road = [[] for _ in range(N + 1)]
    for arr in party:
        for i in range(1, len(arr) - 1):
            for j in range(i + 1, len(arr)):
                road[arr[i]].append(arr[j])
                road[arr[j]].append(arr[i])
    while dq:
        a = dq.popleft()
        if a not in st:
            st.add(a)
            for i in road[a]:
                if i not in st:
                    dq.append(i)
    cnt = 0
    for arr in party:
        check = True
        for i in arr[1:]:
            if i in st:
                check = False
                break
        if check:
            cnt += 1
    print(cnt)
