N = int(input())
arr = list(map(int, input().split()))
idx = [0] * N

lst = [arr[0]]

for i in range(1, N):
    start = 0
    end = len(lst) - 1
    t = arr[i]
    if lst[-1] < t:
        lst.append(t)
        idx[i] = end + 1
    elif lst[0] >= t:
        lst[0] = t
        idx[i] = 0
    else:
        while end - start > 1:
            mid = (start + end) // 2

            if lst[mid] < t:
                start = mid
            else:
                end = mid

        lst[end] = t
        idx[i] = end

l = len(lst)
ans = [0] * l
print(l)
l = l - 1

for i in range(N - 1, -1, -1):
    if l == -1:
        break

    if idx[i] == l:
        ans[l] = arr[i]
        l = l - 1

print(*ans)
