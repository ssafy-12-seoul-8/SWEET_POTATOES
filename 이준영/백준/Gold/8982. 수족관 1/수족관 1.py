N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
if N <= 4:
    print(0)
else:
    depth = []
    dep = lst[1][1]
    cur = 0
    for i in range(2, N):
        if i % 2 == 0:
            nxt = lst[i][0]
            depth.append((dep, cur, nxt))
            cur = nxt
        else:
            dep = lst[i][1]

    l = len(depth)
    hole = [0] * l
    K = int(input())
    for _ in range(K):
        a, b, c, d = map(int, input().split())

        if a >= depth[l - 1][1]:
            left = l - 1
        else:
            left = 0
            right = l - 1
            while right - left > 1:
                mid = (left + right) // 2
                if depth[mid][1] > a:
                    right = mid
                else:
                    left = mid

        hole[left] = 1

    tot = 0
    for i in range(l):
        if hole[i] == 1:
            continue

        cur_depth = depth[i][0]
        l_num, r_num = i - 1, i + 1
        l_depth, r_depth = cur_depth, cur_depth

        # 왼쪽
        while l_num >= 0:
            l_depth = min(l_depth, depth[l_num][0])
            if hole[l_num] == 1:
                break
            l_num -= 1

        if l_num == -1:
            l_depth = 0

        # 오른쪽
        flag = False
        while r_num < l:
            r_depth = min(r_depth, depth[r_num][0])
            if hole[r_num] == 1:
                break
            r_num += 1

        if r_num == l:
            r_depth = 0
        tot += (depth[i][2] - depth[i][1]) * (max(0, (cur_depth - max(l_depth, r_depth))))

    print(tot)
