# 만약 원래 값에 어떤 연산을 행한 결과에 대해 정렬을 하며 원본값을 유지하고 싶다면 배열이라 튜플을 pq에 넣는 방법이 있다.
# 이 문제에서는 (abs(x),x)를 넣어서 같은 절대값에 대해 오름차순으로 정렬하며 원본 수를 유지하도록 하였습니다.
import sys
from heapq import heappop, heappush

input = sys.stdin.readline

N = int(input())

pq = []

for _ in range(N):
    x = int(input())
    if x == 0:
        if not pq:
            print(0)

        else:
            tmp = heappop(pq)
            print(tmp[1])

    else:
        heappush(pq, (abs(x), x))               # (절대값, 원본값)
