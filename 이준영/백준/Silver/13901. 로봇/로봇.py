# 제출횟수: 2회 (첫 방향으로 한 칸씩만 가고 방향 바꾸는줄...)
# 풀이시간 17분
# 메모리: 114708kb
# 시간: 108ms
# 굳이 공간을 만들 필요 없이 방문배열과 범위 체크로 해결할 수 있다고 생각하여 그렇게 진행하였습니다.
# 그래서 방해물이 있는 곳은 이미 방문한 곳으로 처리하였습니다.

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

R, C = map(int, input().split())
visited = [[False] * C for _ in range(R)]
k = int(input())
for _ in range(k):
    a, b = map(int, input().split())
    visited[a][b] = True                    # 장애물이 있는 곳은 방문처리

y, x = map(int, input().split())
visited[y][x] = True                        # 시작점도 방문 처리

tmp = list(map(int, input().split()))
s = [i - 1 for i in tmp]                    # 방향을 그냥 한칸씩 땡겨서 0123이 되게 하였습니다.
st = set([])        
    
for i in s:                                 # 명령에 있는 모든 방향을 저장
    st.add(i)

cur = 0
l = len(s)

while True:

    ny = y + dir[s[cur]][0]
    nx = x + dir[s[cur]][1]
    if 0 <= ny < R and 0 <= nx < C and not visited[ny][nx]: # 갈 방향 있으면 전진
        visited[ny][nx] = True
        y = ny
        x = nx
        continue
    check = False                                           # 갈 방향이 없다면 전체 명령 중 갈 곳으로 인도하는 명령이 있는지 확인
    for k in st:
        ny = y + dir[k][0]
        nx = x + dir[k][1]
        if 0 <= ny < R and 0 <= nx < C and not visited[ny][nx]:
            check = True
            break
    if check:                                               # 있다면 따를 명령이 있다는 것이니 cur을 추가하고 while문 유지
        cur = (cur + 1) % l
        continue
    else:                                                   # 없다면 그냥 탈출
        break
print(y, x)
