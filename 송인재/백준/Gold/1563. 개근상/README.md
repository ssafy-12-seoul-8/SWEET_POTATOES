# [Gold IV] 개근상 - 1563 

[문제 링크](https://www.acmicpc.net/problem/1563) 

### 성능 요약

메모리: 14312 KB, 시간: 108 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 12월 15일 15:26:14

### 문제 설명

<p>백준중학교에서는 학기가 끝날 무렵에 출결사항을 보고 개근상을 줄 것인지 말 것인지 결정한다. 이 학교는 이상해서 학생들이 학교를 너무 자주 빠지기 때문에, 개근상을 주는 조건이 조금 독특하다.</p>

<p>출결사항이 기록되는 출결은 출석, 지각, 결석이다.</p>

<p>개근상을 받을 수 없는 사람은 지각을 두 번 이상 했거나, 결석을 세 번 연속으로 한 사람이다.</p>

<p>한 학기가 4일이고, O를 출석, L을 지각, A를 결석이라고 했을 때, 개근상을 받을 수 있는 출결정보는</p>

<pre>OOOO OOOA OOOL OOAO OOAA OOAL OOLO OOLA OAOO OAOA 
OAOL OAAO OAAL OALO OALA OLOO OLOA OLAO OLAA AOOO 
AOOA AOOL AOAO AOAA AOAL AOLO AOLA AAOO AAOA AAOL
AALO AALA ALOO ALOA ALAO ALAA LOOO LOOA LOAO LOAA 
LAOO LAOA LAAO</pre>

<p>총 43가지이다.</p>

<p>한 학기는 N일이다. N이 주어졌을 때, 개근상을 받을 수 있는 출결정보의 개수를 세는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. N은 1,000보다 작거나 같다.</p>

### 출력 

 <p>첫째 줄에 정답을 1,000,000으로 나눈 나머지를 출력한다.</p>

