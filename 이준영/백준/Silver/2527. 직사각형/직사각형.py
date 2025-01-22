for _ in range(4):
    tmp = list(map(int,input().split()))
    if(tmp[0]<tmp[6] and tmp[2]>tmp[4] and tmp[1]<tmp[7] and tmp[3]>tmp[5]):
        print("a")
    elif(tmp[0]>tmp[6] or tmp[2]<tmp[4] or tmp[1]>tmp[7] or tmp[3]<tmp[5]):
        print("d")
    elif((tmp[0]==tmp[6] and tmp[1]==tmp[7]) or (tmp[0]==tmp[6] and tmp[3]==tmp[5]) or (tmp[2]==tmp[4] and tmp[1]==tmp[7])
        or (tmp[2]==tmp[4] and tmp[3]==tmp[5])):
        print("c")
    else:
        print("b")