T = int(input())
big_rotate = {"U": [6, 7, 8, 27, 30, 33, 47, 46, 45, 17, 14, 11],
              "D": [51, 52, 53, 35, 32, 29, 2, 1, 0, 9, 12, 15],
              "F": [24, 25, 26, 33, 34, 35, 42, 43, 44, 15, 16, 17],
              "B": [11, 10, 9, 38, 37, 36, 29, 28, 27, 20, 19, 18],
              "L": [0, 3, 6, 18, 21, 24, 45, 48, 51, 44, 41, 38],
              "R": [53, 50, 47, 26, 23, 20, 8, 5, 2, 36, 39, 42],
              }
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
    for i in range(54):
        match i // 9:
            case 0:
                cube[i] = "o"
            case 1:
                cube[i] = "g"
            case 2:
                cube[i] = "w"
            case 3:
                cube[i] = "b"
            case 4:
                cube[i] = "y"
            case 5:
                cube[i] = "r"

    lst = input().split()
    for s in lst:
        t, d = s[0], s[1]
        tmp1 = big_rotate[t]
        tmp2 = small_rotate[t]

        if d == "+":
            t_arr = []
            for i in (9, 10, 11):
                t_arr.append(cube[tmp1[i]])
            for i in range(11, 2, -1):
                cube[tmp1[i]] = cube[tmp1[i - 3]]
            for i in range(3):
                cube[tmp1[i]] = t_arr[i]

            t_arr = []
            for i in (6, 7):
                t_arr.append(cube[tmp2[i]])
            for i in range(7, 1, -1):
                cube[tmp2[i]] = cube[tmp2[i - 2]]
            for i in (0, 1):
                cube[tmp2[i]] = t_arr[i]

        else:
            t_arr = []
            for i in (0, 1, 2):
                t_arr.append(cube[tmp1[i]])
            for i in range(9):
                cube[tmp1[i]] = cube[tmp1[i + 3]]
            for i in range(3):
                cube[tmp1[i + 9]] = t_arr[i]

            t_arr = []
            for i in (0, 1):
                t_arr.append(cube[tmp2[i]])
            for i in range(6):
                cube[tmp2[i]] = cube[tmp2[i + 2]]
            for i in (0, 1):
                cube[tmp2[i + 6]] = t_arr[i]

    for i in range(3):
        for j in range(3):
            print(cube[18 + 3 * i + j], end="")
        print()
