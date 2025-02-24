# 체크해야 될건 각각의 칸이 모두 한번씩 지났으며 나이트로 이동이 가능한지이다. (맨 마지막에서 처음 위치로 오는 것도 고려해야 함)
# 따라서 visited로 방문을 관리하였고 A~F는 ord를 활용하여 1~6으로 만들었다. (가로줄도 1~6이라 이렇게 했다.)
visited = [[0] * 7 for _ in range(7)]
flag = True
lst = []
for _ in range(36):
    s = input()
    y = ord(s[0]) - ord("A") + 1
    x = int(s[1])
    lst.append((y, x))

visited[lst[0][0]][lst[0][1]] = 1
for i in range(35):
    y1, x1 = lst[i]
    y2, x2 = lst[i + 1]

    if visited[y2][x2] == 1:
        flag = False
        break

    visited[y2][x2] = 1
    if abs(y1 - y2) == 2:
        if abs(x1 - x2) != 1:
            flag = False
            break
    elif abs(y1 - y2) == 1:
        if abs(x1 - x2) != 2:
            flag = False
            break
    else:
        flag = False
        break

y1, x1 = lst[0]
y2, x2 = lst[35]

if abs(y1 - y2) == 2:
    if abs(x1 - x2) != 1:
        flag = False
elif abs(y1 - y2) == 1:
    if abs(x1 - x2) != 2:
        flag = False
else:
    flag = False

if flag:
    print("Valid")
else:
    print("Invalid")