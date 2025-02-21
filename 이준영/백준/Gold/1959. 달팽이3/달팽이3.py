N, M = map(int, input().split())

if N > M:
    tmp = (M - 2) // 2
    N = N - 2 * tmp
    M = M - 2 * tmp
    if M == 2:
        y = 2
        x = 1
        l = 3
    else:
        y = N - 1
        x = 2
        l = 5
    print(l + 4 * tmp)
    print(y + tmp, x + tmp)

else:
    tmp = (N - 2) // 2
    N = N - 2 * tmp
    M = M - 2 * tmp

    if N == 2:
        y = 2
        x = 1
        l = 2
    else:
        y = 2
        x = M - 1
        l = 4
    print(l + 4 * tmp)
    print(y + tmp, x + tmp)
