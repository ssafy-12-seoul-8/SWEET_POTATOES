# [Silver II] 용돈 관리 - 6236 

[문제 링크](https://www.acmicpc.net/problem/6236) 

### 성능 요약

메모리: 23168 KB, 시간: 228 ms

### 분류

이분 탐색, 매개 변수 탐색

### 제출 일자

2024년 9월 12일 10:28:04

### 문제 설명

<p>Farmer John is an astounding accounting wizard and has realized he might run out of money to run the farm. He has already calculated and recorded the exact amount of money (1 ≤ money<sub>i</sub> ≤ 10,000) that he will need to spend each day over the next N (1 ≤ N ≤ 100,000) days.</p>

<p>FJ wants to create a budget for a sequential set of exactly M (1 ≤ M ≤ N) fiscal periods called "fajomonths". Each of these fajomonths contains a set of 1 or more consecutive days. Every day is contained in exactly one fajomonth.</p>

<p>FJ's goal is to arrange the fajomonths so as to minimize the expenses of the fajomonth with the highest spending and thus determine his monthly spending limit.</p>

### 입력 

 <ul>
	<li>Line 1: Two space-separated integers: N and M </li>
	<li>Lines 2..N+1: Line i+1 contains the number of dollars Farmer John spends on the ith day</li>
</ul>

### 출력 

 <ul>
	<li>Line 1: The smallest possible monthly limit Farmer John can afford to live with.</li>
</ul>

<p> </p>

