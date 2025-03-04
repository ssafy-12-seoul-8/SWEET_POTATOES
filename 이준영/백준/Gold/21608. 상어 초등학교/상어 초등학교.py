# 문제를 읽었을 때 N^2명의 학생을 규칙에 맞게 순서대로 배치한 후 점수를 계산하면 된다고 생각하였다.
# 배치해야 하는 학생이 정해지면 각 자리에 대해 (인접한 좋아하는 사람의 수, 비어있는 자리의 수)를 계산하여 가장 인접해 있으며
# 가장 비어있는 자리가 많은 곳을 저장하고 배치해주었다. (이 때 반복문을 행번호가 작은 순서대로, 그 이후 열번호가 작은 순서대로
# 돌기 때문에 3번 조건은 쉽게 충족시킬 수 있다.)
N = int(input())
arr = [0] * (N ** 2 + 1)                                            # 각각의 원소는 자기가 좋아하는 사람의 집합이다.
order = [0] * (N ** 2)                                              # 배치해야 하는 학생을 순서대로 저장
dy = [0, 0, 1, -1]  
dx = [1, -1, 0, 0]
ans = [[0] * N for _ in range(N)]                                   # 내가 채우고자 하는 자리 (0은 비어있다는 뜻)
for i in range(N ** 2):
    a, b, c, d, e = map(int, input().split())
    arr[a] = set([b, c, d, e])  
    order[i] = a    

for l in range(N ** 2):
    target = order[l]                                               # 내가 배치해야 하는 학생 번호
    w_y = -1                                                        # 내가 배치하고자 하는 자리의 y좌표
    w_x = -1                                                        # 내가 배치하고자 하는 자리의 x좌표
    w_cnt = -1                                                      # 인접한 좋아하는 사람의 수의 최대값  
    e_cnt = -1                                                      # 비어있는 인접한 칸의 수의 최대값(위가 같을 떄)
    for i in range(N):
        for j in range(N):
            if ans[i][j] != 0:                                      # 비어있지 않으면 못채운다.
                continue
            tw_cnt = 0
            te_cnt = 0
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < N and 0 <= nx < N:
                    if ans[ny][nx] == 0:                            # 비어있으니 더한다.
                        te_cnt += 1
                    elif ans[ny][nx] in arr[target]:                # 내가 좋아하니 더한다.
                        tw_cnt += 1

            if w_cnt < tw_cnt:                                      # 만약 최대값이 갱신되었다면 정보를 모두 바꾼다.
                w_cnt, e_cnt, w_y, w_x = tw_cnt, te_cnt, i, j
            elif w_cnt == tw_cnt and e_cnt < te_cnt:                # 인접한 좋아하는 사람수가 같다면 그 다음 기준 보자
                w_cnt, e_cnt, w_y, w_x = tw_cnt, te_cnt, i, j       # 이 때 3번 조건은 뒤의 부등호 처리에 의해 자동으로 충족된다.

    ans[w_y][w_x] = target                                          # 자리가 정해졌으니 채운다.

score = 0
for i in range(N):
    for j in range(N):
        cnt = 0
        for k in range(4):
            ny = i + dy[k]
            nx = j + dx[k]
            if 0 <= ny < N and 0 <= nx < N and ans[ny][nx] in arr[ans[i][j]]:
                cnt += 1

        if cnt == 0:
            continue
        else:
            score += 10 ** (cnt - 1)                                # 문제의 점수는 0이면 0점이나 1점부터는 10의 거듭제곱 형태이다.

print(score)
