from heapq import heappop, heappush


def find_loc():
    mx_dis = -1
    mn_num = 101
    for i in range(1, N + 1):
        if board[i] == 0:
            dis = 101
            for j in range(1, N + 1):
                if i == j:
                    continue

                if board[j] == 1:
                    dis = min(dis, abs(j - i))

            if mx_dis < dis:
                mx_dis = dis
                mn_num = i
    return mn_num




N, T, P = map(int, input().split())

lst = []
for _ in range(T):
    a, b = map(int, input().split())
    a = a // 100 * 60 + a % 100
    b = b // 100 * 60 + b % 100
    lst.append((a, b))

lst.sort(reverse=True)
board = [0] * (N + 1)
cur = 540
tot = 0
cnt = 0
pq = []
while True:
    if cnt == T:
        tot += (1260 - cur)
        break

    if not pq:
        a, b = lst.pop()
        board[1] = 1
        heappush(pq, (b, 1))
        tot += (a - cur)
        cur = a

    else:
        finish_time, num = heappop(pq)
        if not lst:
            if board[P] == 0:
                tot += finish_time - cur
            board[num] = 0
            cur = finish_time
            cnt += 1
        else:
            a, b = lst[-1]
            if finish_time <= a:
                if board[P] == 0:
                    tot += finish_time - cur

                board[num] = 0
                cur = finish_time
                cnt += 1
            else:
                lst.pop()
                if board[P] == 0:
                    tot += a - cur
                cur = a
                c = find_loc()
                board[c] = 1
                heappush(pq, (b, c))
                heappush(pq, (finish_time, num))

print(tot)
