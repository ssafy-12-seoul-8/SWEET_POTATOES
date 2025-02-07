# 만약 문자의 개수가 홀수인 것이 2개 이상면 불가능, 1개이하면 가능이다.
# 알파벳 순서로 채워 넣을 때 짝수인 것은 반반 앞에서부터 채워넣고
# 홀수인 것은 가운데에 1개, 양끝에 반반씩 채워 넣으면 된다.
# 채워넣을 시작 위치는 cur이라는 변수로 관리한다.

st = input()
cnt = [0] * 26
for i in st:
    cnt[ord(i) - ord("A")] += 1

l = len(st)
ans = [0] * l

if l % 2 == 1:
    check = 1
else:
    check = 0
cur = 0

for i in range(26):
    tmp = cnt[i]
    if tmp == 0:
        continue
    if tmp % 2 == 1:
        if check == 0:
            check = -1
            break
        else:
            check = 0
            ans[l // 2] = chr(ord("A") + i)
            for j in range(cur, cur + tmp // 2 + 1):
                ans[j] = chr(ord("A") + i)
            for j in range(l - cur - tmp // 2, l - cur):
                ans[j] = chr(ord("A") + i)
            cur = cur + tmp // 2
    else:
        for j in range(cur, cur + tmp // 2):
            ans[j] = chr(ord("A") + i)
        for j in range(l - cur - tmp // 2, l - cur):
            ans[j] = chr(ord("A") + i)
        cur = cur + tmp // 2

if check == -1:
    print("I'm Sorry Hansoo")
else:
    print(*ans, sep="")
