def myprint(arr):
    for i in range(R):
        print(*arr[i], sep="")


def bomb(arr):
    arr2 = [["O"] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if arr[i][j] == "O":
                for k in range(5):
                    ny = i + dy[k]
                    nx = j + dx[k]
                    if 0 <= ny < R and 0 <= nx < C:
                        arr2[ny][nx] = "."
    return arr2


def intersect(arr1, arr2):
    arr3 = [["."] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if arr1[i][j] == "O" and arr2[i][j] == "O":
                arr3[i][j] = "O"

    return arr3


def reverse_arr(arr):
    arr2 = [[0] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if arr[i][j] == "O":
                arr2[i][j] = "."
            else:
                arr2[i][j] = "O"

    return arr2


R, C, N = map(int, input().split())
arr1 = [list(input()) for _ in range(R)]

dy = [0, 0, 0, 1, -1]
dx = [0, 1, -1, 0, 0]

arr_all = [["O"] * C for _ in range(R)]
arr3 = bomb(arr1)
arr5 = bomb(intersect(arr3, reverse_arr(arr1)))

# myprint(arr3)
# print("-" * 50)
# myprint(arr5)
if N == 1:
    myprint(arr1)
else:
    N = N % 4
    if N == 0 or N == 2:
        myprint(arr_all)
    elif N == 1:
        myprint(arr5)
    else:
        myprint(arr3)
