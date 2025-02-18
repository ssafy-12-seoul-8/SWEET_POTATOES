# 퀵 정렬
import sys

input = sys.stdin.readline


def quick(left, right):                 # arr[left:right+1]까지를 정렬하겠다.
    if right - left <= 0:               # 길이가 0이거나 1이면 더 할 필요 없음
        return

    pivot = arr[left]
    i = left + 1
    j = right

    while i < j:
        while i < j and pivot > arr[i]:                         # i<j이면서 pivot보다 작으면 계속 더함
            i = i + 1

        while i < j and pivot < arr[j]:                         # i<j이면서 pivot보다 크면 계속 뺌
            j = j - 1

        arr[i], arr[j] = arr[j], arr[i]                         # 자리 바꿈
                                        
    if arr[i] < pivot:                                          # i위치에 있는게 pivot보다 작으면 바꾸면 됨
        arr[i], arr[left] = arr[left], arr[i]   
        location = i
    else:
        arr[i - 1], arr[left] = arr[left], arr[i - 1]           # i위치에 있는게 pivot보다 크면 i-1위치와 바꿔야 함
        location = i - 1
                                                                # location은 최종 pivot의 index
    quick(left, location - 1)                                   # location을 기준으로 좌우로 정렬하면 끝
    quick(location + 1, right)


N = int(input())

arr = [int(input()) for _ in range(N)]

quick(0, N - 1)

for i in range(N):
    print(arr[i])
