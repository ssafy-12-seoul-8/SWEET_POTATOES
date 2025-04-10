import sys
sys.setrecursionlimit(100000)
def btk(enemy_cnt, flag, lst):
    global ans, t_flag
    if t_flag:
        return

    if enemy_cnt == 0:
        t_flag = True
        ans = lst[:]
        return

    # 모독이나 써볼까
    if not flag and hp_cnt[1] > 0:
        lst.append((-1, -1))
        k = 2

        # 얼만큼 퍼지는데
        while True:
            if hp_cnt[k] == 0:
                break
            k += 1

        # 아군 공격당함
        for i in range(1, N + 1):
            hp_cnt[max(0, mine[i][1])] -= 1
            mine[i][1] -= k
            hp_cnt[max(0, mine[i][1])] += 1

        t_cnt = 0
        for i in range(1, M + 1):
            hp = enemy[i][1]
            if 0 < hp <= k:
                t_cnt += 1
            hp_cnt[max(0, enemy[i][1])] -= 1
            enemy[i][1] -= k
            hp_cnt[max(0, enemy[i][1])] += 1

        btk(enemy_cnt - t_cnt, 1, lst)

        for i in range(1, N + 1):
            hp_cnt[max(0, mine[i][1])] -= 1
            mine[i][1] += k
            hp_cnt[max(0, mine[i][1])] += 1

        for i in range(1, M + 1):
            hp_cnt[max(0, enemy[i][1])] -= 1
            enemy[i][1] += k
            hp_cnt[max(0, enemy[i][1])] += 1
        lst.pop()

    for i in range(1, N + 1):
        if attack[i] == 0 and mine[i][1] > 0:
            a1, h1 = mine[i]
            attack[i] = 1
            for j in range(1, M + 1):
                if enemy[j][1] > 0:
                    a2, h2 = enemy[j]
                    hp_cnt[h1] -= 1
                    hp_cnt[h2] -= 1
                    mine[i][1] -= a2
                    enemy[j][1] -= a1
                    hp_cnt[max(0, mine[i][1])] += 1
                    hp_cnt[max(0, enemy[j][1])] += 1
                    t_cnt = 0
                    if enemy[j][1] <= 0:
                        t_cnt = 1
                    lst.append((i, j))
                    btk(enemy_cnt - t_cnt, flag, lst)
                    lst.pop()
                    hp_cnt[max(0, mine[i][1])] -= 1
                    hp_cnt[max(0, enemy[j][1])] -= 1
                    mine[i][1] += a2
                    enemy[j][1] += a1
                    hp_cnt[h1] += 1
                    hp_cnt[h2] += 1
            attack[i] = 0


N, M = map(int, input().split())
mine = [0] * (N + 1)
enemy = [0] * (M + 1)
hp_cnt = [0] * 14
for i in range(1, N + 1):
    a, b = map(int, input().split())
    mine[i] = [a, b]  # 공, 체
    hp_cnt[b] += 1

for i in range(1, M + 1):
    a, b = map(int, input().split())
    enemy[i] = [a, b]  # 공, 체
    hp_cnt[b] += 1

t_flag = False
ans = []
attack = [0] * (N + 1)

btk(M, 0, [])
if not t_flag:
    print(-1)
else:
    print(len(ans))
    for y, x in ans:
        if y == -1:
            print("use modok")
        else:
            print(f'attack {y} {x}')
