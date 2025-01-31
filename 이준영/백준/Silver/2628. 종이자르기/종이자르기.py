N, M = map(int, input().split())
k = int(input())
col = []
row = []
for i in range(k):
    a, b = map(int, input().split())
    if a == 0:
        col.append(b)
    else:
        row.append(b)
col.sort()
row.sort()
col_max = 0
row_max = 0
col.append(M)
row.append(N)
col_max = col[0]
row_max = row[0]
for i in range(len(col) - 1):
    col_max = max(col_max, col[i + 1] - col[i])
for i in range(len(row) - 1):
    row_max = max(row_max, row[i + 1] - row[i])
print(col_max * row_max)
