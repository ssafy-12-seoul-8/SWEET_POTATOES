def btk(cur,l):
    global res

    if res==1:
        return
        
    if cur == N:
        return

    btk(cur+1,l)
    for j in range(M):
        lst[j] += model[cur][j]

    if l%2==0:
        check(l+1)

    btk(cur+1,l+1)
    for j in range(M):
        lst[j]-=model[cur][j]

def check(l):
    global res
    cnt = 0
    for j in range(M):
        if lst[j] > l//2:
            if ans[j]==1:
                cnt+=1
        elif ans[j]==0:
            cnt+=1

    if mx_correct < cnt:
        res = 1
    
N,M = map(int,input().split())
ans = list(map(int,input().split()))
model = [list(map(int,input().split())) for _ in range(N)]

mx_correct = 0
for i in range(N):
    cnt = 0
    for j in range(M):
        if ans[j]==model[i][j]:
            cnt+=1

    mx_correct = max(mx_correct, cnt)

res = 0
lst =[0]*M
btk(0,0)

print(res)