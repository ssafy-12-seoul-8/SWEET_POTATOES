# 생각해보면 첫번째 연산은 짝수를, 두 번째 연산은 홀수를 만든다.
# 따라서 B를 만들기 위한 연산은 정해져 있으므로 이를 하다가 A가 되는지만 확인하면 된다.
A, B = map(int, input().split())

cnt = 0
while A < B:
    if B % 2 == 0:          # B가 짝수면 이전 연산은 곱하기 2
        B = B // 2
        cnt += 1
    elif B % 10 == 1:       # B가 홀수면 이전 연산은 1붙이기
        B = B // 10
        cnt += 1
    else:                   # 홀수인데 1로 안끝나면 못만든다.
        break               
if A == B:                  # A가 나오면 성공
    print(cnt + 1)
else:                       # 아니면 실패
    print(-1)
