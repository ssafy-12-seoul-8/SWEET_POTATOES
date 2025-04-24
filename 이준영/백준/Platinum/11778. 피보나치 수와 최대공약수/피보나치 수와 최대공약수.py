def f(n):
    if n == 1:
        return [0, 1, 1, 1]

    C = f(n // 2)
    C = mat_multi(C, C)
    if n % 2 == 1:
        C = mat_multi(C, [0, 1, 1, 1])

    return C


def fibo(n):
    A = f(n)
    return A[1]


def mat_multi(A, B):
    C = [0] * 4
    C[0] = (A[0] * B[0] + A[1] * B[2]) % mod
    C[1] = (A[0] * B[1] + A[1] * B[3]) % mod
    C[2] = (A[2] * B[0] + A[3] * B[2]) % mod
    C[3] = (A[2] * B[1] + A[3] * B[3]) % mod
    return C


def find_gcd(a, b):
    if a % b == 0:
        return b

    return find_gcd(b, a % b)


mod = 1000000007
N, M = map(int, input().split())
if N < M:
    N, M = M, N

g = find_gcd(N, M)
print(fibo(g))
