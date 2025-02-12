import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
act = [0] * M

for i in range(M):
    act[i] = list(map(int, input().split()))

act.sort()

cnt = 1
end = 1
for i in range(M):
    if act[i][0] <= end:
        end = max(end, act[i][1])
    else:
        cnt += (act[i][0] - end)
        end = act[i][1]

cnt = cnt + N - end
print(cnt)
