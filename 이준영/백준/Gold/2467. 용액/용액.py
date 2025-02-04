# 투 포인터 문제
# 양 끝을 기준으로 잡고 줄여 나가는데 만약 합이 음수이면 왼쪽을 움직이고 양수이면 오른쪽을 움직인다.
import sys

input = sys.stdin.readline
N = int(input())
lst = list(map(int, input().split()))

i = left = 0
j = right = N - 1
mn = abs(lst[i] + lst[j])

while i < j:
    result = lst[i] + lst[j]
    if abs(result) < mn:  # 최소값 갱신 시 idx를 최신화해줌
        mn = abs(result)
        left = i
        right = j
    if mn == 0:           # mn = 0이면 더 할 필요 없으므로 break
        break
    elif result < 0:      # 결과가 음수이므로 왼쪽 포인터를 1칸 오른쪽으로 움직인다.
        i += 1
    else:                 # 결과가 양수이므로 오른쪽 포인터를 1칸 왼쪽으로 움직인다.
        j -= 1

print(lst[left], lst[right])
