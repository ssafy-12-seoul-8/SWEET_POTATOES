N,M = map(int,input().split())
paper_count = 0
paper_location = [0]*N
for i in range(N):
    paper_location[i] = list(map(int,input().split()))

for i in range(1,101):
    for j in range(1,101):
        tmp_count = 0
        for k in range(N):
            if (paper_location[k][0]<=j<=paper_location[k][2] and paper_location[k][1]<=i<=paper_location[k][3]):
                tmp_count+=1
        if tmp_count>M:
            paper_count+=1

print(paper_count)
