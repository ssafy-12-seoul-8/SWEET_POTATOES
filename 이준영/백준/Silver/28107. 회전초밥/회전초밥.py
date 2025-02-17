import sys
from heapq import heappop, heappush

input = sys.stdin.readline
N, M = map(int, input().split())
arr = [[] for _ in range(200001)]                       # 각 초밥에 대한 최소힙 (번호가 낮은 손님이 우선권이 있다.)
cnt = [0] * N                                           # 각 손님이 먹은 초밥 수

for i in range(N):
    lst = list(map(int, input().split()))
    for j in lst[1:]:
        heappush(arr[j], i)                             # j번 초밥에 i번 손님을 넣는다.

arr2 = list(map(int,input().split()))

for j in arr2:
    if not arr[j]:                                      # 선호하는 사람 없으면 버려짐
        continue
    p = heappop(arr[j])                                 # 선호하는 사람 있으면 명단에서 제외하고            
    cnt[p] += 1                                         # 그 사람의 초밥 수 증가

print(*cnt)