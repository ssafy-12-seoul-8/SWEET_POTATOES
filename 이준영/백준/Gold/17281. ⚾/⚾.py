import sys

input = sys.stdin.readline


def btk(cur):
    if cur == 9:
        order[0] = order[3]
        order[3] = 0
        check()
        order[3] = order[0]
        return

    for i in range(1, 9):
        if visited[i] == 0:
            visited[i] = 1
            order[cur] = i
            btk(cur + 1)
            visited[i] = 0


def check():
    global mx
    score = 0
    start = 0
    for i in range(N):
        if mx >= score + 24 * (N - i):
            return
        out = 0
        lst = []
        while out < 3:
            if arr[i][order[start]] == 0:
                out += 1
            else:
                lst.append(arr[i][order[start]])
            start = (start + 1) % 9

        l = len(lst)
        sm = 0
        for j in range(l - 1, -1, -1):
            sm = sm + lst[j]
            if sm >= 4:
                score += (j + 1)
                break
    mx = max(mx, score)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

mx = 0
order = [0] * 9
visited = [0] * 9
btk(1)
print(mx)
