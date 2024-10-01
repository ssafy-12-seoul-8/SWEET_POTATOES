# [Gold II] 철로 - 13334 

[문제 링크](https://www.acmicpc.net/problem/13334) 

### 성능 요약

메모리: 48404 KB, 시간: 660 ms

### 분류

자료 구조, 우선순위 큐, 정렬, 스위핑

### 제출 일자

2024년 10월 2일 08:49:57

### 문제 설명

<p>There are n persons such that each person commutes from his/her home to his/her office, where his/her home and office are located at different points on a horizontal line. For any two persons A and B, home or office of A can be located at the same point as home or office of B. For the convenience of the persons who commute, we are going to build a railway as a line segment between two points on the horizontal line and operate a rail transport with the stations at points of all homes or offices on the railway. Due to the limited budget, the length of the railway is fixed as d. We want to locate a line segment (railway) L of length d so that the number of persons whose both home and office locations are contained in L is maximized.</p>

<p>Given a positive integer d and n pairs of integers, (h<sub>i</sub>, o<sub>i</sub>), 1 ≤ i ≤ n, where h<sub>i</sub> and o<sub>i</sub> are the home location and the office location of person i, respectively, you write a program which prints the maximum number of persons whose both home and office locations are contained in L over all line segments L of length d.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/13334/1.png" style="height:140px; text-align:center; width:422px"></p>

<p style="text-align:center">Figure 1. Eight pairs of home and office locations.</p>

<p>Consider an example shown in Figure l where n = 8, (h<sub>1</sub>, o<sub>1</sub>) = (5, 40), (h<sub>2</sub>, o<sub>2</sub>) = (35, 25), (h<sub>3</sub>, o<sub>3</sub>) = (10, 20), (h<sub>4</sub>, o<sub>4</sub>) = (10, 25), (h<sub>5</sub>, o<sub>5</sub>) = (30, 50), (h<sub>6</sub>, o<sub>6</sub>) = (50, 60), (h<sub>7</sub>, o<sub>7</sub>) = (30, 25), (h<sub>8</sub>, o<sub>8</sub>) = (80, 100), and d = 30. In this example, the line segment L with red color between 10 and 40 is one of the railway segments which can be located so that the number of persons whose both home and office locations are contained is maximum, thus the answer is 4.</p>

### 입력 

 <p>Your program is to read from standard input. The first line contains an integer n (1 ≤ n ≤ 100,000) where n is the number of persons. In each of the following n lines, a pair of integers, (h<sub>i</sub>, o<sub>i</sub>) are given where h<sub>i</sub> and o<sub>i</sub> are distinct integers between −100,000,000 and 100,000,000, inclusively. The last line has an integer d (1 ≤ d ≤ 200,000,000) that represents the length of the railway segment.</p>

### 출력 

 <p>Your program is to write to standard output. Print exactly one line for the input. The line should contain an integer representing the maximum number of persons whose both home and office locations are contained in L over all line segments L of length d.</p>

