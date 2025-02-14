# 찾으려는 각 원소에 대한 이진 탐색
# 이를 위해서 arr을 정렬
# 근데 기존과 똑같이 하게 되면 start가 N이 되어 index error가 날 수도 있음 
# 따라서 처음에 최대보다 큰지 본다.
N = int(input())
arr = list(map(int, input().split()))
M = int(input())
arr2 = list(map(int, input().split()))

arr.sort()
for i in range(M):
    target = arr2[i]
    start = 0
    end = N - 1

    if target > arr[end]:
        ans = 0
    else:
        while start <= end:
            mid = (start + end) // 2
            if arr[mid] < target:
                start = mid + 1
            else:
                end = mid - 1

        if target == arr[start]:
            ans = 1
        else:
            ans = 0

    print(ans)
