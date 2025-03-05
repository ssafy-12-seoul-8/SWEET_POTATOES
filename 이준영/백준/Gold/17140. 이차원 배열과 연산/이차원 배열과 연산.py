def R(arr):
    lst = [[] for _ in range(N)]
    mx_len = -1
    for i in range(N):
        cnt = [0] * 101
        for j in arr[i]:
            cnt[j] += 1

        tmp_lst = []
        for j in range(1, 101):
            if cnt[j] != 0:
                tmp_lst.append((cnt[j], j))

        tmp_lst.sort()
        for a, b in tmp_lst:
            lst[i].append(b)
            lst[i].append(a)

        mx_len = max(mx_len, len(lst[i]))

    mx_len = min(100, mx_len)
    new_arr = [[0] * mx_len for _ in range(N)]
    for i in range(N):
        for j in range(min(100, len(lst[i]))):
            new_arr[i][j] = lst[i][j]

    return new_arr


def C(arr):
    lst = [[] for _ in range(M)]
    mx_len = -1
    for j in range(M):
        cnt = [0] * 101
        for i in range(N):
            cnt[arr[i][j]] += 1

        tmp_lst = []
        for i in range(1, 101):
            if cnt[i] != 0:
                tmp_lst.append((cnt[i], i))

        tmp_lst.sort()
        for a, b in tmp_lst:
            lst[j].append(b)
            lst[j].append(a)

        mx_len = max(mx_len, len(lst[j]))

    mx_len = min(100, mx_len)
    new_arr = [[0] * M for _ in range(mx_len)]
    for j in range(M):
        for i in range(min(100, len(lst[j]))):
            new_arr[i][j] = lst[j][i]

    return new_arr


r, c, k = map(int, input().split())

r = r - 1
c = c - 1

A = [list(map(int, input().split())) for _ in range(3)]

N = 3
M = 3
ans = -1
t = 0
while t <= 100:
    if r <= N - 1 and c <= M - 1 and A[r][c] == k:
        ans = t
        break

    if N >= M:
        A = R(A)
    else:
        A = C(A)

    N = len(A)
    M = len(A[0])
    t += 1
print(ans)
