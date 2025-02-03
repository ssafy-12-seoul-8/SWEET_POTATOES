N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

location_a = [[] for _ in range(101)]
for i in range(N):
    location_a[A[i]].append(i)

lst = []
cur_A = 0
cur_B = 0
for i in range(100,0,-1):
    if not location_a[i]:
        continue
    for j in location_a[i]:
        if cur_A>j:
            continue
        for k in range(cur_B,M):
            if B[k] == i:
                lst.append(i)
                cur_B = k+1
                cur_A = j+1
                break
print(len(lst))
print(*lst)    