# 합 : 세 속성이 모두 같거나 모두 다름 (각 속성별 적용)
# 결 : 합이 더 없는 거 같아요...(+3 or -1)
# 결로 2번이상 점수 못얻음
shape = {'CIRCLE': 0, 'TRIANGLE': 1, 'SQUARE': 2}
i_color = {'YELLOW': 0, 'RED': 1, 'BLUE': 2}
o_color = {'GRAY': 0, 'WHITE': 1, 'BLACK': 2}

arr = [0] * 9
for i in range(9):
    s, c, b = input().split()
    arr[i] = [shape[s], i_color[c], o_color[b]]

ans = {}
for i in range(7):
    for j in range(i + 1, 8):
        for k in range(j + 1, 9):
            flag = True
            for l in range(3):
                if not ((arr[i][l] == arr[j][l] == arr[k][l]) or (arr[i][l] + arr[j][l] + arr[k][l] == 3)):
                    flag = False
                    break
            if flag:
                ans[(i, j, k)] = 0
                ans[(i, k, j)] = 0
                ans[(j, i, k)] = 0
                ans[(j, k, i)] = 0
                ans[(k, i, j)] = 0
                ans[(k, j, i)] = 0

l = len(ans)
n = int(input())
score = 0
check = 0
for _ in range(n):
    s = list(input().split())
    if s[0] == "H":
        a = int(s[1]) - 1
        b = int(s[2]) - 1
        c = int(s[3]) - 1
        if (a, b, c) not in ans:
            score -= 1
        elif ans[(a, b, c)] == 1:
            score -= 1
        else:
            score += 1
            ans[(a, b, c)] = 1
            ans[(a, c, b)] = 1
            ans[(b, a, c)] = 1
            ans[(b, c, a)] = 1
            ans[(c, a, b)] = 1
            ans[(c, b, a)] = 1
            l -= 6

    else:
        if l == 0 and check == 0:
            score += 3
            check += 1
        else:
            score -= 1

print(score)
