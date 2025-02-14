# start는 가능, end는 불가능
N = int(input())
arr = list(map(int, input().split()))
M = int(input())

sm = 0
mx = 0
for i in arr:
    sm = sm + i
    mx = max(mx, i)
if sm <= M:
    print(mx)
else:   
    start = 0                           # 0원 배정시 반드시 가능
    end = mx                            # else문으로 빠졌으니 달란대로 주면 안됨
    
    while end - start > 1:
        mid = (end + start) // 2        # 상한을 mid로 지정
        tot = 0
        for i in arr:
            tot += min(mid, i)          # mid 혹은 i중 작은 걸 배정

        if tot <= M:                    # 예산안에서 처리가 됐으므로 가능 따라서 start = mid
            start = mid
        else:                           # 불가능하므로 end를 내림
            end = mid

    print(start)
