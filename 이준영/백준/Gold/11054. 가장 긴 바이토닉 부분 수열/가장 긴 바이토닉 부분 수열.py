import sys


def find(arr):
    if not arr:
        return 0
    mx = arr[-1]
    lst = []
    for i in range(len(arr)):
        if arr[i] >= mx:
            continue
        if not lst:
            lst.append(arr[i])
        elif lst[-1] < arr[i]:
            lst.append(arr[i])
        elif lst[0] > arr[i]:
            lst[0] = arr[i]
        else:
            start = 0
            end = len(lst) - 1
            while start < end - 1:
                mid = (start + end) // 2
                if lst[mid] < arr[i]:
                    start = mid
                else:
                    end = mid
            lst[end] = arr[i]
    return len(lst)


input = sys.stdin.readline
N = int(input())
lst = list(map(int, input().split()))

max_count = 0
for i in range(N):
    max1 = find(lst[:i + 1])
    max2 = find(list(reversed(lst[i:])))
    max_count = max(max_count, max1 + max2 + 1)
print(max_count)
