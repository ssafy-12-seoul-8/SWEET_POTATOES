# 처음엔 각 폴더나 파일 별로 하위 파일의 종류, 개수 등을 저장하려고 했으나 파일명이 같아도 다른 위치에 있을 수 있어
# 쿼리마다 질문의 답을 얻었다.

import sys

input = sys.stdin.readline
sys.setrecursionlimit(10000)


def tree(cur):
    if cur not in child:
        return 0, set([])

    st = set([])
    cnt2 = 0
    for tmp in child[cur]:
        if tp[tmp] == 0:
            cnt2 += 1
            st.add(tmp)

        cnt, tmp_st = tree(tmp)
        st = st.union(tmp_st)
        cnt2 += cnt

    cnt1 = len(st)

    return cnt2, st

N, M = map(int, input().split())

child = {}
tp = {}

for _ in range(N + M):
    P, F, C = input().rstrip().split()
    tp[F] = int(C)

    if P in child:
        child[P].append(F)
    else:
        child[P] = [F]

tree("main")

Q = int(input())
for _ in range(Q):
    lst = list(input().rstrip().split("/"))
    a, st = tree(lst[-1])
    print(len(st),a)

