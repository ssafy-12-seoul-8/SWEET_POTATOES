# [Gold III] 동전 - 2091 

[문제 링크](https://www.acmicpc.net/problem/2091) 

### 성능 요약

메모리: 17044 KB, 시간: 148 ms

### 분류

브루트포스 알고리즘, 다이나믹 프로그래밍, 그리디 알고리즘

### 제출 일자

2024년 10월 27일 12:46:10

### 문제 설명

<p>Charlie is a driver of Advanced Cargo Movement, Ltd. Charlie drives a lot and so he often buys coffee at coffee vending machines at motorests. Charlie hates change. That is basically the setup of your next task.</p>

<p>Your program will be given numbers and types of coins Charlie has and the coffee price. The coffee vending machines accept coins of values 1, 5, 10, and 25 cents. The program should output which coins Charlie has to use paying the coffee so that he uses as many coins as possible. Because Charlie really does not want any change back he wants to pay the price exactly.</p>

### 입력 

 <p>Each line of the input contains five integer numbers separated by a single space describing one situation to solve. The first integer on the line P, 1 ≤ P ≤ 10 000, is the coffee price in cents. Next four integers, C<sub>1</sub>, C<sub>2</sub>, C<sub>3</sub>, C<sub>4</sub>, 0 ≤ C<sub>i</sub> ≤ 10 000, are the numbers of cents, nickels (5 cents), dimes (10 cents), and quarters (25 cents) in Charlie's valet. The last line of the input contains five zeros and no output should be generated for it.</p>

### 출력 

 <p>For each situation, your program should output one line containing the string "T1 T2 T3 T4.", where T1, T2, T3, T4 are the numbers of coins of appropriate values Charlie should use to pay the coffee while using as many coins as possible. In the case Charlie does not possess enough change to pay the price of the coffee exactly, your program should output "0 0 0 0".</p>

