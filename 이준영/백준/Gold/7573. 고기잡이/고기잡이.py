
N, I, M = map(int, input().split())

fish = []
row = set()
col = set()
for _ in range(M):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    fish.append((a, b))
    row.add(a)
    col.add(b)

mx_cnt = 0
for sy in row:
    for sx in col:
        for c_len in range(1, I // 2):
            cnt = 0
            for y, x in fish:
                if sy <= y <= sy + c_len and sx <= x <= sx + I // 2 - c_len:
                    cnt += 1

            mx_cnt = max(mx_cnt, cnt)

print(mx_cnt)
