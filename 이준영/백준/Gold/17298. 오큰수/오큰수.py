N = int(input())
lst = list(map(int, input().split()))
stk = []
ans = [-1] * N
for i in range(N):
    if not stk:
        stk.append(i)
    else:
        while stk and lst[stk[-1]]<lst[i]:
            a = stk.pop()
            ans[a] = lst[i]
        stk.append(i)
print(*ans)
