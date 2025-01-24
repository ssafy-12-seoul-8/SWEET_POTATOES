n = int(input())
num = [0]*n
for i in range(n):
    num[i] = float(input())
ans = num[0]
cur = 1
for i in range(n):
    if cur<1:
        cur = num[i]
    else:
        cur = num[i] * cur
    ans = max(cur,ans)
print("%.3f"%ans)