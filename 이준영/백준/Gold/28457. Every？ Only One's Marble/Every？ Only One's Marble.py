def go(num):
    global money, cur_idx, G_idx, remain, G_idx, donation

    cur_idx += num
    if cur_idx >= 4 * n - 4:
        money += W * cur_idx // (4 * n - 4)
        cur_idx = cur_idx % (4 * n - 4)

    tmp = board_map[cur_idx][0]
    if tmp == "S":
        return

    if tmp == "L":
        if money >= board_map[cur_idx][1]:
            money -= board_map[cur_idx][1]
            board_map[cur_idx][1] = 0

        return

    if tmp == "G":
        a, b = Gold_card[G_idx]
        if a == 1:
            money += b
        elif a == 2:
            money -= b
        elif a == 3:
            donation += b
            money -= b
        else:
            go(b)

        G_idx = (G_idx + 1) % G
        return

    if tmp == "D":
        remain = 3
        return

    if tmp == "M":
        money += donation
        donation = 0
        return

    if tmp == "T":
        money += W
        cur_idx = 0
        return


n, money, W, G = map(int, input().split())
G_idx = 0
cur_idx = 0
remain = 0
donation = 0
Gold_card = []
board_map = [[] for _ in range(4 * n - 4)]
for _ in range(G):
    a, b = map(int, input().split())
    Gold_card.append((a, b))

board_map[0] = "S"
board_map[n - 1] = "D"
board_map[2 * n - 2] = "M"
board_map[3 * n - 3] = "T"
k = 0
for _ in range(4 * n - 8):
    lst = input().split()
    while board_map[k]:
        k += 1

    if lst[0] == "L":
        a = int(lst[1])
        board_map[k] = [lst[0], a]
    else:
        board_map[k] = ["G"]

I = int(input())
dice = [list(map(int, input().split())) for _ in range(I)]

result = "WIN"
for turn in range(I):
    a, b = dice[turn]
    if remain > 0:
        if a == b:
            remain = 0
        else:
            remain -= 1
        continue

    go(a + b)
    if money < 0:
        result = "LOSE"
        break

for i in range(4 * n - 4):
    if board_map[i][0] == "L" and board_map[i][1] > 0:
        result = "LOSE"
        break

print(result)
