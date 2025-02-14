# 가로로 a번, 세로로 b번 자를 수 있냐로 방정식을 세운 후 방정식이 두 음아닌 정수해를 가지는지 판별하는 문제
# 판별식이 제곱수인지를 확인하는데 이진탐색 사용
n, k = map(int, input().split())

ans = "NO"
tmp = n * n - 4 * (k - 1 - n)
if k >= n + 1 and tmp >= 0:
    if tmp == 1 or tmp == 0:
        ans = "YES"

    else:
        start = 1
        end = tmp
        while end - start > 1:
            mid = (end + start) // 2

            if mid * mid <= tmp:
                start = mid
            else:
                end = mid

        if start * start == tmp:
            ans = "YES"

print(ans)
