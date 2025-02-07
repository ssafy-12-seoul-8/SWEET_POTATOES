# 원의 교점이 몇개 인가를 세는 문제이다.
# 중심이 일치할 때 반지름이 다르면 교점이 없고 반지름이 같으면 무한개이다
# 중심이 일치하지 않으면 중심사이의 거리와 반지름의 합간의 대소관계에 따라 달라진다.
T = int(input())
for tc in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    if (x1, y1) == (x2, y2):
        if r1 == r2:
            print(-1)
        else:
            print(0)
    else:
        dis = (x1 - x2) ** 2 + (y1 - y2) ** 2
        mn = (r1 + r2) ** 2
        mx = (r1 - r2) ** 2
        if dis == mn or dis == mx:
            print(1)
        elif mx < dis < mn:
            print(2)
        else:
            print(0)
