# inorder는 L mid R, postorder는 L R mid순이므로 postorder의 mid 로 L과 R을 가르면 된다.
# 미리 inorder의 숫자의 인덱스를 딕셔너리로 저장해놓았다. (배열로도 됨)
# 재귀적으로 범위를 줄이며 돌렸다.

import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)


def pre(i_s, i_e, p_s, p_e):
    if i_s > i_e:
        return
    if i_s == i_e:
        print(inord[i_s], end=" ")
        return

    mid = post[p_e]
    inord_idx = i_location[mid]

    print(mid, end=" ")
    pre(i_s, inord_idx - 1, p_s, p_s + inord_idx - i_s - 1)
    pre(inord_idx + 1, i_e, p_s + inord_idx - i_s, p_e - 1)


n = int(input())

inord = list(map(int, input().split()))
post = list(map(int, input().split()))
i_location = {}

for i in range(n):
    i_location[inord[i]] = i

pre(0, n - 1, 0, n - 1)
