# 백트래킹인데 내부에 변수를 많이 잡았다.
# check가 False이면 start팀, True면 link팀이다.
def btk(cur, s_cnt, l_cnt, s_score, l_score):               # 현재 검사할 인덱스, 스타트팀인원, 링크팀 인원, 스타트팀 점수, 링크팀 점수
    global mn

    if s_cnt == N // 2 and l_cnt == N // 2:                 # 반반 잘 나눠지면 점수 갱신
        mn = min(mn, abs(s_score - l_score))
        return
    
    if cur == N:                                            # 반반 안나눠짐
        return

    if s_cnt + N - cur < N // 2 or l_cnt + N - cur < N // 2:# 나머지를 몰빵해도 반반 절대 안됨
        return

    tmp1 = tmp2 = 0
    for i in range(cur):
        if not check[i]:
            tmp1 += (arr[i][cur] + arr[cur][i])             # tmp1은 cur이 s팀에 갈 때 더해지는 점수
        else:
            tmp2 += (arr[i][cur] + arr[cur][i])             # tmp2는 cur이 l팀에 갈 때 더해지는 점수

    check[cur] = False
    btk(cur + 1, s_cnt + 1, l_cnt, s_score + tmp1, l_score)
    check[cur] = True
    btk(cur + 1, s_cnt, l_cnt + 1, s_score, l_score + tmp2)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
check = [False] * N

mn = 4501
btk(0, 0, 0, 0, 0)
print(mn)
