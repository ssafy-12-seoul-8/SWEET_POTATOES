def conq(l, y, x):
    global idx
    if idx == len(lst):
        return
    if lst[idx] == "Q":
        k = l // 2
        idx += 1
        conq(k, y, x)
        conq(k, y, x + k)
        conq(k, y + k, x)
        conq(k, y + k, x + k)
    elif lst[idx] == "B":
        for i in range(y, y + l):
            for j in range(x, x + l):
                arr[i][j] = 1
        idx += 1
    else:
        idx += 1


n = int(input())
lst = list(input())
print(f'#define quadtree_width {n}')
print(f'#define quadtree_height {n}')
print('static char quadtree_bits[] = {')
arr = [[0] * n for _ in range(n)]
idx = 0

conq(n, 0, 0)

for i in range(n):
    ans = []
    for j in range(0, n, 8):
        tmp = 0
        for k in range(8):
            tmp += (arr[i][j + k] << k)
        a = str(hex(tmp))
        if tmp <= 15:
            a = a[:2] + '0' + a[2]
        ans.extend((a, ','))

    print("".join(ans))

print('};')