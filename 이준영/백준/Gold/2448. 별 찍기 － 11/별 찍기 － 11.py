def star(k):
    if k == 0:
        arr = [[" "] * 5 for _ in range(3)]
        arr[0][2] = arr[1][1] = arr[1][3] = "*"
        for i in range(5):
            arr[2][i] = "*"
        return arr
    else:
        arr = [[" "] * (3 * (1 << (k + 1)) - 1) for _ in range(3 * (1 << k))]
        arr2 = star(k - 1)
        for i in range(3 * (1 << (k - 1))):
            for j in range(3 * (1 << k) - 1):
                arr[i][j + 3 * (1 << (k - 1))] = arr2[i][j]
                arr[i + (3 * 1 << (k - 1))][j] = arr2[i][j]
                arr[i + (3 * 1 << (k - 1))][j + 3 * (1 << k)] = arr2[i][j]

        return arr


N = int(input())
for i in range(11):
    if 3 * (1 << i) == N:
        k = i
        break
ans = star(k)
for i in range(len(ans)):
    print(*ans[i], sep="")
