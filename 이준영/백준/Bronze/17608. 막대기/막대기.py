N = int(input())
arr = [0]*N
for i in range(N-1,-1,-1):
    arr[i] = int(input())
mx = arr[0]
count = 1
for i in range(1,N):
    if mx < arr[i]:
        mx = arr[i]
        count+=1
print(count)