# arr: 문제의 문자열들을 저장하는데 각 줄의 옵션을 공백으로 구분하여 단어 리스트가 되게 함
'''
[['New'],
 ['Save','As']]
'''
# location: i번째 옵션의 단축키 위치 (j,k)면 j번째 단어의 k번째 문자가 단축키
# visited: 단축키들을 저장 (대문자로 변환해서 저장)

import sys

input = sys.stdin.readline

N = int(input())
arr = [list(input().rstrip().split()) for _ in range(N)]
location = [(-1, -1)] * N
visited = set([])

for i in range(N):
    l = len(arr[i])
    for j in range(l):
        tmp = arr[i][j][0].upper()
        if tmp not in visited:      # 단어의 첫 글자중 단축키가 아니었던 게 있음
            visited.add(tmp)        # 단축키 집합에 저장
            location[i] = (j, 0)    # 단축키로 지정
            break
    else:                           # 모든 단어의 첫 글자가 단축키
        check = True
        for j in range(l):
            l2 = len(arr[i][j])
            for k in range(1, l2):
                tmp = arr[i][j][k].upper()
                if tmp not in visited:      # 옵션 내의 문자 중 처음으로 나온 단축키가 아닌 문자
                    visited.add(tmp)        # 단축키 집합에 저장
                    location[i] = (j, k)    # 단축키로 지정
                    check = False           # 단축키 골랐다!
                    break
            if not check:                   # 단축키 골랐으니 나가자
                break

for i in range(N):
    l = len(arr[i])
    for j in range(l):
        l2 = len(arr[i][j])
        for k in range(l2):
            if (j, k) == location[i]:
                print(f'[{arr[i][j][k]}]', end="")
            else:
                print(arr[i][j][k], end="")
        print(" ", end="")
    print()
