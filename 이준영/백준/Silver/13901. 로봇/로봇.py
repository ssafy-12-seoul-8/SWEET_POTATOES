# 11:23~
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

R, C = map(int, input().split())
visited = [[False] * C for _ in range(R)]
k = int(input())
for _ in range(k):
    a, b = map(int, input().split())
    visited[a][b] = True

y, x = map(int, input().split())
visited[y][x] = True

tmp = list(map(int, input().split()))
s = [i - 1 for i in tmp]
st = set([])

for i in s:
    st.add(i)

cur = 0
l = len(s)

while True:

    ny = y + dir[s[cur]][0]
    nx = x + dir[s[cur]][1]
    if 0 <= ny < R and 0 <= nx < C and not visited[ny][nx]:
        visited[ny][nx] = True
        y = ny
        x = nx
        continue
    check = False
    for k in st:
        ny = y + dir[k][0]
        nx = x + dir[k][1]
        if 0 <= ny < R and 0 <= nx < C and not visited[ny][nx]:
            check = True
            break
    if check:
        cur = (cur + 1) % l
        continue
    else:
        break
print(y, x)
