N = int(input())
M = int(input())
act = [0] * M
wall = [True] * N
for i in range(M):
    act[i] = list(map(int, input().split()))

for i in range(1, N):
    for j in range(M):
        if act[j][0] <= i < act[j][1]:
            wall[i] = False
            break
count = 1
for i in range(1,N):
    if wall[i]:
        count+=1
print(count)
