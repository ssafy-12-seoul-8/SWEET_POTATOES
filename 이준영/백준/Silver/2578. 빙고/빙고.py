arr = [0] * 5
arr2 = [0] * 5

for i in range(5):
    arr[i] = list(map(int, input().split()))
for i in range(5):
    arr2[i] = list(map(int, input().split()))

dct = {}
for i in range(5):
    for j in range(5):
        dct[arr[i][j]] = (i, j)

row = [0] * 5
col = [0] * 5
diag1 = 0  # 오른쪽 아래 대각선
diag2 = 0  # 왼쪽 아래 대각선
bingo = 0
cnt = 0

while bingo < 3:
    y, x = dct[arr2[cnt // 5][cnt % 5]]
    row[y] += 1
    col[x] += 1
    if row[y] == 5:
        bingo += 1
    if col[x] == 5:
        bingo += 1
    if y == x:
        diag1 += 1
        if diag1 == 5:
            bingo += 1
    if y + x == 4:
        diag2 += 1
        if diag2 == 5:
            bingo += 1
    cnt += 1

print(cnt)
