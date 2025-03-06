# 문제에 충실하게 구현
# 인덱스를 이용하여 임시 배열을 만들고 채우는 형식으로 하였습니다.
import sys
from collections import deque

input = sys.stdin.readline


def firestorm(arr, l):  # 문제의 firestorm을 그대로 구현한것
    tmp = [[0] * N for _ in range(N)]  # firestorm을 하고나서 배열
    for n in range(N // l):
        for m in range(N // l):  # 전체 배열을 (2^l)*(2^l)로 나누면 (2^(N-l))*(2^(N-l)) 개가 생김
            for i in range(l):  # i행 j열을 돌릴거다,
                for j in range(l):  # 그냥 크기 (2**l) * (2**l)을 돌리는 거면 (i,j)자리에 오는건 이전 배열의 (2**l-1-j,i) 요소이다.
                    tmp[l * n + i][l * m + j] = arr[l * n + l - 1 - j][l * m + i]

    lst = []  # 얼음이 녹는 곳을 저장할 배열
    for i in range(N):
        for j in range(N):
            if tmp[i][j] == 0:
                continue
            cnt = 0  # 인접한 얼음이 2개이하이면 녹는다.
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < N and 0 <= nx < N and tmp[ny][nx] > 0:
                    cnt += 1
            if cnt <= 2:
                lst.append((i, j))

    for y, x in lst:  # 리스트의 요소 순회하며 얼음 녹임
        tmp[y][x] -= 1

    return tmp  # 배열 반환


def bfs():  # 가장 큰 덩어리를 찾는 함수
    visited = [[0] * N for _ in range(N)]  # 방문 배열
    mx = 0  # 최대 덩어리 칸 수
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0 and arr[i][j] > 0:  # 얼음이고 방문하지 않으면 bfs 돌리자.
                visited[i][j] = 1
                dq = deque([(i, j)])
                cnt = 1  # 이 얼음이 속한 덩어리에 있는 얼음 칸 수
                while dq:
                    y, x = dq.popleft()
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] > 0:
                            visited[ny][nx] = 1
                            cnt += 1
                            dq.append((ny, nx))

                mx = max(mx, cnt)  # 최대 얼음 크기 갱신
    return mx


N, Q = map(int, input().split())
N = 2 ** N
arr = [list(map(int, input().split())) for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
L = list(map(int, input().split()))

for i in range(Q):
    arr = firestorm(arr, 2 ** L[i])

tot = 0
mx = bfs()
for i in range(N):
    for j in range(N):
        tot += arr[i][j]

print(tot)
print(mx)
