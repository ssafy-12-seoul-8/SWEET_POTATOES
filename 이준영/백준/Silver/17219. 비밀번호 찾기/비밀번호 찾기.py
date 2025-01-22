import sys
input = sys.stdin.readline
N, M = map(int,input().split())
pw = {}
for _ in range(N):
    id, ps = input().rstrip().split()
    pw[id] = ps
for _ in range(M):
    id = input().rstrip()
    print(pw[id])