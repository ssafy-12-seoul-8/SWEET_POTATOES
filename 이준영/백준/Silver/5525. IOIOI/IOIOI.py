N = int(input())
M = int(input())
S = input()

ans = 0
cur = "O"
cur_count = 0
for i in range(M):
    if S[i] == "I":
        if cur == "O":
            cur_count += 1
        else:
            ans += max(0, (cur_count - N))
            cur_count = 1
        cur = "I"
    else:
        if cur == "O":
            ans += max(0, (cur_count - N))
            cur_count = 0
        cur = "O"
ans += max(0, (cur_count - N))
print(ans)
