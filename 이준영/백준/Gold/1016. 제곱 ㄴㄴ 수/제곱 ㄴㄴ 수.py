import math

mn, mx = map(int, input().split())
a = int(math.sqrt(mx))
prime = [0] * (a + 1)
lst = []
for i in range(2, int(math.sqrt(a)) + 1):
    if prime[i] == 0:
        for j in range(i, a // i + 1):
            prime[i * j] = 1

for i in range(2, a + 1):
    if prime[i] == 0:
        lst.append(i)

no_square = [0] * (mx - mn + 1)

for i in lst:
    tmp = i * i
    for j in range((mn - 1) // tmp + 1, mx // tmp + 1):
        no_square[tmp * j - mn] = 1

cnt = 0
for i in range(mx - mn + 1):
    if no_square[i] == 0:
        cnt += 1

print(cnt)


