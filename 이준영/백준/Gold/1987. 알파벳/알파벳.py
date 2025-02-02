def btk(y, x, cur):
    global max_count
    max_count = max(max_count, len(cur))
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < R and 0 <= nx < C and board[ny][nx] not in cur:
            cur.add(board[ny][nx])
            btk(ny, nx, cur)
            cur.remove(board[ny][nx])

R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
max_count = 0
st = set([board[0][0]])
btk(0, 0, st)
print(max_count)
