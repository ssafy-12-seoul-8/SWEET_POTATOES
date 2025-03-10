# 딕셔너리 버전
# 각 좌표에 있는 나무수와 양분을 따로 관리하였습니다.
n, m, k = map(int, input().split())

ene = [list(map(int, input().split())) for _ in range(n)]  # 매년 추가되는 양분의 양

cur = [[5] * n for _ in range(n)]  # 양분의 양 (처음엔 5이다.)

tree = [[{} for _ in range(n)] for _ in range(n)]  # tree[i][j]: i,j칸에 있는 묘목들 (나이들만)
dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]

for _ in range(m):  # 칸을 0~n-1로 관리
    r, c, a = map(int, input().split())
    r = r - 1
    c = c - 1
    if a in tree[r][c]:
        tree[r][c][a] += 1
    else:
        tree[r][c][a] = 1

for _ in range(k):
    tmp = [[{} for _ in range(n)] for _ in range(n)]  # 1초 후 묘목의 상태
    for i in range(n):
        for j in range(n):
            if not tree[i][j]:
                continue
            lst = list(tree[i][j].keys())
            lst.sort()
            start = cur[i][j]
            plus = 0
            for a in lst:
                cnt = tree[i][j][a]
                if start < a:
                    plus += (a // 2) * cnt
                else:
                    t_cnt = min(cnt, start // a)
                    m_cnt = cnt - t_cnt
                    start -= a * t_cnt
                    if a + 1 in tmp[i][j]:
                        tmp[i][j][a + 1] += t_cnt
                    else:
                        tmp[i][j][a + 1] = t_cnt
                    plus += (a // 2) * m_cnt
                    if t_cnt > 0 and a % 5 == 4:
                        for l in range(8):
                            ny = i + dy[l]
                            nx = j + dx[l]
                            if 0 <= ny < n and 0 <= nx < n:
                                if 1 in tmp[ny][nx]:
                                    tmp[ny][nx][1] += t_cnt
                                else:
                                    tmp[ny][nx][1] = t_cnt
            cur[i][j] = start + plus  # 양분은 현재 양분양 + 더해지는 양분양
    for i in range(n):
        for j in range(n):
            cur[i][j] += ene[i][j]  # 양분 보충하고

    tree = tmp

cnt = 0
for i in range(n):
    for j in range(n):
        for l in tree[i][j].values():
            cnt += l

print(cnt)
