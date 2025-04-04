
def rotate(plane):
    tmp1 = big_rotate[plane]
    tmp2 = small_rotate[plane]

    t_color = [cube[tmp1[9]], cube[tmp1[10]], cube[tmp1[11]]]
    for i in range(11, 2, -1):
        cube[tmp1[i]] = cube[tmp1[i - 3]]
    for i in range(3):
        cube[tmp1[i]] = t_color[i]

    t_color = [cube[tmp2[6]], cube[tmp2[7]]]
    for i in range(7, 1, -1):
        cube[tmp2[i]] = cube[tmp2[i - 2]]
    for i in range(2):
        cube[tmp2[i]] = t_color[i]

big_rotate = {
    "U": [9, 38, 37, 36, 29, 28, 27, 20, 19, 18, 11, 10],
    "D": [15, 16, 17, 24, 25, 26, 33, 34, 35, 42, 43, 44],
    "L": [0, 3, 6, 18, 21, 24, 45, 48, 51, 44, 41, 38],
    "R": [53, 50, 47, 26, 23, 20, 8, 5, 2, 36, 39, 42],
    "F": [6, 7, 8, 27, 30, 33, 47, 46, 45, 17, 14, 11],
    "B": [51, 52, 53, 35, 32, 29, 2, 1, 0, 9, 12, 15]
}

small_rotate = {
    "U": [0, 1, 2, 5, 8, 7, 6, 3],
    "D": [45, 46, 47, 50, 53, 52, 51, 48],
    "L": [11, 14, 17, 16, 15, 12, 9, 10],
    "R": [27, 28, 29, 32, 35, 34, 33, 30],
    "F": [18, 19, 20, 23, 26, 25, 24, 21],
    "B": [36, 37, 38, 41, 44, 43, 42, 39]
}

T = int(input())
for _ in range(T):
    cube = ["w"] * 9 + ["g"] * 9 + ["r"] * 9 + ["b"] * 9 + ["o"] * 9 + ["y"] * 9
    n = int(input())
    lst = list(input().split())
    for s in lst:
        plane = s[0]
        direction = s[1]

        if s[1] == "+":
            rotate(plane)
        else:
            for _ in range(3):
                rotate(plane)

    for i in range(3):
        for j in range(3):
            print(cube[3 * i + j], end="")
        print()
