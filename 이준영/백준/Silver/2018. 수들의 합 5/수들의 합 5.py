N = int(input())
count = 1
for i in range(2,N):
    if(i*(i+1)>2*N):
        break
    if i%2==0:
        k = i//2
        if N%k==0 and (N//k)%2==1:
            count+=1
    else:
        if N%i==0:
            count+=1
print(count)