def btk(l, lst):                # 현재 뽑은 개수, 뽑은 리스트(뽑은 순서대로)
    if l == N:          
        print(*lst)
        return

    for i in range(1, N + 1):
        if not visited[i]:
            visited[i] = True   # 방문 처리
            lst.append(i)   
            btk(l+1, lst)
            visited[i] = False  # 원상복귀
            lst.pop()


N = int(input())
visited = [False] * (N + 1)

btk(0, [])
