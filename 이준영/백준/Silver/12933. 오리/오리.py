# 오리의 울음소리가 올바르게 되기 위해서는 항상 q-u-a-c-k의 개수가 단조김소수열이어야 한다. (앞에것이 뒤에것보다 적은 순간이 없어야 함)
# 또한 마지막에 각 문자의 개수가 동일해야 한다.
# 오리의 수는 q와 k의 개수 차이가 가장 큰 순간이다.
import sys

input = sys.stdin.readline

arr = [0] * 5
dct = {"q": 0, "u": 1, "a": 2, "c": 3, "k": 4}

s = input().rstrip()
ans = 0
for i in s:
    tmp = dct[i]
    arr[tmp] += 1
    if tmp > 0:                                          # 현재 문자가 q가 아니면
        if arr[tmp] > arr[tmp - 1]:                      # 이전것보다 개수가 커지면 소리가 올바르지 않음  
            ans = -1
            break

        if tmp == 4:                                     # k로 끝날때 마다 갱신해주면 된다. (현재 k제외)
            ans = max(ans, arr[0] - arr[4] + 1)

if not (arr[0] == arr[1] == arr[2] == arr[3] == arr[4]):
    ans = -1

print(ans)
