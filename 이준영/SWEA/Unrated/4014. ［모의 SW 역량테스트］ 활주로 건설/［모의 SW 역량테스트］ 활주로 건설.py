def check(lst):
    res = 0
    for i in range(N):
        flag = True
        cur = lst[i][0]
        cnt = 1
        j = 1
        while j < N:
            if cur == lst[i][j]:
                cnt += 1
                j += 1

            elif lst[i][j] == cur + 1:
                if cnt >= X:
                    cur = lst[i][j]
                    cnt = 1
                    j += 1
                else:
                    flag = False
                    break

            elif lst[i][j] == cur - 1:
                if N - j < X:
                    flag = False
                    break
                else:
                    cur = lst[i][j]
                    for _ in range(X - 1):
                        j += 1
                        if cur != lst[i][j]:
                            flag = False
                            break

                    if not flag:
                        break

                    else:
                        cnt = 0
                        j += 1
            else:
                flag = False
                break

        if flag:
            res += 1

    return res


T = int(input())

for tc in range(1, T + 1):
    N, X = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    arr2 = list(zip(*arr))

    cnt1 = check(arr)
    cnt2 = check(arr2)

    print(f'#{tc} {cnt1 + cnt2}')
