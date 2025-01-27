def rotate(arr):
    l = len(arr)//2
    for k in range(1,l+1):
        arr[l-k][l-k], arr[l-k][l],arr[l-k][l+k], arr[l][l+k], arr[l+k][l+k], arr[l+k][l], arr[l+k][l-k], arr[l][l-k] = arr[l][l-k], arr[l-k][l-k], arr[l-k][l],arr[l-k][l+k], arr[l][l+k], arr[l+k][l+k], arr[l+k][l], arr[l+k][l-k]

T = int(input())
for tc in range(1, T + 1):
    n, d = map(int, input().split())
    arr = [0] * n
    for i in range(n):
        arr[i] = list(map(int, input().split()))
    if d>=0:
        for i in range(d//45):
            rotate(arr)
    else:
        for i in range((360+d)//45):
            rotate(arr)
    for i in range(n):
        print(*arr[i])