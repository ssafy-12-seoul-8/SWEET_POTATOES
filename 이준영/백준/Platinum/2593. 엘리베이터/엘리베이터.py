from collections import deque


def check(num, ele_num):
    a, b = ele[ele_num]
    if num >= a and (num - a) % b == 0:
        return True
    return False


def can_change(num1, num2):
    b1, a1 = ele[num1]
    b2, a2 = ele[num2]
    if a1 < a2:
        a1, a2 = a2, a1
        b1, b2 = b2, b1
    x, y, a3 = gcd(a1, a2)
    if (b1 - b2) % a3 != 0:
        return False

    lcd = a1 * a2 // a3

    tmp = b1 + a1 * (b2 - b1) // a3 * x
    tmp = tmp % lcd
    mx = max(b1, b2)
    value = max(0, (mx - tmp - 1) // lcd + 1)
    tmp = tmp + lcd * value
    if tmp <= N:
        return True
    return False


def gcd(a, b):
    if a % b == 0:
        return 0, 1, b

    x, y, d = gcd(b, a % b)
    return y, x - y * (a // b), d


N, M = map(int, input().split())
ele = [list(map(int, input().split())) for _ in range(M)]
A, B = map(int, input().split())
mn = M + 1
dq = deque([])
visited = [-1] * M

for i in range(M):
    if check(A, i):
        visited[i] = i
        dq.append(i)

last = -1

while dq:
    cur = dq.popleft()
    if check(B, cur):
        last = cur
        break

    for i in range(M):
        if visited[i] == -1 and can_change(cur, i):
            visited[i] = cur
            dq.append(i)

if last == -1:
    print(-1)
else:
    ans = [last]
    while visited[last] != last:
        last = visited[last]
        ans.append(last)

    print(len(ans))
    for i in ans[::-1]:
        print(i + 1)
