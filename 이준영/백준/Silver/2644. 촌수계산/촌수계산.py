from collections import deque

n = int(input())
s, e = map(int, input().split())
m = int(input())

rel = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y = map(int, input().split())
    rel[x].append(y)         # 결국 부모관계도 누가 자식인지는 중요하지 않고 관계가 있다는 게 중요하므로
    rel[y].append(x)         # 무방향 그래프로 생각해도 된다.

ans = -1                     # 기본값 -1 (친척아니면 -1 출력하려고)
dq = deque([(0, s)])         # 거리를 함께 저장
visited = [False] * (n + 1)

while dq:
    dis, des = dq.popleft()
    if not visited[des]:
        visited[des] = True
        if des == e:
            ans = dis
            break
        for i in rel[des]:
            if not visited[i]:
                dq.append((dis + 1, i))

print(ans)
