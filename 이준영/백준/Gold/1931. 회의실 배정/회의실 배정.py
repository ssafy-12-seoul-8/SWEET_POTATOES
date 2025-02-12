# 가능한 회의실 중 가장 빨리 끝나는 회의실을 고르면 된다.
# 그래서 회의실을 종료 시간을 기준으로 정렬하면서 순회한다.
# 만약 현재 시간보다 늦게 끝나면 고르고 아니면 다음으로 넘어간다.

import sys

input = sys.stdin.readline
N = int(input())

conf = [list(map(int,input().split())) for _ in range(N)]
conf.sort(key=lambda x: (x[1], x[0]))

cur = -1
count = 0
for i in range(N):
    if cur > conf[i][0]:
        continue
        
    cur = conf[i][1]
    count += 1
    
print(count)
