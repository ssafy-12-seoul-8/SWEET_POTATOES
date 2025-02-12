# 기본적인 백트래킹을 생각
# 네모네모의 오른쪽 아래를 내가 들어감으로 인해 채워지는지 아닌지를 판별하기 위해 전체 배열을 전역에서 관리함 (0은 빈칸, 1은 생물)
def btk(cur):
    global cnt

    if cur == M * N:
        cnt += 1
        return

    btk(cur + 1)

    y = cur // M
    x = cur % M

    if y > 0 and x > 0 and arr[y - 1][x] == arr[y][x - 1] == arr[y - 1][x - 1] == 1:
        return

    arr[y][x] = 1
    btk(cur + 1)
    arr[y][x] = 0


N, M = map(int, input().split())
arr = [[0] * M for _ in range(N)]
cnt = 0

btk(0)

print(cnt)
