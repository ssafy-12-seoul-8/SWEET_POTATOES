import sys

input = sys.stdin.readline
A = input().rstrip()
B = input().rstrip()

stk = [0]*1000000
cur = 0

for i in range(len(A)):
    stk[cur] = A[i]
    cur+=1
    if cur<len(B):
        continue
    elif stk[cur-1] != B[-1]:
        continue
    else:
        start = cur - 1
        for j in range(len(B)):
            if stk[start-j] != B[-j-1]:
                break
        else:
            cur = cur - len(B)

if cur == 0:
    print("FRULA")
else:
    print(*stk[:cur], sep="")
