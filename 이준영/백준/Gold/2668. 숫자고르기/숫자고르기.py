N = int(input())
lst = [0] * (N + 1)
for i in range(1, N + 1):
    lst[i] = int(input())

check = [0] * (N + 1)  # 0은 체크하기 전, 1은 가능, 2는 불가능

for i in range(1, N + 1):
    if check[i] != 0:
        continue
    cur = lst[i]

    st = set([])

    while True:
        if cur == i:
            flag = True
            break
        if cur in st:
            flag = False
            break
        if check[cur] != 0:
            flag = False
            break
        if check[cur] == 0:
            st.add(cur)
            cur = lst[cur]

    if flag:
        check[i] = 1
        for k in st:
            check[k] = 1
    else:
        check[i] = 2

ans = []
for i in range(1, N + 1):
    if check[i] == 1:
        ans.append(i)

l = len(ans)
print(l)
for i in range(l):
    print(ans[i])
