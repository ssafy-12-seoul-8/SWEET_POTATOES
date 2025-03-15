def delete(start, end):
    if start==end:
        return
    l = (end-start+1)//3
    mid1 = start + l-1
    mid2 = mid1+l
    for i in range(mid1+1,mid2+1):
        arr[i] =" "
    delete(start,mid1)
    delete(mid2+1,end)
while True:
     try:
         N = int(input())
         arr= ["-"]*(3**N)
         delete(0,3**N-1)
         print(*arr,sep="")
     except Exception:
         break