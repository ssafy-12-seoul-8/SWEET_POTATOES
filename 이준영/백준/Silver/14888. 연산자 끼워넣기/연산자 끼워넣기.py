# 연산을 할 때 나눗셈만 주의하면 된다. (음수 나눗셈을 그냥 나눗셈을 하면 안됨)
def calc(num1, num2, c):            # c가 0,1,2,3일 때 각각 덧셈, 뺄셈, 곱셈, 나눗셈을 해서 결과를 리턴
    if c == 0:
        return num1 + num2
    if c == 1:
        return num1 - num2
    if c == 2:
        return num1 * num2

    if num1 >= 0:
        return num1 // num2
    else:
        return - ((-num1) // num2)


def btk(cur, res):                  # 연산을 몇 번 했는지, 결과
    global mn, mx

    if cur == N - 1:                # 연산 다하면 mx, mn을 갱신
        mx = max(mx, res)
        mn = min(mn, res)
        return

    for i in range(4):                          # 만약 해당 연산을 할 수 있으면 하자
        if cnt[i] >= 1:
            cnt[i] -= 1
            tmp = calc(res, arr[cur + 1], i)
            btk(cur + 1, tmp)
            cnt[i] += 1


N = int(input())
arr = list(map(int, input().split()))
cnt = list(map(int, input().split()))

mn = 10 ** 9 + 1
mx = - mn

btk(0, arr[0])

print(mx)
print(mn)
