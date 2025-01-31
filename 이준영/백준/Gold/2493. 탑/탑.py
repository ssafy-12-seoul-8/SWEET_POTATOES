N = int(input())
lst= [0]
lst.extend(list(map(int,input().split())))
stk = []
ans = [0] * (N+1)
for i in range(N,0,-1):
    if not stk:
        stk.append(i)
    else:
        while stk and lst[stk[-1]] < lst[i]:
            a = stk.pop()
            ans[a] = i
        stk.append(i)
print(*ans[1:])


