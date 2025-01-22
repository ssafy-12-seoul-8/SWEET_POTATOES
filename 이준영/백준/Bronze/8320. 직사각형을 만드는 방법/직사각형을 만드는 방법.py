import math

n= int(input())
count=0
for i in range(1,int(math.sqrt(n)+1)):
    count = count + (n//i-i+1)
print(count)