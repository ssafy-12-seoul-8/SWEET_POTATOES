import sys

input = sys.stdin.readline


def check(city, possible):
    for i in range(N):
        start = end = 0
        flag = True
        while end < N:
            if city[i][end] == ".":
                end += 1
            elif city[i][end] == "O":
                for j in range(start, end + 1):
                    possible[i][j] = 1
                flag = False
                start = end = end + 1
            else:
                possible[i][end] = 1
                if not flag:
                    for j in range(start, end):
                        possible[i][j] = 1
                flag = True
                start = end = end + 1

        if not flag:
            for j in range(start, end):
                possible[i][j] = 1


N = int(input())
city = [list(input().rstrip()) for _ in range(N)]
possible = [[0] * N for _ in range(N)]
check(city, possible)

t_city = [[0] * N for _ in range(N)]

t_possible = [[0] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        t_city[i][j] = city[j][i]
        t_possible[i][j] = possible[j][i]

check(t_city, t_possible)
for i in range(N):
    for j in range(N):
        city[i][j] = t_city[j][i]
        possible[i][j] = t_possible[j][i]

ans = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if city[i][j] != ".":
            ans[i][j] = city[i][j]
        elif possible[i][j]==0:
            ans[i][j]="B"
        else:
            ans[i][j]="."

for i in range(N):
    print(*ans[i], sep="")
