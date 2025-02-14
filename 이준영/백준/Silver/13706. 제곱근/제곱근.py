# 가끔 이진탐색할 때 쓰는 제 방법인데
# 왼쪽은 불가능, 오른쪽은 가능 혹은 그 반대로 설정하여 하는 경우가 있습니다.
# 이 문제의 경우 start는 제곱해서 N이하가 되고, end는 N초과가 되게 설정하였습니다.
N = int(input())

if N == 1:
    print(1)
else:
    start = 1
    end = N
    while end - start > 1:                              # 차이가 1일 때 멈추면 start 제곱시 N이 됩니다.   
        mid = (end + start) // 2
        if mid * mid > N:
            end = mid
        else:
            start = mid

    print(start)


