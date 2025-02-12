# 일단 벽을 부시기 시작하는 방번호를 기준으로 정렬한다.
# 그리고 현재 부수고 있는 방의 끝을 end로 지정하는데 만약 다음 방이 end보다 빠르게 시작하면 end만 갱신
# 그렇지 않다면 end~ 다음 방의 시작의 차이만큼 방이 생기고, end 갱신
# 처음과 끝을 고려하기 위해 시작 cnt,end=1, 마지막에 N-end만큼 더해준다.
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
act = [0] * M

for i in range(M):
    act[i] = list(map(int, input().split()))

act.sort()

cnt = 1
end = 1
for i in range(M):
    if act[i][0] <= end:
        end = max(end, act[i][1])
    else:
        cnt += (act[i][0] - end)
        end = act[i][1]

cnt = cnt + N - end
print(cnt)
