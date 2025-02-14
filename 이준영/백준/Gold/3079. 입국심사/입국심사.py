# 입국 시간에 대한 이분 탐색
# 시간이 정해져 있을 떄 각 심사대에서 받을 수 있는 사람의 양이 정해져 있기에 다 더해서 M을 더하면 충분한 시간인 것이다.
def check(k):
    tot = 0
    for i in range(N):
        tot += k // T[i]

    if tot >= M:
        return True

    return False


N, M = map(int, input().split())
T = [int(input()) for _ in range(N)]

start = 0
end = int(1e18) + 1

while end - start > 1:
    mid = (start + end) // 2

    if check(mid):
        end = mid
    else:
        start = mid

print(end)
