# 각 파이어볼의 정보를 담을 리스트와 파이어볼들의 이동 후 정보를 담을 3차원 배열을 관리하였다. (arr[y][x]는
# y,x 칸에 도달한 파이어볼의 정보들을 담은 리스트이다.)
# 처음에 파이어볼 리스트를 순회하며 배열에 이동한 파이어볼의 정보를 담았고
# 파이어볼들이 몇개 모였는지에 따라 행동을 달리 하였다.
# 이 떄 임시 파이어볼 리스트에 파이어볼들이 합쳐지고 나눠지는 과정을 담았고 파이어볼 리스트를 이 리스트로 바꾸었다.
n, m, k = map(int, input().split())

dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 1, 1, 1, 0, -1, -1, -1]

lst = [0] * m
for i in range(m):
    x, y, m, s, d = map(int, input().split())
    lst[i] = [x - 1, y - 1, m, s, d]                    # 문제에서는 1,1을 시작으로 하였으나 나는 0,0을 시작으로 하였다.
                                                        # 차후의 나머지 연산을 할 때도 0,0으로 하는게 편하기 때문
for _ in range(k):
    arr = [[[] for _ in range(n)] for _ in range(n)]    # 파이어볼을 쏘고나서의 정보를 담을 배열
    tmp_lst = []
    for y, x, m, s, d in lst:
        y = (y + s * dy[d]) % n
        x = (x + s * dx[d]) % n
        arr[y][x].append((m, s, d))                     # 파이어볼이 도달한 칸에 파이어볼의 정보를 담는다.

    for i in range(n):
        for j in range(n):
            if len(arr[i][j]) == 0:                     # 파이어볼이 없으므로 넘어간다.
                continue
            elif len(arr[i][j]) == 1:                   # 파이어볼이 하나있으므로 분열되지 않으므로 리스트에 그대로 추가한다.
                tmp = arr[i][j][0]
                tmp_lst.append([i, j, tmp[0], tmp[1], tmp[2]])
            else:
                cnt = 0                                 # 파이어볼의 개수(=len(arr[i][j]))
                even = 0                                # 방향을 잘 보면 짝수가 상하좌우, 홀수가 대각선이다. 따라서 상하좌우의 개수를 파악
                speed = 0                               # 속력의 합을 담을 변수
                weight = 0                              # 무게의 합을 담을 변수
                for m, s, d in arr[i][j]:
                    weight += m
                    speed += s
                    cnt += 1
                    if d % 2 == 0:                      # 상하좌우중 하나면 even에 더한다.
                        even += 1

                weight = weight // 5
                speed = speed // cnt
                if even == cnt or even == 0:            # 모든 방향이 모두 상하좌우거나 대각선이면 상하좌우이므로 방향이 짝수들로 분열
                    start = 0
                else:                                   # 그렇지 않으면 홀수들로 분열
                    start = 1

                if weight == 0:                         # 물론 무게가 0이면 안해도 된다.
                    continue
                else:
                    for k in range(4):                  # k*2+start 는 start에 따라 0,2,4,6 혹은 1,3,5,7이 된다.
                        tmp_lst.append([i, j, weight, speed, k * 2 + start])

    lst = tmp_lst

tot = 0
for y, x, m, s, d in lst:                               # 파이어볼 리스트의 정보를 돌며 무게를 더하면 끝
    tot += m
print(tot)
