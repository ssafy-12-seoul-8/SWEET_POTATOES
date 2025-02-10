def btk(cur, sm):                       # 현재 검사하는 노드, 지금까지의 합
    global cnt

    if cur == N:                        # 노드 다 검사했을 때 리턴하는데 합이 S이면 cnt를 증가
        if sm == S:
            cnt += 1
        return

    btk(cur + 1, sm)                    # 현재 노드 선택하지 않음
    btk(cur + 1, sm + arr[cur])         # 현재 노드 선택


N, S = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0
btk(0, 0)

if S == 0:
    cnt -= 1

print(cnt)
