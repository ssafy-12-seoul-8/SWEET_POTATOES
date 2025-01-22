import sys
input = sys.stdin.readline
n = int(input())
road = [[]for _ in range(n+1)]
visited = [False]*(n+1)
m = int(input())
for _ in range(m):
    a,b = map(int,input().split())
    road[a].append(b)
    road[b].append(a)
stack = [1]
count = -1
while stack:
    tmp = stack.pop()
    if not visited[tmp]:
        count+=1
        visited[tmp] = True
        for i in road[tmp]:
            if not visited[i]:
                stack.append(i)
print(count)