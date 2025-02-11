# 일반적인 구현
# 사진틀에 게시된 사진을 딕셔너리에 저장 번호:(추천횟수,마지막추천번호)
# 사진틀이 다 차지 않으면 그냥 추가
# 이미 추천된 사진은 그냥 cnt만 더함
# 사진이 다 찼으면 가장 추천횟수가 적은 사진을 빼자(그런 사진이 여러개면 가장 오래된 추천 가진 사진 제외) 

N = int(input())
K = int(input())
arr = list(map(int, input().split()))
photo = {}

for i in range(K):
    if arr[i] not in photo:
        if len(photo) == N:
            mn = 1001
            mn_idx = -1

            for j in photo:
                if photo[j][0] < mn:
                    mn = photo[j][0]
                    mn_idx = j
                elif photo[j][0] == mn:
                    if photo[j][1] < photo[mn_idx][1]:
                        mn_idx = j
            del photo[mn_idx]

        photo[arr[i]] = (1, i)  # (추천횟수, 마지막 추천)

    else:
        cnt, l_idx = photo[arr[i]]
        photo[arr[i]] = (cnt + 1, l_idx)


ans = list(photo.keys())
ans.sort()
print(*ans)
