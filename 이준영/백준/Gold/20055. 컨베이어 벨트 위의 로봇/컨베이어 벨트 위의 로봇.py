# 문제에서 요구하는 바를 단계별로 처리해주면 풀리는 문제이다.
N, K = map(int, input().split())
lst = list(map(int, input().split()))

belt = [0] * (2 * N)
for i in range(2 * N):
    belt[i] = [lst[i], 0]                           # (내구도, 로봇유무) (처음의 1~2N인덱스는 내구도 초기값외엔 안쓰이므로 넣지 않는다.)
cnt = 0                                             # 내구도가 없는 칸의 개수
time = 1                                            # 단계
while True:
    belt[N - 2][1] = 0                              # N-2칸에 있는 건 다음에 넘어가면서 버려지므로 그냥 버린다.
    tmp = [belt[2 * N - 1][0], belt[2 * N - 1][1]]  # 2*N-1칸의 정보를 임시 저장

    for i in range(2 * N - 1, 0, -1):
        belt[i] = [belt[i - 1][0], belt[i - 1][1]]  # 2*N-1~-1까지 정보를 채우고

    belt[0] = tmp                                   # 0칸에 아까 저장했던 tmp를 채움

    for i in range(N - 2, 0, -1):                   # 로봇이 움직이려면 i칸은 차있고 i+1칸은 비어있으며 i+1칸의 내구도가 있어야 함
        if belt[i][1] == 1 and belt[i + 1][1] == 0 and belt[i + 1][0] > 0:  
            belt[i][1] = 0                          # 그렇다면 로봇을 움직이고
            belt[i + 1][1] = 1
            belt[i + 1][0] -= 1                     # 내구도 갱신
            if belt[i + 1][0] == 0:                 # 내구도 갱싢랬는데 0이면 cnt 증가
                cnt += 1

            if i + 1 == N - 1:                      # 옮긴 곳이 버리는 곳이면 바로 버림
                belt[i + 1][1] = 0

    if belt[0][0] > 0:                              # 0번 칸의 내구도가 있으면 로봇 올리자
        belt[0][1] = 1
        belt[0][0] -= 1
        if belt[0][0] == 0:                         # 만약 내구도가 이로 인해 다달면 cnt 증가
            cnt += 1

    if cnt >= K:                                    # cnt가 K이상이면 멈추고
        break
    time += 1                                       # 그렇지 않다면 다음단계로 가자

print(time)
