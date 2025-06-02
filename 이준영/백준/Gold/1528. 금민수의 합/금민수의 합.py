from collections import deque


def start(cur, length):
    if length > 6:
        return

    gold_num.append(cur)
    cnt[cur] = 1

    start(cur * 10 + 4, length + 1)
    start(cur * 10 + 7, length + 1)


N = int(input())

max_num = 1000001
cnt = [-1] * max_num

gold_num = []
start(0, 0)

cnt[0] = 0
gold_num.sort()
gold_num.pop(0)
dq = deque(gold_num)


while dq:
    cur = dq.popleft()
    for add_num in gold_num:
        if cur + add_num >= max_num:
            break

        if cnt[cur + add_num] == -1:
            cnt[cur + add_num] = cnt[cur] + 1
            dq.append(cur + add_num)

if cnt[N] == -1:
    print(-1)

else:
    ans = []
    s_index = 0
    while N > 0:
        for i in range(s_index, 126):
            if cnt[N] == (cnt[N - gold_num[i]] + 1):
                ans.append(gold_num[i])
                s_index = i
                N = N - gold_num[i]
                break
    print(*ans,sep=" ")
