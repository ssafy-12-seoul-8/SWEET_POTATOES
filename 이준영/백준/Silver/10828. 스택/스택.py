import sys

input = sys.stdin.readline
lst = []
N = int(input())

for _ in range(N):
    s = list(input().rstrip().split())
    if s[0] == "push":
        lst.append(int(s[1]))
    elif s[0] == "pop":
        if not lst:
            print(-1)
        else:
            print(lst.pop())
    elif s[0] == "size":
        print(len(lst))
    elif s[0] == "empty":
        if not lst:
            print(1)
        else:
            print(0)
    else:
        if not lst:
            print(-1)
        else:
            print(lst[-1])
