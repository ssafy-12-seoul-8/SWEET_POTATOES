import sys

input = sys.stdin.readline
N = int(input())
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))

order = [0] * (N + 1)
for i in range(N):
    order[arr2[i]] = i

for i in range(N):
    arr1[i] = order[arr1[i]]

lst = []

for i in range(N):
    tmp = arr1[i]
    if not lst:
        lst.append(tmp)
    elif lst[-1] < tmp:
        lst.append(tmp)
    elif lst[0] >= tmp:
        lst[0] = tmp
    else:
        start = 0
        end = len(lst) - 1
        while end - start > 1:
            mid = (start + end) // 2

            if lst[mid] < tmp:
                start = mid
            else:
                end = mid

        lst[end] = tmp

print(len(lst))
