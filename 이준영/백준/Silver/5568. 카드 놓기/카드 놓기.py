# 그냥 순서대로 k개를 나열했을 때 서로 다른 것이 얼마나 나오냐 이다.
# 숫자로 바꿀 필요 없이 문자열 연산을 하는 것이 실제 수를 구하는데 더 도움이 되어 문자로 input을 받았다.
def btk(l, lst):
    if l == k:
        tmp = "".join(lst)          # 다 뽑으면 이를 하나의 문자열로 바꾸어 집합에 저장
        st.add(tmp)
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            lst.append(arr[i])
            btk(l + 1, lst)
            lst.pop()
            visited[i] = False


n = int(input())
k = int(input())
arr = [input() for _ in range(n)]
st = set([])
visited = [False] * n
btk(0, [])
print(len(st))
