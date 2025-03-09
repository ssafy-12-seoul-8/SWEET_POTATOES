import sys

input = sys.stdin.readline


def btk(y, x, lst):
    if x == C - 1:
        for s_y, s_x in lst:
            arr[s_y][s_x] = 'x'
        return 1

    for tmp in (y - 1, y, y + 1):
        if 0 <= tmp < R and arr[tmp][x + 1] == '.':
            lst.append((tmp, x + 1))
            res = btk(tmp, x + 1, lst)
            lst.pop()
            if res == 1:
                return 1
            arr[tmp][x + 1] = 'x'
    for s_y, s_x in lst:
        arr[s_y][s_x] = 'x'
    return 0


R, C = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(R)]  # .은 0, x는 1

mx = 0
for i in range(R):
    mx += btk(i, 0, [])

print(mx)
