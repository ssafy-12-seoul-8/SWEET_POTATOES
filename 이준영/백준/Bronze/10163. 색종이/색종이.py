import sys
input = sys.stdin.readline

N = int(input())
pap = [[0 for _ in range(1001)]for _ in range(1001)]
for i in range(1,N+1):
    rec = list(map(int,input().split()))
    for j in range(rec[2]):
        for k in range(rec[3]):
            pap[rec[0]+j][rec[1]+k] = i
pap_count = [0]*(N+1)
for i in range(1001):
    for j in range(1001):
        pap_count[pap[i][j]]+=1
for i in range(1,N+1):
    print(pap_count[i])