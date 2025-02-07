L, N, T = map(int, input().split())
box = [[] for _ in range(L + 1)]
for i in range(N):
    a, b = input().split()
    a = int(a)
    box[a] = b

cnt = 0

for i in range(T):
    box2 = [[] for _ in range(L + 1)]
    for j in range(L + 1):
        for k in box[j]:
            if j == 0 and k == "L":
                box2[1].append("R")
            elif j == L and k == "R":
                box2[L - 1].append("L")
            elif k == "L":
                box2[j - 1].append("L")
            else:
                box2[j + 1].append("R")
    for j in range(L + 1):
        if len(box2[j]) == 2:
            cnt += 1
    box = box2
print(cnt)
