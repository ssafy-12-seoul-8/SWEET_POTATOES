import sys

input = sys.stdin.readline


def update(left, right, index):
    if num < left or num > right:
        return
    if left == right:
        seg_tree[index] = cur
        return

    mid = (left + right) // 2
    update(left, mid, index * 2)
    update(mid + 1, right, index * 2 + 1)

    seg_tree[index] = min(seg_tree[index * 2], seg_tree[index * 2 + 1])


Q, mod = map(int, input().split())

if Q < mod:
    for _ in range(Q):
        lst = list(map(int, input().rstrip().split()))
        if lst[0] == 3:
            print(-1)
else:
    stk = [[] for _ in range(mod)]
    tot_stk = []
    seg_tree = [-1] * (mod * 4)
    for _ in range(Q):
        lst = list(map(int, input().rstrip().split()))
        if lst[0] == 1:
            num = lst[1] % mod
            tot_stk.append(num)
            cur = len(tot_stk) - 1
            stk[num].append(cur)
            update(0, mod - 1, 1)

        elif lst[0] == 2:
            if not tot_stk:
                continue
            num = tot_stk.pop()
            stk[num].pop()
            if stk[num]:
                cur = stk[num][-1]
            else:
                cur = -1

            update(0, mod - 1, 1)
        else:
            ans = seg_tree[1]
            if ans == -1:
                print(-1)
            else:
                print(len(tot_stk) - ans)
