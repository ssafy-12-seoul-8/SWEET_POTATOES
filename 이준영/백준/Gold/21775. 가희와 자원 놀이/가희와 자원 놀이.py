# 제출횟수: 1회
# 메모리: 455832KB
# 시간: 1712ms
# 각 인원의 set과 전체 set을 따로 관리해서 문제를 풀었지만 문제의 제한 사항을 보니 안그래도 되더라...
import sys

input = sys.stdin.readline


def do(s, target):                                              # s명령을 target이 실행
    if s[1] == "next":  
        own[target] = -1                                        # 카드 버리기
        return

    n = int(s[2])
    if s[1] == "acquire":                                       
        if n in tot_set:                                        # 다른 사람 자원에 있으면 아무것도 안함
            return
        else:                                                   # 없으면 가져온다.
            tot_set.add(n)
            own[target] = -1
            return

    tot_set.remove(n)                                           # 다 아니면 n을 제거
    own[target] = -1


N, T = map(int, input().split())
order = list(map(int, input().split()))
card = [0] * T
op = {}
for i in range(T):
    s = list(input().rstrip().split())
    s[0] = int(s[0])
    card[i] = s
    op[s[0]] = s

idx = 0

tot_set = set([])  # 전체가 소지한 자원
own = [-1] * (N + 1)  # 내가 소유한 연산카드 인덱스

for i in range(T):
    target = order[i]
    if own[target] == -1:
        own[target] = card[idx][0]
        print(own[target])
        idx += 1
        do(op[own[target]], target)

    else:
        print(own[target])
        do(op[own[target]], target)
