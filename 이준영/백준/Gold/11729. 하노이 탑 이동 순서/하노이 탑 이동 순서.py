import sys

def btk(n, start, end):                 # 옮길 개수, 시작 지점, 끝지점
    if n == 1:
        print(start, end)               # 하나면 바로 옮기면 된다.
        return

    btk(n - 1, start, 6 - start - end)  # 일단 n-1개를 나머지 하나로 옮기고
    print(start, end)                   # 가장 밑의 원판은 마지막에 옮기고
    btk(n - 1, 6 - start - end, end)    # n-1개의 원판을 다시 마저 옮긴다.


N = int(input())

print(2 ** N - 1)

btk(N, 1, 3)
