# 각 점은 사이클에 속하던가 길을 따라가서 사이클로 가는가 둘 중 하나이다.
# 만약 사이클에 속한 점이었다면 내가 가는 길을 따라 갔을 때 다시 나로 돌아와야 한다.
# 사이클에 속하지 않는 가지에 속한다면 가다보면 내가 사이클안에 들어간다.
import sys

input = sys.stdin.readline


def go(y, x):
    global cnt
    st = set([])
    while not visited[y][x]:    
        st.add((y, x))
        visited[y][x] = True
        tmp = dct[arr[y][x]]
        y = y + tmp[0]
        x = x + tmp[1]
    if (y, x) in st:            # 방문하지 않는 곳만 갔는데 내 경로 상의 점으로 갔다면 새로운 길 개척
        cnt += 1                # 경로 상에 있지 않지만 방문한 곳을 갔다면 기존의 길임


N, M = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(N)]

dct = {"D": (1, 0), "L": (0, -1), "U": (-1, 0), "R": (0, 1)}

cnt = 0
visited = [[False] * M for _ in range(N)]

for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            go(i, j)

print(cnt)
