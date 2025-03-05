def R(arr):                                                     # 가로 정렬
    lst = [[] for _ in range(N)]                                # 새로 각 행에 넣을 리스트
    mx_len = -1                                                 # lst의 원소 중 최대 길이
    for i in range(N):
        cnt = [0] * 101                                         # 0 ~ 100의 개수를 저장할 배열
        for j in arr[i]:
            cnt[j] += 1                                         # 어차피 0은 아래에서 제거하면 되니까 0도 센다.

        tmp_lst = []
        for j in range(1, 101):                                 # 여기서 1~100만 세서 tmp_lst에 넣음
            if cnt[j] != 0:
                tmp_lst.append((cnt[j], j))

        tmp_lst.sort()                                          # 어차피 cnt[j]가 작은 순서대로, 이후는 j가 작은 순서대로 되니
        for a, b in tmp_lst:                                    # 문제의 조건에 맞게 정렬된다.
            lst[i].append(b)                                    # 넣을 때는 반대로 넣어야 한다.
            lst[i].append(a)

        mx_len = max(mx_len, len(lst[i]))                       # 최대 길이 갱신

    mx_len = min(100, mx_len)                                   # 100초과는 자른다.
    new_arr = [[0] * mx_len for _ in range(N)]
    for i in range(N):
        for j in range(min(100, len(lst[i]))):                  # 최대 100까지만 채우자
            new_arr[i][j] = lst[i][j]

    return new_arr


def C(arr):                                                     # 세로 정렬 (전체적인 로직은 가로와 동일)
    global N, M
    new_arr = list(zip(*arr))
    N, M = M, N
    new_arr = R(new_arr)
    new_arr = list(zip(*new_arr))
    N, M = M, N
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
    if r <= N - 1 and c <= M - 1 and A[r][c] == k:              # r,c가 A의 배열 크기에 들어오고 k와 동일하면 그만한다.
        ans = t
        break

    if N >= M:
        A = R(A)
    else:
        A = C(A)

    N = len(A)                                                  # 가로, 세로 길이 갱신
    M = len(A[0])
    t += 1
print(ans)
