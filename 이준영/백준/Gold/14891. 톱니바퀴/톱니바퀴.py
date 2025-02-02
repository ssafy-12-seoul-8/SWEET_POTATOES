from collections import deque

def rotate(cur, d):             # a인덱스의 톱니바퀴를 b방향으로 돌리기 (1은 시계 방향, -1은 반시계방향)
    if d == 1:
        tmp = arr[cur].pop()
        arr[cur].appendleft(tmp)
        return
    else:
        tmp = arr[cur].popleft()
        arr[cur].append(tmp)
        return

arr = [deque(map(int, list(input()))) for _ in range(4)]
N = int(input())
for _ in range(N):
    a, b = map(int, input().split())
    a = a - 1
    need_rotate = [(a, b)]                          # 처음 상태를 기준으로 돌아가는 방향과 유무가 정해지므로 다 계산하고 한번에 돌림
    start = a
    dr = -b
    while start > 0:                                # 주어진 톱니바퀴 기준 돌아가는 왼쪽 톱니바퀴 체크
        if arr[start - 1][2] != arr[start][6]:
            need_rotate.append((start - 1, dr))
            start = start - 1
            dr = -dr
        else:
            break
    start = a
    dr = -b
    while start < 3:                                # 주어진 톱니바퀴 기준 돌아가는 오른쪽 톱니바퀴 체크
        if arr[start][2] != arr[start + 1][6]:
            need_rotate.append((start + 1, dr))
            start = start + 1
            dr = -dr
        else:
            break
    for i, j in need_rotate:
        rotate(i, j)
cnt = 0
for i in range(4):
    if arr[i][0] == 1:
        cnt += (1 << i)
print(cnt)
