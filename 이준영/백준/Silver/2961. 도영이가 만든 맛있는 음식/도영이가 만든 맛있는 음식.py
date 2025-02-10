# 제출횟수: 회
# 메모리: KB
# 시간: ms

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
mn = abs(arr[0][0] - arr[0][1])  # 초기값은 1번 재료만 사용했을 때로 지정

for i in range(1, 1 << N):
    s = 1
    b = 0
    for j in range(N):
        if i & (1 << j) != 0:
            s = s * arr[j][0]
            b = b + arr[j][1]

    mn = min(mn, abs(s - b))

print(mn)
