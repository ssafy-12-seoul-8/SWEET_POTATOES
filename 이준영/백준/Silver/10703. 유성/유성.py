R, S = map(int, input().split())
arr = [list(input()) for _ in range(R)]
ans = [["."] * S for _ in range(R)]
mn = 3001
for j in range(S):
    gro = R - 1
    for i in range(R):
        if arr[i][j]=="#":
            gro = i
            break
    st = gro - 1
    while st >= 0 and arr[st][j] != "X":
        st -= 1
    if st == -1:
        continue
    mn = min(mn, gro - st - 1)
for i in range(R):
    for j in range(S):
        if arr[i][j] == "X":
            ans[i + mn][j] = "X"
        elif arr[i][j] == "#":
            ans[i][j] = "#"
        else:
            continue

for i in range(R):
    print(*ans[i], sep="")
