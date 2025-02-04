# 정렬한 후 3 개의 좌표 중 가장 왼쪽을 고정하고 투 포인터를 사용
import sys

input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))

lst.sort()

mn = abs(lst[0] + lst[1] + lst[2])
l1, l2, l3 = 0, 1, 2

for i in range(N - 2):
    start = i + 1
    end = N - 1
    
    while start < end:
        tot = lst[i] + lst[start] + lst[end]
        
        if abs(tot) < mn:
            mn = abs(tot)
            l1, l2, l3 = i, start, end
            
        if tot < 0:
            start += 1
        else:
            end -= 1

print(lst[l1], lst[l2], lst[l3])
