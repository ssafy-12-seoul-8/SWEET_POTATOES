H, W = map(int, input().split())
lst = list(map(int, input().split()))
cnt = 0
for i in range(1, W - 1):
    left = max(lst[:i])
    right = max(lst[i + 1:])
    cnt += max(min(left, right) - lst[i], 0)
print(cnt)
