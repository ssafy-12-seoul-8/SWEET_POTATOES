# 상어 잡기 - 상어 이동 순으로 구현하였다.
# 상어들의 상태를 딕셔너리로 관리할까 했지만 그냥 배열로 관리하는 것이 실수를 덜 할 것 같아 사용하였다 (최악의 경우엔 모든 격자에 상어가 존재
# 가능하기 때문에 상관없을 것이라 생각했다.- 시간복잡도 상으로도 괜찮다.)
# 한 칸에 상어가 여러 마리가 와도 그 때 그 때 처리하기 떄문에 arr에는 항상 한 마리의 상어 상태만 있다.

n, m, k = map(int, input().split())
arr = [[[0, 0, 0] for _ in range(m)] for _ in range(n)]                     # 그 좌표에 있는 상어 (상어가 없으면 0,0,0이다)

dy = [-1, 1, 0, 0]                                                          # 방향을 그냥 0,1,2,3으로 관리
dx = [0, 0, 1, -1]
change = [1, 0, 3, 2]                                                       # 방향 전환 룩업테이블
for _ in range(k):
    y, x, s, d, b = map(int, input().split())
    arr[y - 1][x - 1] = [s, d - 1, b]                                       # 좌표를 0~n-1, 0~m-1로 관리

score = 0                                                                   # 잡은 상어 크기 합

for l in range(m):
    new_arr = [[[0, 0, 0] for _ in range(m)] for _ in range(n)]             # 새로운 상어 상태 저장

    for i in range(n):
        if arr[i][l][2] != 0:                                               # 상어가 있다면
            score += arr[i][l][2]                                           # 점수 더하고
            arr[i][l] = [0, 0, 0]                                           # 상어 없애자
            break

    for i in range(n):
        for j in range(m):
            if arr[i][j][2] != 0:                                           # 여기에 상어 있다면 움직일 건데
                s, d, b = arr[i][j]                                         # 최종 좌표, 방향을 ny,nx,nd로 관리할 거임

                if d == 0:                                                  # 초기 방향이 위일 때
                    nx = j                                                  # x좌표는 그대로이다.
                    s = s % (2 * (n - 1))                                   # 관찰을 통해 s가 2*(n-1)을 주기로 돈다는 걸 알 수 있다.

                    if 0 <= s < i:                                          # 위 벽에 부딪힐 때까지
                        ny = i - s                                          # s가 증가할 수록 y좌표가 감소하고
                        nd = d                                              # 방향은 처음과 같다.

                    elif s < i + n - 1:                                     # 위에 찍고 아래벽을 찍을 때 까지
                        ny = s - i                                          # s가 증가할 수록 y좌표 증가하고
                        nd = change[d]                                      # 방향은 반대

                    else:                                                   # 아래벽찍고 다시 위로 올 때
                        ny = i + 2 * (n - 1) - s                            # s가 증가할 수록 y좌표가 감소하고
                        nd = d                                              # 방향은 처음과 같다.

                elif d == 1:                                                # 초기방향이 아래라면
                    nx = j                                                  # x좌표는 그대로
                    s = s % (2 * (n - 1))

                    if 0 <= s < n - 1 - i:                                  # 아래 벽에 부딪힐 때 까지
                        ny = i + s                                          # s가 증가할 수록 y좌표 증가하고
                        nd = d                                              # 방향은 처음과 같다.

                    elif s < 2 * n - i - 2:                                 # 아래벽찍고 위로 올 때
                        ny = 2 * n - i - 2 - s                              # s가 증가할 수록 y좌표가 감소하고
                        nd = change[d]                                      # 방향은 반대

                    else:                                                   # 위에 찍고 다시 아래벽을 찍을 때 까지
                        ny = i + s - 2 * n + 2                              # s가 증가할 수록 y좌표 증가하고
                        nd = d                                              # 방향은 처음과 같다.

                elif d == 2:                                                # 초기 방향이 오른쪽이라면 초기방향이 아래인 것과 비교해서
                    ny = i                                                  # y,x,i,j,n 을 x,y,j,i,m으로 바꿔주면 된다.
                    s = s % (2 * (m - 1))
                    if 0 <= s < m - 1 - j:
                        nx = j + s
                        nd = d
                    elif s < 2 * m - j - 2:
                        nx = 2 * m - j - 2 - s
                        nd = change[d]
                    else:
                        nx = j + s - 2 * m + 2
                        nd = d

                else:                                                       # 초기방향이 왼쪽인 것도 초기방향이 위인 것과 비교하여
                    ny = i                                                  # y,x,i,j,n 을 x,y,j,i,m으로 바꿔주면 된다.        
                    s = s % (2 * (m - 1))
                    if 0 <= s < j:
                        nx = j - s
                        nd = d
                    elif s < j + m - 1:
                        nx = s - j
                        nd = change[d]
                    else:
                        nx = j + 2 * (m - 1) - s
                        nd = d

                if new_arr[ny][nx][2] < b:                                  # 새로운 좌표에 이미 물고기가 있는데 나보다 작을때만
                    new_arr[ny][nx] = [s, nd, b]                            # 갱신해준다.

    arr = new_arr
print(score)
