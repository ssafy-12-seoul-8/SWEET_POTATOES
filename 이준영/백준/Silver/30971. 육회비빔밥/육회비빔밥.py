# 얻는 감칠맛이나 눈치밥 먹는 정도가 이전 시식대의 번호와 관련 있으므로 백트래킹에 있어 이를 같이 들고가야 된다.
# 시식대를 다 먹지 못하면 지금까지 모은 감칠맛이 의미가 없다.
# 시식대를 간 순서가 중요하다.
def btk(cnt, cur, sm1):                                 # 먹은 개수, 이전에 먹은 번호, 감칠맛
    global mx
    if cnt == N:
        mx = max(mx, sm1)
        return

    for i in range(N):
        if visited[i] == 0 and C[cur] * C[i] <= K:      # 아직 안간 시식대이고 방문하지 않았다면
            visited[i] = 1
            btk(cnt + 1, i, sm1 + A[cur] * B[i])
            visited[i] = 0


N, K = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))

visited = [0] * N

mx = -1

for i in range(N):
    visited[i] = 1
    btk(1, i, 0)
    visited[i] = 0

print(mx)
