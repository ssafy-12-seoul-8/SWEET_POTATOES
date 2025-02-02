# 첫 좌표가 일반적인 좌표형면에서 x좌표, 두 번째가 y좌표
dct = {"A": 1, "B": 2, "C": 3, "D": 4, "E": 5, "F": 6, "G": 7, "H": 8}
dct2 = {}
for i, j in dct.items():
    dct2[j] = i

dir = {"R": (1, 0), "L": (-1, 0), "B": (0, -1), "T": (0, 1), "RT": (1, 1), "LT": (-1, 1), "RB": (1, -1), "LB": (-1, -1)}

k, r, n = input().split()
n = int(n)
king = [dct[k[0]], int(k[1])]
rock = [dct[r[0]], int(r[1])]

for _ in range(n):
    d = input()
    nx = king[0] + dir[d][0]
    ny = king[1] + dir[d][1]
    if 1 <= nx <= 8 and 1 <= ny <= 8:
        if nx == rock[0] and ny == rock[1]:
            px = rock[0] + dir[d][0]
            py = rock[1] + dir[d][1]
            if 1 <= px <= 8 and 1 <= py <= 8:
                king = [nx, ny]
                rock = [px, py]
            else:
                continue
        else:
            king = [nx, ny]
    else:
        continue

print(f'{dct2[king[0]]}{king[1]}\n{dct2[rock[0]]}{rock[1]}')
