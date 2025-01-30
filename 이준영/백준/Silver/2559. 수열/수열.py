N, K = map(int, input().split())
lst = list(map(int, input().split()))

cur_sum = 0
for i in range(K):
    cur_sum += lst[i]
max_sum = cur_sum
for i in range(K, N):
    cur_sum += (lst[i] - lst[i - K])
    max_sum = max(max_sum, cur_sum)
print(max_sum)
