def front(par):
    if par not in child:
        print(par, end="")
        return
    else:
        print(par, end="")
        l, r = child[par]
        if l != ".":
            front(l)
        if r != ".":
            front(r)

def mid(par):
    if par not in child:
        print(par, end="")
        return
    else:
        l, r = child[par]
        if l != ".":
            mid(l)
        print(par, end="")
        if r != ".":
            mid(r)
def back(par):
    if par not in child:
        print(par, end="")
        return
    else:
        l, r = child[par]
        if l != ".":
            back(l)
        if r != ".":
            back(r)
        print(par, end="")


N = int(input())
child = {}
for i in range(N):
    p, l, r = input().split()
    child[p] = (l, r)
front("A")
print()
mid("A")
print()
back("A")