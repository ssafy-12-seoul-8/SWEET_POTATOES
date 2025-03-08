def btk(l, cur):
    global sm, ans
    if ans != 0:
        return

    if l == i:

        sm += 1
        if sm == N:
            for k in range(i):
                ans = ans * 10 + idx[k]
        return

    for k in range(cur):
        idx[l] = k
        btk(l + 1, k)


K = [0, 9, 45, 120, 210, 252, 210, 120, 45, 10, 1]
N = int(input())

sm = 0
if N == 0:
    print(0)
elif N <= 9:
    print(N)
elif N >= 1023:
    print(-1)
else:
    ans = 0
    for i in range(1, 11):
        if N > sm + K[i]:
            sm = sm + K[i]
            continue
        else:
            idx = [0] * i
            for j in range(i - 1, 10):
                idx[0] = j
                btk(1, j)
            break
    print(ans)
