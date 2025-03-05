import sys

input = sys.stdin.readline
N, M, S = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(N)]
my_id = input().rstrip()
tot_cnt = [0] * 26
id_cnt = [0] * 26
pos = 2501
loc = [[] for _ in range(26)]
for i in range(N):
    for j in range(M):
        tmp = ord(arr[i][j]) - ord('a')
        tot_cnt[tmp] += 1
        loc[tmp].append((i, j))

for i in my_id:
    id_cnt[ord(i) - ord('a')] += 1

for i in range(26):
    if id_cnt[i] == 0:
        continue

    tmp = tot_cnt[i] // id_cnt[i]
    pos = min(pos, tmp)

ans = []
y = 0
x = 0
for _ in range(pos):
    for i in my_id:
        tmp = ord(i) - ord('a')
        ny, nx = loc[tmp].pop()
        if y > ny:
            ans.extend("U" * (y - ny))
        elif y < ny:
            ans.extend("D" * (ny - y))
        if x > nx:
            ans.extend("L" * (x - nx))
        elif x < nx:
            ans.extend("R" * (nx - x))
        ans.append("P")
        y = ny
        x = nx

if y < N - 1:
    ans.extend("D" * (N - 1 - y))
if x < M - 1:
    ans.extend("R" * (M - 1 - x))

print(pos, len(ans))
print("".join(ans))
