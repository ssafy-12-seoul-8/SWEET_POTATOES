def myprint():
    print('green')
    for i in range(10):
        print(*green[i])
    print('blue')
    for i in range(10):
        print(*blue[i])

    print("-"*50)
def go(block, arr):
    global score
    drop(block, arr)
    cnt = bomb(arr)
    score += cnt
    semi_bomb(arr)


def drop(block, arr):
    d = 0
    while True:
        flag = True
        for y, x in block:
            if y + d == 10:
                flag = False
                break

            if arr[y + d][x] == 1:
                flag = False
                break

        if not flag:
            break
        d += 1

    d -= 1
    for y, x in block:
        arr[y + d][x] = 1


def bomb(arr):
    cnt = 0
    start = -1
    for i in range(6, 10):
        if sum(arr[i]) == 4:
            start = i
            arr[i] = [0] * 4
            cnt += 1
    if cnt > 0:
        for i in range(start - cnt, 3, -1):
            arr[i + cnt] = arr[i][:]
            arr[i] = [0] * 4

    return cnt


def semi_bomb(arr):
    cnt = 0
    for i in (4, 5):
        if sum(arr[i]) > 0:
            cnt += 1

    if cnt > 0:
        for i in range(9 - cnt, 3, -1):
            arr[i + cnt] = arr[i][:]
            arr[i] = [0] * 4


green = [[0] * 4 for _ in range(10)]
blue = [[0] * 4 for _ in range(10)]
block_delta = [[], [(0, 0)], [(0, 0), (0, 1)], [(0, 0), (1, 0)]]

K = int(input())
score = 0
for _ in range(K):
    t, y, x = map(int, input().split())
    block1 = []
    block2 = []
    for dy, dx in block_delta[t]:
        block1.append((y + dy, x + dx))
        block2.append((x + dx, 3 - y - dy))

    go(block1, green)
    go(block2, blue)

tot = sum(map(sum, green)) + sum(map(sum, blue))

print(score)
print(tot)
