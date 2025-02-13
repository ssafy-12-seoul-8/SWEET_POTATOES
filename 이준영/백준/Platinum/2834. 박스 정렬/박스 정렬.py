# 단순하게 1~N을 돌며 자기 자리에 맞추게 하면 되지 않나
# 만약 자기자리가 아니면 옮기고 옮겨진 수가 자기자리가 아니면 옮기고를 반복
# 이를 1~N을 돌면 될듯
N = int(input())
arr = [0]
arr.extend(list(map(int, input().split())))
visited = [0] * (N + 1)

dct = {}
cnt = 0
cycle = []
for i in range(1, N + 1):
    dct[arr[i]] = i

for i in range(1, N + 1):
    if visited[i] == 1 or arr[i] == i:
        continue

    visited[i] = 1

    tmp = [dct[i]]
    start = arr[i]

    while start != i:
        tmp.append(dct[start])
        visited[start] = 1
        start = arr[start]

    cycle.append(tmp)

if len(cycle) <= 2:
    print(len(cycle))
    for lst in cycle:
        print(f'{len(lst)}:', *lst)

else:
    new_tmp = []
    for lst in cycle:
        new_tmp.append(lst[0])

    l = len(new_tmp)
    tmp = arr[new_tmp[-1]]
    for i in range(l - 1, 0, -1):
        dct[arr[new_tmp[i - 1]]] = new_tmp[i]
        arr[new_tmp[i]] = arr[new_tmp[i - 1]]

    dct[tmp] = new_tmp[0]
    arr[new_tmp[0]] = tmp

    for i in range(1, N + 1):
        if dct[i] == i:
            continue

        ans = [dct[i]]
        start = i

        while dct[start] != start:
            ans.append(start)
            k = arr[start]
            arr[start], arr[dct[start]] = start, k
            dct[start], dct[k] = start, dct[start]
            start = k
        break

    print(2)
    print(f'{len(new_tmp)}:', *new_tmp)
    print(f'{len(ans)}:', *ans)
