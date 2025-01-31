str = input()
cnt = 0
stk = []

for i in range(len(str)):
    if str[i] == "(":
        stk.append("(")
    elif str[i - 1] == "(":
        stk.pop()
        cnt += len(stk)
    else:
        stk.pop()
        cnt += 1
print(cnt)
