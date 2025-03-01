import sys

input = sys.stdin.readline


def check(mid):
    cnt = 0
    cur = 0
    sm = 0
    i = 1
    while i < n + 2:

        if sm + (arr[i] - arr[i - 1]) < mid:
            sm = sm + (arr[i] - arr[i - 1])
            cnt += 1
            i += 1
        else:
            sm = 0
            i += 1

    if sm > 0:
        cnt += 1
    if cnt <= m:
        return True
    return False


d, n, m = map(int, input().split())
arr = [int(input()) for _ in range(n)]
arr.extend([0, d])
arr.sort()

start = 0
end = d + 1

while end - start > 1:
    mid = (start + end) // 2

    if check(mid):
        start = mid
    else:
        end = mid

print(start)
