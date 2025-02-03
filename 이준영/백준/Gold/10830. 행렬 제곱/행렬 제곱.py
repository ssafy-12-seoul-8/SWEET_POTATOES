def mul(arr1, arr2):  # 크기가 같은 두 정사각 행렬의 곱
    arr3 = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            for k in range(N):
                arr3[i][j] = (arr3[i][j] + (arr1[i][k] * arr2[k][j])) % 1000
    return arr3


def ex(arr, n):
    if n == 0:
        st_arr = [[0] * N for _ in range(N)]
        for i in range(N):
            st_arr[i][i] = 1
        return st_arr
    else:
        tmp = ex(arr, n // 2)
        ans = mul(tmp, tmp)
        if n % 2 == 1:
            ans = mul(ans, arr)
        return ans


N, B = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = ex(arr, B)
for i in range(N):
    print(*ans[i])
