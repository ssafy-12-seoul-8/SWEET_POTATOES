n, m = map(int, input().split())
chess = [[0] * (m + 1) for _ in range(n + 1)]  # 0은 체크 안된곳, 1은 퀸, 2는 나이트, 3은 폰. -1은 걸리는 곳
queen = list(map(int, input().split()))
knight = list(map(int, input().split()))
pawn = list(map(int, input().split()))

q_dy = [0, -1, -1, -1, 0, 1, 1, 1]
q_dx = [-1, -1, 0, 1, 1, 1, 0, -1]

k_dy = [-1, -2, -2, -1, 1, 2, 2, 1]
k_dx = [-2, -1, 1, 2, 2, 1, -1, -2]

for i in range(len(queen) // 2):
    chess[queen[i * 2 + 1]][queen[i * 2 + 2]] = 1
for i in range(len(knight) // 2):
    chess[knight[i * 2 + 1]][knight[i * 2 + 2]] = 2
for i in range(len(pawn) // 2):
    chess[pawn[i * 2 + 1]][pawn[i * 2 + 2]] = 3

for i in range(len(queen) // 2):
    y = queen[i * 2 + 1]
    x = queen[i * 2 + 2]
    for j in range(8):
        ny, nx = y, x
        while True:
            ny += q_dy[j]
            nx += q_dx[j]
            if 1 <= ny < n + 1 and 1 <= nx < m + 1:
                if chess[ny][nx] > 0:
                    break
                chess[ny][nx] = -1
                continue
            break

for i in range(len(knight) // 2):
    y = knight[i * 2 + 1]
    x = knight[i * 2 + 2]
    for j in range(8):
        ny = y + k_dy[j]
        nx = x + k_dx[j]
        if 1 <= ny < n + 1 and 1 <= nx < m + 1 and chess[ny][nx] == 0:
            chess[ny][nx] = -1

cnt = 0
for i in range(1, n + 1):
    for j in range(1, m + 1):
        if chess[i][j] == 0:
            cnt += 1
# for i in range(1, n + 1):
#     for j in range(1, m + 1):
#         print(chess[i][j], end=" ")
#     print()
print(cnt)
