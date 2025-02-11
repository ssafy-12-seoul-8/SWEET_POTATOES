# 1~N을 줄 세우기 (순열) 이후 그 리스트를 바탕으로 연산하여 최대값을 갱신하였습니다.
def btk(lst):                   # 1~N 줄 세우기
    if len(lst) == N:                   
        check(lst)
        return

    for i in range(N):          # visited배열로 방문 여부를 관리하여 만듦
        if not visited[i]:
            visited[i] = True
            lst.append(i)
            btk(lst)
            visited[i] = False
            lst.pop()


def check(lst):                 # 만든 리스트를 바탕으로 결과값을 계산하여 mx를 최신화
    global mx

    sm = 0
    for i in range(N - 1):
        sm = sm + abs(arr[lst[i]] - arr[lst[i + 1]])

    mx = max(sm, mx)


N = int(input())
arr = list(map(int, input().split()))
mx = 0
visited = [False] * N
btk([])
print(mx)
