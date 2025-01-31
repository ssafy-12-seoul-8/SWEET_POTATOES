str = input()
cnt = 10
cur = str[0]
for i in range(1,len(str)):
    if cur == str[i]:
        cnt+=5
    else:
        cnt+=10
        cur = str[i]
print(cnt)