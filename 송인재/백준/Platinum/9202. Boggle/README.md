# [Platinum V] Boggle - 9202 

[문제 링크](https://www.acmicpc.net/problem/9202) 

### 성능 요약

메모리: 49008 KB, 시간: 6628 ms

### 분류

백트래킹, 브루트포스 알고리즘, 자료 구조, 깊이 우선 탐색, 그래프 이론, 그래프 탐색, 문자열, 트리, 트라이

### 제출 일자

2024년 10월 29일 20:07:50

### 문제 설명

<p>I am sure, you are a big fan of the board game “Boggle”. Don’t worry if you are not familiar with the rules, I will explain them to you. A Boggle is a 4 × 4 grid of letters where your job is to find as many words as you can. If I play Boggle with (or against) my wife, she always wins – the loser (that’s me) then always has to do all these little jobs like to take out the trash. So, please help me to win again.</p>

<p>Words in a Boggle can be constructed from adjacent letters (i.e. horizontally, vertically and diagonally), but the same dice may only be used once in a word. The words have to be listed in our dictionary to be valid.</p>

<p>Words with 1 or 2 letters count 0 points, words with 3 or 4 letters 1 point, 5 letters 2 points, 6 letters 3 points, 7 letters 5 points. 8 letter words will give 11 points. If you ﬁnd more than one word (and I hope you do), points will be summed up to form your score.</p>

### 입력 

 <p>There is only one test case per ﬁle. The first line contains the number of words w in the dictionary (1 < w < 300 000). Then follow w lines, each containing one word. Words consist of up to 8 upper case letters (’A’-’Z’). After the dictionary specification, there is a blank line. Then follows the number of Boggle boards b in one line (1 < b < 30). Each boggle is given as a 4 × 4 grid of upper case letters in four lines. Boggles are separated by blank lines.</p>

### 출력 

 <p>For each boggle, print one line containing the maximal possible score, the longest word and number of found words. Words that are twice (or more often) in one Boggle, only count once. If there is more than one longest word, print the lexicographically smallest one. You may safely assume that there is at least one valid word in each Boggle.</p>

