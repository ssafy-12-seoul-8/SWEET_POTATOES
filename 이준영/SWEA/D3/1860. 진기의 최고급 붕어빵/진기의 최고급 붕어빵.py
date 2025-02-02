T = int(input())
for tc in range(1, T + 1):
    N, M, K = map(int, input().split())
    lst = list(map(int, input().split()))
    ans = "Possible"
    lst.sort()
    for i in range(len(lst)):
        num = lst[i] // M * K
        if i + 1 > num:
            ans = "Impossible"
            break
    print(f'#{tc} {ans}')
