import heapq

T = int(input())
for tc in range(1, T + 1):
    k = int(input())
    max_heap = []
    min_heap = []
    heapq.heapify(max_heap)
    heapq.heapify(min_heap)
    dct = {}
    for i in range(k):
        a, b = input().split()
        if a == "I":
            b = int(b)
            heapq.heappush(max_heap, -b)
            heapq.heappush(min_heap, b)
            if b in dct:
                dct[b] += 1
            else:
                dct[b] = 1
        else:
            if b == "-1":
                if not min_heap:
                    continue
                tmp = heapq.heappop(min_heap)
                while tmp not in dct and min_heap:
                    tmp = heapq.heappop(min_heap)
                if tmp in dct:
                    dct[tmp] -= 1
                    if dct[tmp] == 0:
                        del dct[tmp]
                else:
                    continue
            else:
                if not max_heap:
                    continue
                tmp = heapq.heappop(max_heap)
                while -tmp not in dct and max_heap:
                    tmp = heapq.heappop(max_heap)
                if -tmp in dct:
                    dct[-tmp] -= 1
                    if dct[-tmp] == 0:
                        del dct[-tmp]
                else:
                    continue
    if not dct.values():
        print("EMPTY")
    else:
        mn = heapq.heappop(min_heap)
        while mn not in dct:
            mn = heapq.heappop(min_heap)
        mx = heapq.heappop(max_heap)
        while -mx not in dct:
            mx = heapq.heappop(max_heap)
        print(-mx, mn)


