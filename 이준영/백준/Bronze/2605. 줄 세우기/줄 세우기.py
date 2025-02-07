N = int(input())
arr = list(map(int, input().split()))

ans = []
for i in range(1,N+1):
    num = arr[i-1]
    if num==0:
        ans.append(i)
    else:
        ans.insert(i-1-num,i)
print(*ans)