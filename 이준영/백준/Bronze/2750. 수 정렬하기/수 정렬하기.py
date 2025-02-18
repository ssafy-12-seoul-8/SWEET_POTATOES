import sys

input = sys.stdin.readline


def quick(left, right):
    if right - left <= 0:
        return

    pivot = arr[left]
    i = left + 1
    j = right

    while i < j:
        while i < j and pivot > arr[i]:
            i = i + 1

        while i < j and pivot < arr[j]:
            j = j - 1

        arr[i], arr[j] = arr[j], arr[i]

    if arr[i] < pivot:
        arr[i], arr[left] = arr[left], arr[i]
        location = i
    else:
        arr[i - 1], arr[left] = arr[left], arr[i - 1]
        location = i - 1

    quick(left, location - 1)
    quick(location + 1, right)


N = int(input())

arr = [int(input()) for _ in range(N)]

quick(0, N - 1)

for i in range(N):
    print(arr[i])
