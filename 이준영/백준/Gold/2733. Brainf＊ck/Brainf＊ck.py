import sys
input = sys.stdin.readline
st =set("<>+-.[]")
T = int(input())
for tc in range(1,T+1):
    print(f'PROGRAM #{tc}:')
    tot = []
    while True:
        lst = input().rstrip()
        if lst=="end":
            break

        for i in lst:
           
            if i=="%":
                break

            if i not in st:
                continue

            tot.append(i)
    dct = {}
    stk = []
    flag = True
    for i in range(len(tot)):
        if tot[i] == "[":
            stk.append(i)
        elif tot[i]=="]":
            if not stk:
                flag = False
                break

            j = stk.pop()
            dct[i] = j
            dct[j] = i

    if stk:
        flag = False

    if not flag:
        print("COMPILE ERROR")
        continue

    pointer = 0
    value = [0]*32768

    ans = []
    i = 0
    while i<len(tot):
        com = tot[i]

        if com==">":
            pointer = (pointer+1)%32768
            i+=1
        elif com=="<":
            pointer = (pointer-1)%32768
            i+=1
        elif com=="+":
            value[pointer] = (value[pointer]+1)%256
            i+=1
        elif com=="-":
            value[pointer]=(value[pointer]-1)%256
            i+=1
        elif com==".":
            ans.append(chr(value[pointer]))
            i+=1
        elif com=="[":
            if value[pointer]==0:
                i = dct[i]
            else:
                i+=1
        elif com=="]":
            if value[pointer]!=0:
                i = dct[i]
            else:
                i+=1

    print("".join(ans))
                
    
                
    
                

        