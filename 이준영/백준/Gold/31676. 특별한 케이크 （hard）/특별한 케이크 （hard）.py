import sys

input = sys.stdin.readline

a = input().rstrip()

N = int(input())

arr = [0] * (N + 1)
pos = [0] * (N + 1)
imp = [0] * (N + 1)

tot_cnt = 0

for i in range(N):
    M = int(input())
    lst = list(map(int, input().split()))
    B = int(input())
    if B == 0:
        for j in lst:
            imp[j] += 1
    else:
        for j in lst:
            pos[j] += 1
        tot_cnt += 1
    arr[i] = [lst, B]

lst = []
for i in range(N):
    t_lst = arr[i][0]
    B = arr[i][1]
    if B == 0:
        flag = True
        for j in t_lst:
            imp[j] -= 1
            pos[j] += 1

        if imp[i + 1] > 0 or pos[i + 1] != tot_cnt + 1:
            flag = False
        for j in t_lst:
            imp[j] += 1
            pos[j] -= 1
        if flag:
            lst.append(i + 1)

    else:
        flag = True
        for j in t_lst:
            imp[j] += 1
            pos[j] -= 1
        if imp[i + 1] > 0 or pos[i + 1] != tot_cnt - 1:
            flag = False
        for j in t_lst:
            imp[j] -= 1
            pos[j] += 1
        if flag:
            lst.append(i + 1)

if lst:
    print(*lst)
else:
    print("swi")
