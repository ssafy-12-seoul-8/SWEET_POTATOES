import sys

input = sys.stdin.readline


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
N, M, P = map(int, input().split())
S = [0] + list(map(int, input().split()))

board = [list(input().rstrip()) for _ in range(N)]
dq = [[] for _ in range(P + 1)]

for i in range(N):
    for j in range(M):
        if "1" <= board[i][j] <= "9":
            cur = int(board[i][j])
            dq[cur].append((i, j))

while True:
    flag = False
    for i in range(1, P + 1):
        if not dq[i]:
            continue
        flag = True
        for l in range(S[i]):
            tmp_dq = []
            if not dq[i]:
                break
            for y, x in dq[i]:
                for k in range(4):
                    ny = y + dy[k]
                    nx = x + dx[k]
                    if not oob(ny, nx) and board[ny][nx] == ".":
                        board[ny][nx] = str(i)
                        tmp_dq.append((ny, nx))
            dq[i] = tmp_dq


    if not flag:
        break

ans = [0] * (P + 1)


for i in range(N):
    for j in range(M):
        if "1" <= board[i][j] <= "9":
            ans[int(board[i][j])] += 1

for i in range(1, P + 1):
    print(ans[i],end=" ")
