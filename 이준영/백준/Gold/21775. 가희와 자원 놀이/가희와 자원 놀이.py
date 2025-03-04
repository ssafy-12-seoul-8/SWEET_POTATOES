import sys

input = sys.stdin.readline


def do(s, target):

    if s[1] == "next":
        own[target] = -1
        return

    n = int(s[2])
    if s[1] == "acquire":
        if n in tot_set:
            return
        else:
            tot_set.add(n)
            num[target].add(n)
            own[target] = -1
            return

    tot_set.remove(n)
    num[target].remove(n)
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

num = [set([]) for _ in range(N + 1)]  # i번이 소지한 자원
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
