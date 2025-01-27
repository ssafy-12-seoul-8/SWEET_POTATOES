arr = [[0] * 9 for _ in range(9)]
for i in range(9):
    arr[i] = list(input().split())
mid = [0] * 8
k = 0
for i in range(9):
    if i != 4:
        mid[k] = (arr[1 + (i // 3) * 3][1 + (i % 3) * 3], i)
        k += 1

for i in range(8):
    for j in range(7 - i):
        if mid[j][0] > mid[j + 1][0]:
            mid[j], mid[j + 1] = mid[j + 1], mid[j]

for i in range(8):
    print(f'#{i + 1}. {mid[i][0]}')
    detail = [0] * 8
    k = 0
    for j in range(9):
        if j != 4:
            detail[k] = arr[(mid[i][1] // 3) * 3 + j // 3][(mid[i][1] % 3) * 3 + j % 3]
            k += 1
    for j in range(8):
        for k in range(7 - j):
            if detail[k] > detail[k + 1]:
                detail[k], detail[k + 1] = detail[k + 1], detail[k]
    for j in range(8):
        print(f'#{i + 1}-{j + 1}. {detail[j]}')
