R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

dct = {'|': (0, 2), '-': (1, 3), '+': (0, 1, 2, 3), '1': (1, 2), '2': (0, 1), '3': (0, 3), '4': (2, 3)}
reverse_dct = {}

for i, j in dct.items():
    reverse_dct[j] = i

y, x = -1, -1,
ans = -1
for i in range(R):
    for j in range(C):
        if arr[i][j] == ".":
            lst = []
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < R and 0 <= nx < C and arr[ny][nx] in dct:
                    if (k + 2) % 4 in dct[arr[ny][nx]]:
                        lst.append(k)
            if lst:
                y, x = i + 1, j + 1
                ans = reverse_dct[tuple(lst)]

print(y, x, ans)
