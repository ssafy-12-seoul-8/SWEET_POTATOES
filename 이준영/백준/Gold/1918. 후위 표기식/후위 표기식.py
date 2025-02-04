# 후위 표기식은 각 연산의 우선순위를 바탕으로 스택을 조작하여 푸는 문제이다
# 연산자가 아니면 바로 출력한다.
# 만약 괄호로 묶여 있으면 괄호안은 괄호가 끝날 때 한번에 출력한다.
# 스택에는 연산자의 우선 순위가 점점 높아지게만 들어가고 그렇지 않다면 다 빼고 현재 연산자를 넣는다.
# 마지막에 남은 스택을 pop하며 출력한다.
import sys

input = sys.stdin.readline

s = input().rstrip()
change = {"+": 0, "-": 0, "*": 1, "/": 1, "(": 2, ")": 2}
stk = []

for i in s:
    if i not in change:
        print(i, end="")
        continue
    if not stk:
        stk.append(i)
    elif i == "(":
        stk.append(i)
    elif i == ")":
        while stk[-1] != "(":
            print(stk.pop(), end="")
        stk.pop()
    elif change[i] <= change[stk[-1]]:
        if change[stk[-1]] == 2:
            stk.append(i)
        else:
            while stk and stk[-1]!="(" and change[i] <= change[stk[-1]]:
                print(stk.pop(), end="")
            stk.append(i)
    else:
        stk.append(i)

while stk:
    print(stk.pop(), end="")
