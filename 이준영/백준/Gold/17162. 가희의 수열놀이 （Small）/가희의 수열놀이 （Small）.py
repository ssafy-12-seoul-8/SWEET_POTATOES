'''
제출횟수:
소요 시간: 17:27 ~
Q: 쿼리의 수 1 ~ 200000
mod : 정수mod 1~ 100
arr : 수열
쿼리의 종류
1 num: arr뒤에 num 추가
2: arr 맨 뒤에 수 제거, 비어있으면 무시
3: 쿼리에 대한 값 계산 (맨 뒤에서부터 몇 개의 수를 선택해야 0~mod-1이 모두 나올까? 불가능하면 -1 반환
'''

import sys

input = sys.stdin.readline
arr = []
Q, mod = map(int, input().split())
stk = [[] for _ in range(mod)]      # 각 정수가 담긴 인덱스를 저장하는 스택들의 배열
for _ in range(Q):
    tmp = list(input().rstrip().split())
    if tmp[0] == "1":               # 정수가 추가 되므로 r의 인덱스를 저장하는 스택에 현재 인덱스 추가
        r = int(tmp[1]) % mod
        arr.append(r)
        stk[r].append(len(arr) - 1)
    elif tmp[0] == "2":             # 원소를 제거하고 r의 인덱스를 저장하는 스택에서 마지막 원소 제거
        if not arr:
            continue
        r = arr.pop()
        stk[r].pop()
    else:
        mn = 200001
        for i in range(mod):
            if not stk[i]:          # 만약 한 스택이라도 비어있다면 그 수가 arr에 없다는 것
                mn = 200001
                break
            else:
                mn = min(mn, stk[i][-1]) # 가장 앞에 있는 인덱스를 저장
        if mn == 200001:
            print(-1)
        else:
            print(len(arr) - mn)
