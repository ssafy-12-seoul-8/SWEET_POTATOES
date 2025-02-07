# 행성계의 안과 밖을 생각했을 때 출발점과 도착점이 서로 안, 밖이 다를 때만 더해주면 된다.
# 이는 행성계의 중심까지의 거리가 하나는 반지름보다 크고 하나는 작아야 하며 각각 거리를 d1,d2라 할 때
# (r**2-d1**2)*(r**2-d2**2)<0과 동치이다.
def d_s(x1, y1, x2, y2):
    return (x1 - x2) ** 2 + (y1 - y2) ** 2


T = int(input())
for tc in range(T):
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    p = [list(map(int, input().split())) for _ in range(n)]
    cnt = 0

    for i in range(n):
        x, y, r = p[i]
        if (r ** 2 - d_s(x, y, x1, y1)) * (r ** 2 - d_s(x, y, x2, y2)) < 0:
            cnt += 1
    print(cnt)