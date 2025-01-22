c=[0]*10
for i in range(10):
    c[i] = int(input())
score = 0
finalscore = 0
diff = 1000
for i in range(10):
    score += c[i]
    if diff>abs(score-100):
        diff = abs(score-100)
        finalscore = score
    elif diff == abs(score-100):
        finalscore = score
print(finalscore)
