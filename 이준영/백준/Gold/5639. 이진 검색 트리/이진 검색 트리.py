import sys

sys.setrecursionlimit(100000)


def back(lst):
    if not lst:
        return
    if len(lst) == 1:
        print(lst[0])
        return

    bound = 1
    for i in range(1, len(lst)):
        if lst[i] > lst[0]:
            bound = i
            break

    back(lst[1:bound])
    back(lst[bound:])
    print(lst[0])


arr = []
while True:
    try:
        arr.append(int(input()))
    except:
        break

back(arr)
