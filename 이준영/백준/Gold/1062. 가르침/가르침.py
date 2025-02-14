# a,c,i,n,t는 반드시 들어가야 되기 때문에 K가 5이상이어야 한다.
# K가 5이상일 때 미리 5개를 K에 넣어놓는다고 생각하고 K=K-5를 하며 
# 각 단어의 집합에서도 위의 5글자는 빼고 관리한다.
# 남은 것은 21개 중 K개를 뽑았을 때 cnt를 세서 가장 큰 값을 찾는다.
import sys

input = sys.stdin.readline


def btk(cur, cnt):
    if cnt == K:
        check()
        return

    if 21 - cur + cnt < K:
        return

    btk(cur + 1, cnt)
    visited[cur] = 1
    btk(cur + 1, cnt + 1)
    visited[cur] = 0


def check():
    global mx_cnt

    tmp_cnt = 0
    for i in range(N):
        flag = True
        for j in arr[i]:
            if visited[j] == 0:
                flag = False
                break

        if flag:
            tmp_cnt += 1

    mx_cnt = max(mx_cnt, tmp_cnt)


N, K = map(int, input().split())
arr = [set([]) for _ in range(N)]
lst = [i for i in range(26) if i not in (0, 2, 8, 13, 19)]  # a,c,i,n,t아니면 넣는다
dct = {}
for i in range(21):
    dct[lst[i]] = i                                         # a,c,i,n,t를 빼고 앞으로 땡긴 결과

visited = [0] * 21

for i in range(N):
    s = input().rstrip()
    for k in s:
        if k not in ("a", "c", "i", "n", "t"):
            arr[i].add(dct[ord(k) - ord('a')])

if K < 5:
    print(0)
else:
    K = K - 5
    mx_cnt = 0
    btk(0, 0)
    print(mx_cnt)
