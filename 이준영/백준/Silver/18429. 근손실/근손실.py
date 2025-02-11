# 500을 기준으로 하지 않고 0을 기준으로 항상 음아닌정수를 유지하면 된다.
def btk(cur, sm):
    global cnt
    if sm < 0:                          # 실패
        return

    if cur == N:                        # 끝까지 잘 해냄
        cnt += 1
        return

    for i in range(N):
        if not visited[i]:
            visited[i] = True           # 가능한 운동 키트에 대해 시행함
            btk(cur + 1, sm + arr[i] - K)
            visited[i] = False


N, K = map(int, input().split())
arr = list(map(int, input().split()))
visited = [False] * N
cnt = 0
btk(0, 0)
print(cnt)
