# 크기에 대한 내림차순으로 정렬한 후 자신의 위치를 표시
# 그리고 1000001이하의 자신의 배수에 대해 check가 표시되어 있으면 점수 반영
import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
score = {}
change = {}
check = [False] * 1000002
for i in range(N):
    change[i] = arr[i]
    score[arr[i]] = 0

arr.sort(reverse=True)
for i in range(N):
    tmp = arr[i]
    check[tmp] = True
    for j in range(1, 1000001 // tmp + 1):
        if check[tmp * j]:
            score[tmp] += 1
            score[tmp * j] -= 1

for i in range(N):
    print(score[change[i]], end=" ")
