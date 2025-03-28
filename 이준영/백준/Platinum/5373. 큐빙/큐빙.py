# 리팩토링 코드 (반시계 방향을 그냥 배열을 뒤집는 것으로 반영)
# 어떤 면을 기준으로 할 때 12개의 숫자들이 3칸씩 돌아가게 되고
# 회전한 면은 8개의 숫자가 2개씩 돌아가게 된다.
# 그 2개의 정보를 미리 저장해 놓고 회전의 유형에 따라 큐브를 돌렸다.
# cube의 경우 전개도를 그려서 숫자를 0~53을 매겼다.
# 0~8: 뒷면, 9~17: 왼쪽면, 18~26: 윗면, 27~35: 오른쪽면, 36~44:아랫면, 45~53:앞면


T = int(input())
# 각 면을 기준으로 시계방향으로 돌리게 되면 오른쪽으로 3칸씩 간다.
# 예를 들어 U+의 경우 27번 칸에 6번이, 30번칸에 7번칸이 가는 등....
# 반시계 방향은 위와 반대로 왼쪽으로 3칸씩 간다.
# 예를 들어 U-의 경우 6번칸에 27번이, 7번칸에 30번이 간다.
big_rotate = {"U": [6, 7, 8, 27, 30, 33, 47, 46, 45, 17, 14, 11],
              "D": [51, 52, 53, 35, 32, 29, 2, 1, 0, 9, 12, 15],
              "F": [24, 25, 26, 33, 34, 35, 42, 43, 44, 15, 16, 17],
              "B": [11, 10, 9, 38, 37, 36, 29, 28, 27, 20, 19, 18],
              "L": [0, 3, 6, 18, 21, 24, 45, 48, 51, 44, 41, 38],
              "R": [53, 50, 47, 26, 23, 20, 8, 5, 2, 36, 39, 42],
              }

# 각 면을 기준으로 시계방향으로 돌리게 되면 오른쪽으로 2칸씩 간다.
# 예를 들어 U+의 경우 20번칸에 18번이, 23번칸에 19번이 가는 등...
# 반시계는 왼쪽으로 2칸씩 간다.
small_rotate = {"U": [18, 19, 20, 23, 26, 25, 24, 21],
                "D": [42, 39, 36, 37, 38, 41, 44, 43],
                "F": [45, 46, 47, 50, 53, 52, 51, 48],
                "B": [0, 1, 2, 5, 8, 7, 6, 3],
                "L": [11, 14, 17, 16, 15, 12, 9, 10],
                "R": [33, 30, 27, 28, 29, 32, 35, 34],
                }


for _ in range(T):
    n = int(input())

    cube = [0] * 54

    # 큐브 칠하기
    for i in range(54):

        match i // 9:               # 9로 나눈 몫으로 색을 정할 수 있다.
            case 0:                 # 뒷 면
                cube[i] = "o"
            case 1:                 # 왼쪽 면
                cube[i] = "g"
            case 2:                 # 윗 면
                cube[i] = "w"
            case 3:                 # 오른쪽 면
                cube[i] = "b"
            case 4:                 # 아랫 면
                cube[i] = "y"
            case 5:                 # 앞 면
                cube[i] = "r"

    lst = input().split()

    for s in lst:
        t, d = s[0], s[1]           # t는 돌릴 면, d는 방향
        tmp1 = big_rotate[t]        # 대회전 배열
        tmp2 = small_rotate[t]      # 소회전 배열

        # 시계 방향 회전
        if d == "-":                # 반시계면 배열을 뒤집자.
            tmp1 = tmp1[::-1]
            tmp2 = tmp2[::-1]

        # 대회전 (12개 칸 회전)
        t_arr = []
        for i in (9, 10, 11):                       # t_arr에 배열의 9,10,11 번 인덱스에 해당하는 칸의 색을 저장
            t_arr.append(cube[tmp1[i]])

        for i in range(11, 2, -1):                  # 3칸씩 당기면서 색을 옮겨줌
            cube[tmp1[i]] = cube[tmp1[i - 3]]

        for i in range(3):                          # 처음 임시 배열의 색으로 3개 칸을 칠해줌
            cube[tmp1[i]] = t_arr[i]

        # 소회전 (8개 칸 회전)
        t_arr = []
        for i in (6, 7):                            # 6,7번 인덱스에 해당하는 칸의 색 저장
            t_arr.append(cube[tmp2[i]])

        for i in range(7, 1, -1):                   # 2칸씩 당기면서 색을 옮겨줌
            cube[tmp2[i]] = cube[tmp2[i - 2]]

        for i in (0, 1):                            # 처음 임시 배열의 색으로 2개 칸을 칠해줌
            cube[tmp2[i]] = t_arr[i]

    for i in range(3):                              # 윗면 출력
        for j in range(3):
            print(cube[18 + 3 * i + j], end="")
        print()
