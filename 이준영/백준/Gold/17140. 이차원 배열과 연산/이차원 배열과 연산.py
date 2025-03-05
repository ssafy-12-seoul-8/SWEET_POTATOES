def R(arr):
    mx_len = -1
    lst = [[] for _ in range(N)]
    for i in range(N):
        cnt = [0] * 101
        for j in arr[i]:
            if j == 0:
                continue
            else:
                cnt[j] += 1
        t_lst = []
        for j in range(1, 101):
            if cnt[j] != 0:
                t_lst.append([cnt[j], j])

        t_lst.sort()
        for a, b in t_lst:
            lst[i].append(b)
            lst[i].append(a)
        mx_len = max(mx_len, len(lst[i]))

    mx_len = min(mx_len, 100)
    new_arr = [[0] * mx_len for _ in range(N)]
    for i in range(N):
        for j in range(min(100, len(lst[i]))):
            new_arr[i][j] = lst[i][j]

    return new_arr


def C(arr):
    mx_len = -1
    lst = [[] for _ in range(M)]
    for j in range(M):
        cnt = [0] * 101
        for i in range(N):
            if arr[i][j] == 0:
                continue
            cnt[arr[i][j]] += 1

        t_lst = []
        for i in range(1, 101):
            if cnt[i] != 0:
                t_lst.append([cnt[i], i])
        t_lst.sort()
        for a, b in t_lst:
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
A = [list(map(int, input().split())) for _ in range(3)]
r = r - 1
c = c - 1
N = 3
M = 3

t = 0
ans = -1

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
