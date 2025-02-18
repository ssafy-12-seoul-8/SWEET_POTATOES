# 결국엔 N개의 온전한 탑을 start에서 end로 옮기기 위해서는
# N-1개를 start에서 나머지 칸으로 옮기고 (칸이 1,2,3이니까 6-start-end를 하면 나머지 칸이 된다.)
# 큰 원판을 start에서 end로 옮긴 후
# N-1개를 마저 end로 옮기면 된다.
def hanoi(cnt, start, end):
    if cnt == 1:
        print(start, end)
        return

    hanoi(cnt - 1, start, 6 - start - end)
    print(start, end)
    hanoi(cnt - 1, 6 - start - end, end)


N = int(input())
print((1 << N) - 1)

hanoi(N, 1, 3)
