def calc(a,b,op):
    if op=="+":
        return a+b
    if op=="-":
        return a-b
    return a*b

def btk(cur,l_op,l_res,c_res,e):     # 현재 번호, 마지막 연산자, 이전 결과(괄호 전), 현재 결과, 괄호 여부
    global mx
    
    if cur==N-1:
        if e == 0:
            mx = max(mx, calc(c_res,lst[cur],lst[N-2]))
        else:
            mx = max(mx, calc(l_res,calc(c_res,lst[cur],lst[N-2]),l_op))
        return

    if e == 0: 
        btk(cur+2,"+",0,calc(c_res,lst[cur],lst[cur-1]),0)
        btk(cur+2,lst[cur-1],c_res,lst[cur],1)
    else:
        btk(cur+2,"+",0,calc(l_res,calc(c_res,lst[cur],lst[cur-1]),l_op),0)
    
N = int(input())
lst = list(input())
for i in range(0,N,2):
    lst[i] = int(lst[i])

mx = -(1<<31)

if N==1:
    print(lst[0])

else:
    btk(2,"+",0,lst[0],0)
    btk(2,"+",0,lst[0],1)
    print(mx)