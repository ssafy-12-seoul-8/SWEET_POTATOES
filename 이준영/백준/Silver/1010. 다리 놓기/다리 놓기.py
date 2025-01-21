T = int(input())
for tc in range(T):
    n, m = map(int,input().split())
    result = 1
    for i in range(1,m+1):
        result *= i
    for i in range(1,n+1):
        result = result // i
    for i in range(1,m-n+1):
        result = result // i
    print(result)