# 크레인과 박스 모두 무거운 순으로 정렬
# 만약 크레인의 최고 중량이 박스보다 작으면 불가능
# 각 시행마다 무거운 크레인은 자신이 들 수 있는 가장 큰 박스를 든다.
import sys

input = sys.stdin.readline
N = int(input())
crane = list(map(int, input().split()))
M = int(input())
box = list(map(int, input().split()))

crane.sort(reverse=True)
box.sort(reverse=True)

time = 0
if crane[0] < box[0]:
    time = -1
else:
    visited = [False] * M
    cnt = 0

    while cnt < M:
        time += 1
        i = 0
        j = 0
        while i < N and j < M:
            if not visited[j] and crane[i] >= box[j]:
                visited[j] = True
                cnt += 1
                i += 1
                j += 1
                continue
            j += 1

print(time)
