import sys
input = sys.stdin.readline
N = int(input())
conf = [0]*N
for i in range(N):
    conf[i] = list(map(int,input().split()))
conf.sort(key= lambda x:(x[1],x[0]))
cur = -1
count = 0
for i in range(N):
    if cur>conf[i][0]:
        continue
    cur = conf[i][1]
    count+=1
print(count)