from collections import deque
def make_per(lst):
    if len(lst)==N:
        perm.append(lst[:])
        return

    for i in range(N):
        if t_visited[i]==0:
            t_visited[i] = 1
            lst.append(i)
            make_per(lst)
            lst.pop()
            t_visited[i] = 0
            
    
N = int(input())
lst = list(map(int,input().split()))
damage= [9,3,1]
visited = set()

dq= deque([lst+[0]])
perm = []
t_visited = [0]*N
make_per([])

visited.add(tuple(lst))
while dq:
    tmp = dq.popleft()
    t_lst = tmp[:-1]
    dis = tmp[-1]
    if t_lst==[0]*N:
        print(dis)
        break
    for order in perm:
        ttmp = [0]*N
        for i in range(N):
            ttmp[i] = max(0,tmp[i]-damage[order[i]])
        if tuple(ttmp) not in visited:
            visited.add(tuple(ttmp))
            dq.append(ttmp+[dis+1])

        
        