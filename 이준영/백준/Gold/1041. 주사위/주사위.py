N = int(input())
lst = list(map(int, input().split()))

if N == 1:
    print(sum(lst) - max(lst))
else:
    sm1 = min(lst)
    sm2 = 101
    for i in range(5):
        for j in range(i + 1, 6):
            if i + j == 5:
                continue
            sm2 = min(sm2, lst[i] + lst[j])

    sm3 = 151
    for i in range(4):
        for j in range(i + 1, 5):
            for k in range(j + 1, 6):
                if i + j == 5 or i + k == 5 or j + k == 5:
                    continue
                sm3 = min(sm3, lst[i] + lst[j] + lst[k])
    ans = sm1 * (5 * N ** 2 - 16 * N + 12) + sm2 * (8 * N - 12) + sm3 * 4
    print(ans)
