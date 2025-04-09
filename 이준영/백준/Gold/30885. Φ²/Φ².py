import sys

input = sys.stdin.readline

def myprint(arr):
    for i in arr:
        print(idx_lst[i],end=" ")
    print()
    print("-"*50)
N = int(input())
idx_lst = list(map(int, input().split()))

lst = [i for i in range(N)]

while len(lst) >= 2:
    l = len(lst)
    tmp_lst = []
    idx = 0

    while idx < l:
        add = 0
        cur = lst[idx]

        # 왼쪽
        if tmp_lst and idx_lst[tmp_lst[-1]] <= idx_lst[cur]:
            tmp = tmp_lst.pop()
            add += idx_lst[tmp]

        # 오른쪽
        if idx < l - 1 and idx_lst[lst[idx + 1]] <= idx_lst[cur]:
            add += idx_lst[lst[idx + 1]]
            idx += 2
        else:
            idx += 1
        tmp_lst.append(cur)
        idx_lst[cur] += add
    lst = tmp_lst
print(idx_lst[lst[0]])
print(lst[0] + 1)
