import sys

input = sys.stdin.readline


def left(state, length, tmp_mx):
    b = [[0 for _ in range(length)] for _ in range(length)]
    check = False
    for i in range(length):
        stack = []
        for j in range(length):
            k = 0
            a = state[i][j]

            if a != 0:
                if not stack:
                    stack.append(a)
                    if j > 0:
                        check = True
                elif a == stack[-1]:
                    stack[-1] = 2 * a
                    tmp_mx = max(tmp_mx, 2 * a)
                    stack.append(0)
                    check = True
                else:
                    stack.append(a)
                    if len(stack) != j + 1:
                        check = True

        for j in stack:
            if j != 0:
                b[i][k] = j
                k += 1
    return b, tmp_mx, check


def right(state, length, tmp_mx):
    b = [[0 for _ in range(length)] for _ in range(length)]
    check = False
    for i in range(length):
        stack = []
        for j in range(length - 1, -1, -1):
            k = length - 1
            a = state[i][j]
            if a != 0:
                if not stack:
                    stack.append(a)
                    if j < length - 1:
                        check = True

                elif a == stack[-1]:
                    stack[-1] = 2 * a
                    check = True
                    tmp_mx = max(tmp_mx, 2 * a)
                    stack.append(0)
                else:
                    stack.append(a)
                    if (len(stack) + j) != length:
                        check = True
        for j in stack:
            if j != 0:
                b[i][k] = j
                k -= 1
    return b, tmp_mx, check


def up(state, length, tmp_mx):
    b = [[0 for _ in range(length)] for _ in range(length)]
    check = False
    for j in range(length):
        stack = []
        for i in range(length):
            k = 0
            a = state[i][j]
            if a != 0:
                if not stack:
                    stack.append(a)
                    if i > 0:
                        check = True
                elif a == stack[-1]:
                    stack[-1] = 2 * a
                    check = True
                    tmp_mx = max(tmp_mx, 2 * a)
                    stack.append(0)
                else:
                    stack.append(a)
                    if len(stack) != i + 1:
                        check = True
        for i in stack:
            if i != 0:
                b[k][j] = i
                k += 1
    return b, tmp_mx, check


def down(state, length, tmp_mx):
    b = [[0 for _ in range(length)] for _ in range(length)]
    check = False
    for j in range(length):
        stack = []
        for i in range(length - 1, -1, -1):
            k = length - 1
            a = state[i][j]
            if a != 0:
                if not stack:
                    stack.append(a)
                    if i < length - 1:
                        check = True
                elif a == stack[-1]:
                    stack[-1] = 2 * a
                    check = True
                    tmp_mx = max(tmp_mx, 2 * a)
                    stack.append(0)
                else:
                    stack.append(a)
                    if (len(stack) + i) != length:
                        check = True
        for i in stack:
            if i != 0:
                b[k][j] = i
                k -= 1
    return b, tmp_mx, check


def bt(state, length, count, tmp_mx):
    global mx

    if mx >= tmp_mx * (1 << (10 - count)):
        return

    mx = max(mx, tmp_mx)

    if count == 10:
        return
    else:

        b, t_mx, check = up(state, length, tmp_mx)
        if check:
            bt(b, length, count + 1, t_mx)

        b, t_mx, check = down(state, length, tmp_mx)
        if check:
            bt(b, length, count + 1, t_mx)

        b, t_mx, check = left(state, length, tmp_mx)
        if check:
            bt(b, length, count + 1, t_mx)

        b, t_mx, check = right(state, length, tmp_mx)
        if check:
            bt(b, length, count + 1, t_mx)


n = int(input())
d = [0] * n
for i in range(n):
    d[i] = list(map(int, input().split()))

mx = 0
for i in range(n):
    for j in range(n):
        mx = max(mx, d[i][j])

bt(d, n, 0, mx)
print(mx)
