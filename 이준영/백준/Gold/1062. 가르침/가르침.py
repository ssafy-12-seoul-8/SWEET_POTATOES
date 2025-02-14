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
lst = [i for i in range(26) if i not in (0, 2, 8, 13, 19)]
dct = {}
for i in range(21):
    dct[lst[i]] = i

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
