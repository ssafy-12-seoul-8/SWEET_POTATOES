P = int(input())
for _ in range(P):
    tmp = list(map(int,input().split()))
    tmp_count = 0
    dct = {}
    for i in range(1,21):
        dct[i] = tmp[i]
    for i in range(1,21):
        for j in range(1,21):
            if(tmp[j]==dct[i]):
                break
        tall = tmp[j]
        for k in range(1,j):
            if tmp[k]>tall:
                tmp_count += (j-k)
                for l in range(j,k,-1):
                    tmp[l] = tmp[l-1]
                tmp[k] = tall
                break
    print(tmp[0],tmp_count)