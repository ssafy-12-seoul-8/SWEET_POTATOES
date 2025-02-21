N, M = map(int, input().split())

if N > M:
    tmp = (M - 2) // 2
    N = N - 2 * tmp
    M = M - 2 * tmp
    if M == 2:
        l = 3
    else:
        l = 5
    print(l + 4 * tmp)


else:
    tmp = (N - 2) // 2
    N = N - 2 * tmp
    M = M - 2 * tmp

    if N == 2:
        l = 2
    else:
        l = 4
    print(l + 4 * tmp)

