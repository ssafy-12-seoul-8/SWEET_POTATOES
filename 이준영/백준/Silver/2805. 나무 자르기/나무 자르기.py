# start는 가능, end는 불가능으로 설정
# 각 mid에 대해서 나무의 높이로 적절한지 아닌지를 판별하여 start를 end로 할건지, end를 start로 할건지를 정할 거다.
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
tree = list(map(int, input().split()))
start = 0                                   # 당연히 다 자르면 가능
end = max(tree)                             # 나무를 안 자르면 불가능

while end - start > 1:
    sm = 0                                 
    mid = (start + end) // 2            
    for i in range(N):
        sm = sm + max(0, tree[i] - mid)
    if sm >= M:                             # 이러면 가능
        start = mid
    else:                                   # 이러면 불가능
        end = mid
print(start)
