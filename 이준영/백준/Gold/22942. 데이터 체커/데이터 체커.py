'''
구상: 일단 각 원의 왼쪽 끝과 오른쪽 끝을 저장한다. (1번 원의 왼쪽끝이 -2, 오른쪽 끝이 3이면 (-2,-1),(3,1) 이런식으로 저장)
이 떄 끝이 만나도 교점이 생기는 것이므로 set으로 각 원의 끝 좌표들을 set에 저장한다.)
즉 끝 좌표를 저장할 때 먼저 set에 있는지 확인하고 없을 떄만 저장, 있으면 break
리스트를 오름차순으로 정렬한 후 순차적으로 검사할 것인데 스택을 사용할 것
만약 이 전에 있는 것과 이번에 넣는 것에 대해 만약 1번 인덱스가 음수이면 넣고 양수라면 스택의 탑과 비교한다.
만약 쌍이 맞으면 pop하고 그렇지 않다면 불가능한 것이다.
'''

N = int(input())
lst = []
check = True
st = set([])
for i in range(1, N + 1):
    a, b = map(int, input().split())
    if a - b in st or a + b in st:
        check = False
    else:
        st.add(a - b)
        st.add(a + b)
        lst.extend([(a - b, -i), (a + b, i)])
if not check:
    print("NO")  # 원들 중 끝점이 같은 경우가 있는 것이므로 조건을 만족하지 않는다.
else:
    lst.sort()  # 끝점 순서대로 정렬, 중복이 없음
    stk = []  # 인덱스를 저장할 스택
    for tmp in lst:
        a, b = tmp
        if b < 0:  # 만약 음수이면 왼쪽 끝이므로 일단 넣는다.
            stk.append(b)
        else:
            if stk[-1] + b == 0:  # 양수이면 오른쪽 끝인데 이 떄 가장 최근 것이 내 왼쪽 끝이 맞으면 pop
                stk.pop()
            else:  # 그렇지 않으면 조건을 만족하지 않는 것
                check = False
                break
    if not check:
        print("NO")
    else:
        print("YES")
