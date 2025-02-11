# 맨 뒤에서부터 연속적으로 출력된 것을 제외하였을 때 끝에서부터 처음으로 나온 문자 사이에서 가장 작은 문자를 출력하면 된다.(되도록이면 앞에)
# 예를 들어 BACDCB의 경우
"""
A
AB
ACB (앞의 C임)
ACCB
ACDCB
BACDCB
"""
import sys

input = sys.stdin.readline

s = input().rstrip()

l = len(s)
check = [False] * l

for i in range(l):
    j = l - 1
    idx = -1

    while check[j]:                     # 뒤에서부터 연속된 이미 출력된 문자 제외
        j -= 1

    idx = j
    m_idx = j       
    while idx >= 0:                     # 그 다음 출력된 수까지 중 가장 작은 수 찾자 (여러 개면 앞에 있는 수)
        if check[idx]:                  # 끝까지 못찾았다는 건 앞에서는 출력된 문자가 없다는 것이므로 
            break                       # 지금의 최소 문자를 출력하면 된다.
        if s[idx] <= s[m_idx]:          # 가장 앞에걸 찾기 위해 등호를 넣었다.
            m_idx = idx
        idx -= 1        

    check[m_idx] = True

    for j in range(l):
        if check[j]:
            print(s[j], end="")
    print()
