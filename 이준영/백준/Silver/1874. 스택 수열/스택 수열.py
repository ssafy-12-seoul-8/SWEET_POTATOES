n = int(input())
stk = []
cur = 1
result = True
ans = []
num = [int(input()) for _ in range(n)]
for i in range(n):
    if not stk:
        stk.append(cur)
        cur += 1
        ans.append("+")
    while stk[-1] < num[i]:
        stk.append(cur)
        cur += 1
        ans.append("+")
    if stk[-1] == num[i]:
        stk.pop()
        ans.append("-")
    else:
        result = False
        break
if result:
    print("\n".join(ans))
else:
    print("NO")
