import sys
from heapq import heappop, heappush

input = sys.stdin.readline
N, M = map(int, input().split())
price = {}
for _ in range(N):
    a, b = input().rstrip().split()
    b = int(b)
    price[a] = b

comb = [[] for _ in range(M)]  # (음식,가격,{재료:[개수,가격]})
place = {}  # {재료:들어있는 인덱스}

need = [set([]) for _ in range(M)]  # 필요한 애들

for i in range(M):
    s = input().rstrip()
    lst1, lst2 = s.split("=")
    lst = lst2.split("+")
    comb[i].append(lst1)
    comb[i].append(0)
    ele = {}

    for j in lst:
        tmp = j[1:]
        if tmp in ele:
            ele[tmp][0] += int(j[0])
        else:
            ele[tmp] = [int(j[0]), 0]
            need[i].add(tmp)
        if tmp in place:
            place[tmp].add(i)
        else:
            place[tmp] = set([i])
    comb[i].append(ele)

pq = []
for i in range(M):
    sm = 0
    flag = True
    for j, tmp in comb[i][2].items():
        if j in price:
            sm = sm + price[j] * tmp[0]
            comb[i][2][j][1] = price[j]
            if j in need[i]:
                need[i].remove(j)

    if not need[i]:
        comb[i][1] = sm
        if comb[i][0] in price:
            if sm >= price[comb[i][0]]:
                continue
            else:
                tmp = price[comb[i][0]]
                price[comb[i][0]] = sm
                heappush(pq, (sm, comb[i][0]))

        else:
            price[comb[i][0]] = sm
            heappush(pq, (sm, comb[i][0]))

# print(comb)
# print(place)
# print(need)
# print(price)
# print(pq)

while pq:

    dis, cur = heappop(pq)

    if price[cur] < dis:
        continue

    if cur not in place:
        continue

    for i in place[cur]:
        if cur in need[i]:
            need[i].remove(cur)  # cur에 없던게 생겼다면
            if not need[i]:
                sm = 0
                for j, tmp in comb[i][2].items():
                    sm = sm + price[j] * tmp[0]
                    comb[i][2][j][1] = price[j]
                comb[i][1] = sm
                if comb[i][0] in price:
                    if price[comb[i][0]] <= sm:
                        continue
                    else:
                        tmp = price[comb[i][0]]
                        price[comb[i][0]] = sm
                        heappush(pq, (sm, comb[i][0]))
                else:
                    price[comb[i][0]] = sm
                    heappush(pq, (sm, comb[i][0]))

        else:
            if not need[i]:
                if dis >= comb[i][2][cur][1]:
                    continue

                comb[i][1] -= (comb[i][2][cur][1] - dis) * comb[i][2][cur][0]
                comb[i][2][cur][1] = dis
                if comb[i][1] < price[comb[i][0]]:
                    price[comb[i][0]] = comb[i][1]
                    heappush(pq, (comb[i][1], comb[i][0]))

# print("-" * 30)
# print(comb)
# print(place)
# print(need)
# print(price)

if "LOVE" in price:
    a = price["LOVE"]
    if a > 10 ** 9:
        print(10 ** 9 + 1)
    else:
        print(a)

else:
    print(-1)


