# [Gold I] 놀이 공원 - 1561 

[문제 링크](https://www.acmicpc.net/problem/1561) 

### 성능 요약

메모리: 14908 KB, 시간: 144 ms

### 분류

이분 탐색, 매개 변수 탐색

### 제출 일자

2024년 10월 3일 10:54:39

### 문제 설명

<p>There are M cars on a ride in an amusement park, numbered 1 to M, and N children are waiting in a queue to enter them. </p>

<p>Each car has its ride duration (maximum 30 minutes) and can host only one child at a time. Once a car is empty, the next child in queue enters it. If two cars are empty at the same time, the child enters the one having a smaller number. </p>

<p>Write a program that will calculate number of the car the last child in queue will enter. </p>

### 입력 

 <p>The first line of the input file contains two integers N and M separated by a whitespace. N is the number of children in queue and M is number of cars on a ride, 1 ≤ N ≤ 2,000,000,000; 1 ≤ M ≤ 10000. </p>

<p>The next line consists of M integers separated by whitespaces. These integers represent durations of rides for each of M cars given in minutes. Each of these numbers will be not less than 1 and not greater than 30.</p>

### 출력 

 <p>The first and the only line of the output file should contain the number of the car as defined above. </p>

