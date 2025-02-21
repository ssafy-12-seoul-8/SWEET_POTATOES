N, K = map(int, input().split())
lst = list(map(int, input().split()))

belt = [0] * (2 * N)
for i in range(2 * N):
    belt[i] = [lst[i], 0]  # 내구도, 로봇있나
cnt = 0
time = 1
while True:
    belt[N - 2][1] = 0
    tmp = [belt[2 * N - 1][0], belt[2 * N - 1][1]]

    for i in range(2 * N - 1, 0, -1):
        belt[i] = [belt[i - 1][0], belt[i - 1][1]]

    belt[0] = tmp

    for i in range(N - 2, 0, -1):
        if belt[i][1] == 1 and belt[i + 1][1] == 0 and belt[i + 1][0] > 0:
            belt[i][1] = 0
            belt[i + 1][0] -= 1
            if belt[i + 1][0] == 0:
                cnt += 1
            belt[i + 1][1] = 1
            if i + 1 == N - 1:
                belt[i + 1][1] = 0

    if belt[0][0] > 0:
        belt[0][1] = 1
        belt[0][0] -= 1
        if belt[0][0] == 0:
            cnt += 1

    if cnt >= K:
        break
    time += 1

print(time)
