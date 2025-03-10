# 각 좌표에 있는 나무수와 양분을 따로 관리하였습니다.
n, m, k = map(int, input().split())

ene = [list(map(int, input().split())) for _ in range(n)]               # 매년 추가되는 양분의 양

cur = [[5] * n for _ in range(n)]                                       # 양분의 양 (처음엔 5이다.)

tree = [[[] for _ in range(n)] for _ in range(n)]                       # tree[i][j]: i,j칸에 있는 묘목들 (나이들만)
dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]

for _ in range(m):                                                      # 칸을 0~n-1로 관리
    r, c, a = map(int, input().split())
    r = r - 1
    c = c - 1
    tree[r][c].append(a)

for i in range(n):
    for j in range(n):
        if tree[i][j]:
            tree[i][j].sort()                                           # 나이순으로 양분 먹으니 정렬

for _ in range(k):
    tmp = [[[] for _ in range(n)] for _ in range(n)]                    # 1초 후 묘목의 상태
    for i in range(n):
        for j in range(n):
            if not tree[i][j]:  
                continue
            start = cur[i][j]                                           # 처음 양분양
            plus = 0                                                    # 더해지는 양
            for a in tree[i][j]:
                if start < a:                                           # 양분이 부족하면 사망해서 양분이 된다.
                    plus += a // 2
                else:
                    start -= a                                          # 양분을 빼앗고
                    tmp[i][j].append(a + 1)                             # 나이가 증가
                    if a % 5 == 4:                                      # 커서 5의 배수가 되면 번식한다.
                        for l in range(8):
                            ny = i + dy[l]
                            nx = j + dx[l]
                            if 0 <= ny < n and 0 <= nx < n:
                                tmp[ny][nx].append(1)                   
            cur[i][j] = start + plus                                    # 양분은 현재 양분양 + 더해지는 양분양
    for i in range(n):
        for j in range(n):
            cur[i][j] += ene[i][j]                                      # 양분 보충하고
            tmp[i][j].sort()                                            # 나이순 정렬

    tree = tmp

cnt = 0
for i in range(n):
    for j in range(n):
        cnt += len(tree[i][j])

print(cnt)
