N, K = map(int, input().split())
if K * (K + 1) > 2 * N:
    print(-1)
else:
    if K % 2 == 0:
        tmp = K // 2
        if N % tmp == 0 and (N // tmp) % 2 == 1:
            print(K - 1)
        else:
            print(K)
    else:
        if N % K == 0:
            print(K - 1)
        else:
            print(K)
