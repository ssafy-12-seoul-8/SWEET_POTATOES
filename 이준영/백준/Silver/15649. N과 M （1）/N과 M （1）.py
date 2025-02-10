# 백트래킹
def btk(lst):                   # 현재 리스트
    if len(lst) == M:
        print(*lst)
    for i in range(1, N + 1):   # 범위에 있는 것중 방문하지 않은 것만 다음으로 넘어갈 수 있음
        if not visited[i]:
            visited[i] = True
            lst.append(i)
            btk(lst)            # 리스트에 추가하고 방문표시한 후 다시 풀어줘야 한다.
            lst.pop()
            visited[i] = False


N, M = map(int, input().split())
visited = [False] * (N + 1)     # 방문배열
btk([])
