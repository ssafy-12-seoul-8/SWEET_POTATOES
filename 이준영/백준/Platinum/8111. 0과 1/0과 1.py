from collections import deque

T = int(input())
for _ in range(T):
    n = int(input())
    visited = [0] * n
    flag = False
    if n == 1:
        print(1)
        continue

    dq = deque([(1, 1, 1)])  # 자리수, 본래숫자(2진법기준), n으로 나눈 나머지
    visited[1] = 1
    while dq:
        l, num, tmp = dq.popleft()

        if l == 100:
            break
        for k in range(2):
            tmp2 = (tmp * 10 + k) % n
            if tmp2 == 0:
                flag = True
                ans = num * 2 + k
                binary_str = bin(ans)[2:]
                print(binary_str)
                break

            elif visited[tmp2] == 0:
                visited[tmp2] = 1
                dq.append((l + 1, num * 2 + k, tmp2))

        if flag:
            break

    if not flag:
        print("BRAK")
