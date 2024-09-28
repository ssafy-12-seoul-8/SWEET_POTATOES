# [Gold IV] 합이 0 - 3151 

[문제 링크](https://www.acmicpc.net/problem/3151) 

### 성능 요약

메모리: 15472 KB, 시간: 212 ms

### 분류

이분 탐색, 브루트포스 알고리즘, 정렬, 두 포인터

### 제출 일자

2024년 9월 28일 11:27:44

### 문제 설명

<p>Elly unexpectedly started teaching a programming contest preparation class. Some of the contests there are ACM style, i.e. the contestants must form teams of exactly three persons. After some training it is time for her students to shine – the national student Olympiad has come. Elly must decide which three students will represent her class in the contest. Unfortunately, her students have the following property: the better at coding they are, the worse are their team skills; on the other hand, the better their team skills are, the worse they code. And ACM is a type of contest, where both good coding and team skills are needed.</p>

<p>After the training and some local contests, Elly has a list of the coding skills of all her students. Each of the N contestants has a number between -10000 and 10000, denoting his or her skill. She wants to form the team in such a way, that the sum of the three contestants is zero. This would mean that the team is relatively balanced both for coding and team skills. Given the results of the students, find in how many ways she can choose the team for the contest.</p>

<p>We can summarize the problem in the following way: For given N integers between -10000 and 10000 write a program zerosum, which finds how many (unordered) triples with zero sum there are. </p>

### 입력 

 <p>On the first line of the standard input the integer N – the number of students will be given. On the second line N integers between -10000 and 10000 – the coding skill of each student will be given. (1 ≤ N ≤ 10000, -10000 ≤ A<sub>i</sub> ≤ 10000)</p>

### 출력 

 <p>On the standard output print a single integer – the number of possible teams she can choose from.</p>

