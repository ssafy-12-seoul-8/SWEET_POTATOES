# 도시의 크기 N : 1<=N<=2000 ( 1도 가능함 )
N=int(input())
# . : 빈칸, O : 건물, X : 건물 잔해, B : 폭탄이 설치된 칸
arr=[list(input()) for _ in range(N)]

v=[[0]*N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if arr[i][j] == "O":
            for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                for mul in range(1, N):
                    ni, nj = i + di * mul, j + dj * mul
                    if not (0 <= ni < N and 0 <= nj < N): break  # 범위 밖이면 멈추고
                    if arr[ni][nj] != ".":    # 잔해가 있으면 괜찮고
                        break
                    v[ni][nj]=1

for i in range(N):
    for j in range(N):
        if arr[i][j]=="." and v[i][j]==0:
            arr[i][j]="B"

for row in arr:
    print(*row,sep="")

# 쓸데없는 폭탄 있어도 되능가..?
# 절대 있으면 안 되는 곳만 빼고 다 넣자