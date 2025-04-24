def f(n):
    if n == 1:
        return [4, -1, 1, 0]

    C = f(n // 2)
    C = mat_multi(C, C)
    if n % 2 == 1:
        C = mat_multi(C, [4, -1, 1, 0])

    return C


def count(n):
    A = f(n)
    return (A[2] * 3 + A[3]) % mod


def mat_multi(A, B):
    C = [0] * 4
    C[0] = (A[0] * B[0] + A[1] * B[2]) % mod
    C[1] = (A[0] * B[1] + A[1] * B[3]) % mod
    C[2] = (A[2] * B[0] + A[3] * B[2]) % mod
    C[3] = (A[2] * B[1] + A[3] * B[3]) % mod
    return C


mod = 1000000007
N = int(input())
if N % 2 == 1:
    print(0)
else:
    print(count(N // 2))
