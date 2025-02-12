# 문제검사를 할 인덱스, 뽑은 문제수, 뽑은 문제 중 최소, 최대, 뽑은 문제들의 합
def btk(cur, cnt, mn, mx, sm):
    global tot

    if sm > R:                                      # 합이 R보다 크면 리턴
        return

    if N - cur + cnt < 2:                           # 나머지 다 뽑아도 2개 안됨
        return

    if cur == N:                                    # 끝까지 봤는데
        if mx - mn >= X and sm >= L:                # 조건 만족시 +1
            tot += 1
        return

    btk(cur + 1, cnt, mn, mx, sm)                   # 현재 문제 안 뽑음

    mn = min(mn, arr[cur])
    mx = max(mx, arr[cur])
    btk(cur + 1, cnt + 1, mn, mx, sm + arr[cur])    # 현재 문제 뽑음


N, L, R, X = map(int, input().split())
arr = list(map(int, input().split()))

tot = 0
btk(0, 0, 1_000_000, 0, 0)

print(tot)
