N = int(input())
road = set([])
count = [0] * (N + 1)
for i in range(N - 1):
    a, b = map(int, input().split())
    road.add((a, b))
    road.add((b, a))
    count[a] += 1
    count[b] += 1

lst = list(map(int, input().split()))

if lst[0] != 1:
    print(0)
else:
    flag = 1
    stk = [1]
    for i in range(1, N):
        while stk and count[stk[-1]] == 0:
            stk.pop()

        if not stk:
            flag = 0
            break

        cur = stk[-1]
        target = lst[i]
        if (cur, target) not in road:
            flag = 0
            break

        stk.append(target)
        count[cur] -= 1
        count[target] -= 1

    print(flag)
