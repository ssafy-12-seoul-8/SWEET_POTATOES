N = int(input())
lst = list(map(int, input().split()))
ans = []
for i in range(N):
    if not ans:
        ans.append(lst[i])
    elif ans[-1] < lst[i]:
        ans.append(lst[i])
    elif ans[0] >= lst[i]:
        ans[0] = lst[i]
    else:
        start = 0
        end = len(ans) - 1
        while end - start >= 2:
            mid = (start + end) // 2
            if ans[mid] < lst[i]:
                start = mid
            else:
                end = mid
        ans[end] = lst[i]
print(len(ans))
