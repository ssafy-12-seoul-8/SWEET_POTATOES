import sys
input = sys.stdin.readline
N, M = map(int,input().split())
tree = list(map(int,input().split()))
start = 0
end = max(tree)

while end-start>1:
    sum = 0
    mid = (start+end)//2
    for i in range(N):
        sum = sum + max(0,tree[i]-mid)
    if sum>=M:
        start= mid
    else:
        end = mid
print(start)