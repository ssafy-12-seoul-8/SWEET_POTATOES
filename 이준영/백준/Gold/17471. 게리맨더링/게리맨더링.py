from collections import deque


def btk(cur, one_cnt):
    if cur == N + 1:
        if one_cnt < N:
            check()
        return
    team[cur] = 1
    btk(cur + 1, one_cnt + 1)
    team[cur] = 2
    btk(cur + 1, one_cnt)


def check():
    global mn
    cnt1, sm1 = bfs(1, 1)
    for i in range(2, N + 1):
        if team[i] == 2:
            cnt2, sm2 = bfs(i, 2)
            break

    if cnt1 + cnt2 == N:
        mn = min(mn, abs(sm1 - sm2))


def bfs(start, t1):
    visited = [0] * (N + 1)
    dq = deque([start])
    visited[start] = 1
    sm = people[start]
    cnt = 1
    while dq:
        cur = dq.popleft()
        for j in road[cur]:
            if visited[j] == 0 and team[j] == t1:
                visited[j] = 1
                cnt += 1
                sm += people[j]
                dq.append(j)

    return cnt, sm


N = int(input())
people = [0]
people.extend(list(map(int, input().split())))

road = [[] for _ in range(N + 1)]
for i in range(1, N + 1):
    lst = list(map(int, input().split()))
    for j in lst[1:]:
        road[i].append(j)

team = [0] * (N + 1)
team[1] = 1
mn = 1001
btk(2, 1)

if mn == 1001:
    print(-1)
else:
    print(mn)
