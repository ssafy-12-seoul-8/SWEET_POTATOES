def myprint():
    for i in range(N):
        for j in range(M):
            if (i, j) == (y, x):
                print("@", end="")
            else:
                print(board[i][j], end="")
        print()

    print(f'Passed Turns : {turn + 1}')
    print(f'LV : {level}')
    print(f"HP : {cur_hp}/{max_hp}")
    print(f'ATT : {attack}+{add_attack}')
    print(f'DEF : {defense}+{add_defense}')
    print(f'EXP : {cur_exp}/{level * 5}')
    # print("-" * 100)


def fight(first_attack, tot_attack, tot_def, hp):
    if first_attack == 0:
        first = 0
    else:
        first = max(1, tot_attack * first_attack - tot_def)

    if hp <= first:
        return 1

    hp = hp - first
    return 2 + (hp - 1) // max(1, (tot_attack - tot_def))


def get(exp):
    global cur_exp, level, cur_hp, max_hp, attack, defense

    cur_exp += exp
    if cur_exp < level * 5:
        return

    level += 1
    cur_exp = 0
    cur_hp = max_hp = max_hp + 5
    attack += 2
    defense += 2


import sys

input = sys.stdin.readline


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


N, M = map(int, input().split())

board = [list(input().rstrip()) for _ in range(N)]

command = list(input().rstrip())
direction = {"L": (0, -1), "U": (-1, 0), "R": (0, 1), "D": (1, 0)}

K = 0
L = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == "@":
            y, x = i, j
            sy, sx = i, j
            board[i][j] = "."
        elif board[i][j] == "&":
            K += 1
        elif board[i][j] == "M":
            K += 1
        elif board[i][j] == "B":
            L += 1

monster = {}
for _ in range(K):
    R, C, S, W, A, H, E = input().rstrip().split()
    R = int(R)
    C = int(C)
    W = int(W)
    A = int(A)
    H = int(H)
    E = int(E)

    monster[(R - 1, C - 1)] = [S, W, A, H, E]

item_box = {}
for _ in range(L):
    R, C, T, S = input().rstrip().split()
    R = int(R)
    C = int(C)
    if T in {"W", "A"}:
        S = int(S)

    item_box[(R - 1, C - 1)] = [T, S]

cur_hp, max_hp = 20, 20
attack, defense, add_attack, add_defense = 2, 2, 0, 0
cur_exp = 0
level = 1
jew = set([])

result = "Press any key to continue."
for turn in range(len(command)):
    dy, dx = direction[command[turn]]
    ny = y + dy
    nx = x + dx
    if not oob(ny, nx) and board[ny][nx] != "#":
        y, x = ny, nx

    if board[y][x] == ".":
        continue

    if board[y][x] == "B":
        T, S = item_box[(y, x)]
        if T == "W":
            add_attack = S
        elif T == "A":
            add_defense = S
        else:
            if len(jew) < 4 and S not in jew:
                jew.add(S)

        board[y][x] = "."
        continue

    if board[y][x] == "^":
        if "DX" in jew:
            damage = 1
        else:
            damage = 5

        cur_hp -= damage
        if cur_hp <= 0:
            if "RE" in jew:
                cur_hp = max_hp
                y, x = sy, sx
                jew.remove("RE")
            else:
                cur_hp = 0
                result = "YOU HAVE BEEN KILLED BY SPIKE TRAP.."
                y, x = -1, -1
                break
        continue

    if board[y][x] == "&":
        name, att, df, hp, exp = monster[(y, x)]
        if "CO" not in jew:
            first_attack = 1
        elif "DX" not in jew:
            first_attack = 2
        else:
            first_attack = 3

        my_turn = fight(first_attack, attack + add_attack, df, hp)
        op_turn = fight(1, att, defense + add_defense, cur_hp)
        if my_turn <= op_turn:
            board[y][x] = "."
            cur_hp -= max(1, att - defense - add_defense) * (my_turn - 1)
            if "HR" in jew:
                cur_hp = min(cur_hp + 3, max_hp)
            if "EX" in jew:
                exp = exp * 6 // 5

            get(exp)

        else:
            if "RE" in jew:
                cur_hp = max_hp
                y, x = sy, sx
                jew.remove("RE")
            else:
                cur_hp = 0
                result = "YOU HAVE BEEN KILLED BY " + name + ".."
                y, x = -1, -1
                break

        continue

    if board[y][x] == "M":
        name, att, df, hp, exp = monster[(y, x)]
        if "CO" not in jew:
            first_attack = 1
        elif "DX" not in jew:
            first_attack = 2
        else:
            first_attack = 3

        op_first_attack = 1
        if "HU" in jew:
            cur_hp = max_hp
            op_first_attack = 0

        my_turn = fight(first_attack, attack + add_attack, df, hp)
        op_turn = fight(op_first_attack, att, defense + add_defense, cur_hp)
        if my_turn <= op_turn:
            board[y][x] = "."
            if op_first_attack == 0:
                first_damage = 0
            else:
                first_damage = max(1, att - defense - add_defense)
            if my_turn >= 2:
                cur_hp = cur_hp - first_damage - (my_turn - 2) * max(1, att - defense - add_defense)
            if "HR" in jew:
                cur_hp = min(cur_hp + 3, max_hp)
            if "EX" in jew:
                exp = int(exp * 1.2)
            get(exp)
            result = "YOU WIN!"
            break
        else:
            if "RE" in jew:
                cur_hp = max_hp
                y, x = sy, sx
                jew.remove("RE")
            else:
                cur_hp = 0
                result = "YOU HAVE BEEN KILLED BY " + name + ".."
                y, x = -1, -1
                break

        continue
myprint()
print(result)
