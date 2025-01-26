arr = [[0] * 10 for _ in range(10)]
dy = [1, 1, 1, 0]
dx = [0, 1, -1, 1]
check = 0
for i in range(10):
    arr[i] = list(input())

for i in range(10):
    for j in range(10):
        for k in range(4):
            x_count = 0
            o_check = False
            tot_count = 0
            for l in range(-2,3):
                ny = i + dy[k] * l
                nx = j + dx[k] * l
                if (0 <= ny < 10 and 0 <= nx < 10):
                    tot_count +=1
                    if arr[ny][nx] == 'X':
                        x_count += 1
                    elif arr[ny][nx] == 'O':
                        o_check = True
                        break
            if x_count == 4 and (not o_check) and tot_count ==5:
                check = 1
                break
        if check == 1:
            break
print(check)
