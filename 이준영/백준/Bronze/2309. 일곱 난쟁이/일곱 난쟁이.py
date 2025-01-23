height=[0]*9
for i in range(9):
    height[i] = int(input())

for i in range(512):
    result = []
    count = 0
    total_height = 0
    for j in range(9):
        if not ((i&(1<<j))==0):
            count += 1
            total_height += height[j]

    if count==7 and total_height==100:
        for j in range(9):
            if not ((i & (1 << j)) == 0):
                result.append(height[j])
        break
result.sort()
for i in range(7):
    print(result[i])