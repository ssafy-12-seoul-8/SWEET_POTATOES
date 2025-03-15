def calc(a, b, op):
    if op == 0:
        return a + b
    return a - b


def btk(cur, l_op, l_res, c_res):
    if cur == 2 * N - 1:
        if calc(l_res, c_res, l_op) == 0:
            print("".join(idx))
        return

    idx[cur] = " "
    btk(cur + 2, l_op, l_res, c_res * 10 + int(idx[cur + 1]))
    idx[cur] = "+"
    btk(cur + 2, 0, calc(l_res, c_res, l_op), int(idx[cur + 1]))
    idx[cur] = "-"
    btk(cur + 2, 1, calc(l_res, c_res, l_op), int(idx[cur + 1]))
    


T = int(input())
for _ in range(T):

    N = int(input())
    idx = [0] * (2 * N - 1)
    for i in range(1, N + 1):
        idx[2 * i - 2] = str(i)

    btk(1, 0, 0, 1)

    print()
