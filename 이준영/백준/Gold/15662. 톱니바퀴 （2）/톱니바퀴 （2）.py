# 1이 시계, -1이 반시계
from collections import deque


def rotate(num, d):
    if d == 1:
        tmp = arr[num].pop()
        arr[num].appendleft(tmp)
    else:
        tmp = arr[num].popleft()
        arr[num].append(tmp)


T = int(input())
arr = [0] * T
for i in range(T):
    arr[i] = deque(list(map(int, input())))

K = int(input())
for _ in range(K):
    a, b = map(int, input().split())
    a = a - 1
    tot = [(a, b)]
    l_s = a - 1
    l_d = -b
    while l_s >= 0:
        if arr[l_s][2] == arr[l_s + 1][6]:
            break
        tot.append((l_s, l_d))
        l_d = -l_d
        l_s -= 1

    r_s = a + 1
    r_d = -b

    while r_s < T:
        if arr[r_s][6] == arr[r_s - 1][2]:
            break
        tot.append((r_s, r_d))
        r_d = -r_d
        r_s += 1

    for num, d in tot:
        rotate(num, d)

cnt = 0
for i in range(T):
    if arr[i][0] == 1:
        cnt += 1

print(cnt)
