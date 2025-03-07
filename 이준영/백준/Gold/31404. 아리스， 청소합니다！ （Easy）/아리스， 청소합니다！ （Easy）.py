H, W = map(int, input().split())
R, C, D = map(int, input().split())
A = [list(map(int, input())) for _ in range(H)]
B = [list(map(int, input())) for _ in range(H)]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

visited = [[[1, 1, 1, 1, 1] for _ in range(W)] for _ in range(H)]

time = 1
ans = 0
flag = False
s_y = -1
s_x = -1
s_d = -1
while True:
    if visited[R][C][4] == 1:
        ans = time
        s_y = -1
        s_x = -1
        s_d = -1
        flag = True
        ac_time = 0
        visited[R][C][4] = 0
        D = (D + A[R][C]) % 4
        R = R + dy[D]
        C = C + dx[D]
        if not (0 <= R < H and 0 <= C < W):
            break
    else:
        if visited[R][C][D] == 0:
            if flag:
                flag = False
                s_y = R
                s_x = C
                s_d = D
                D = (D + B[R][C]) % 4
                R = R + dy[D]
                C = C + dx[D]
                if not (0 <= R < H and 0 <= C < W):
                    break
            else:
                if s_y == R and s_x == C and s_d == D:
                    break
                D = (D + B[R][C]) % 4
                R = R + dy[D]
                C = C + dx[D]
                if not (0 <= R < H and 0 <= C < W):
                    break
        else:
            visited[R][C][D] = 0
            D = (D + B[R][C]) % 4
            R = R + dy[D]
            C = C + dx[D]
            if not (0 <= R < H and 0 <= C < W):
                break
    time += 1
print(ans)
