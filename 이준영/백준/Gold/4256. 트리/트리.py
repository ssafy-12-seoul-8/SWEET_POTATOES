# 전위 순회의 맨 처음 원소가 항상 루트임을 이용하여 root, left, right를 나누어 푼다.
# 근데 root가 중위순회에서 어디있는지를 바로 찾기 위해서 location배열로 수:index를 관리한다.
import sys

input = sys.stdin.readline


def post(p_s, p_e, i_s, i_e):                       # pre에서 시작,끝, ino의 시작, 끝
    if p_s > p_e:                                   # 원소가 없다.
        return

    if p_s == p_e:                                  # 원소 하나면 출력
        print(pre[p_s], end=" ")
        return

    target = pre[p_s]                               # 루트
    loc = location[target]                          # ino에서 루트 인덱스
    post(p_s + 1, loc - i_s + p_s, i_s, loc - 1)    # 왼쪽 그룹
    post(loc - i_s + p_s + 1, p_e, loc + 1, i_e)    # 오른쪽 그룹
    print(target, end=" ")


T = int(input())
for _ in range(T):
    N = int(input())
    pre = list(map(int, input().split()))
    ino = list(map(int, input().split()))
    location = [0] * (N + 1)
    for i in range(N):
        location[ino[i]] = i

    post(0, N - 1, 0, N - 1)
    print()
