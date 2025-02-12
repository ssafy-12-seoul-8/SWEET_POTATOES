# 각 번호에서 시작하여 이러한 관계가 생기는지를 백트래킹으로 탐방
# 방문여부는 visited 배열로 관리
def btk(cnt, cur):                      # (지금까지 길이, 현재 노드)
    global check
    if check == 1:                      # 이미 찾아서 더 찾을 필요 없음
        return

    for i in friend[cur]:
        if not visited[i]:
            if cnt == 4:                # 지금까지 4명이었는데 방문하지 않은 친구가 있다면 성공
                check = 1
                break
            else:                       # 아니면 방문하지 않은 친구 쪽으로 검사해봄
                visited[i] = True
                btk(cnt + 1, i)
                visited[i] = False


N, M = map(int, input().split())
friend = [[] for _ in range(N + 1)]
check = 0
for _ in range(M):
    a, b = map(int, input().split())
    friend[a].append(b)
    friend[b].append(a)

visited = [False] * (N + 1)
for i in range(1, N + 1):
    visited[i] = True
    btk(1, i)
    visited[i] = False

print(check)
