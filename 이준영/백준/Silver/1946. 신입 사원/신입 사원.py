# 풀이시간: 12분
# 제출횟수: 1회
# 메모리:
# 시간:
# 
import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N = int(input())
    score = [list(map(int, input().split())) for _ in range(N)]
    score.sort()
    cnt = 1
    mx = score[0][1]

    for i in range(1, N):
        if mx < score[i][1]:
            continue
        cnt += 1
        mx = score[i][1]

    print(cnt)
