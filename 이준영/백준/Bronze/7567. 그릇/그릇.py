str = input()
cnt = 10
cur = str[0]
for i in range(1, len(str)):
    if cur == str[i]:           # 원래 그릇과 놓으려고 하는 그릇의 방향이 같다면 높이를 5만 더해준다.
        cnt += 5
    else:
        cnt += 10               # 원래 그릇과 놓으려고 하는 그릇의 방향이 다르면 높이를 10 더해주고
        cur = str[i]            # 최신 그릇의 상태를 수정
print(cnt)
