# [Gold II] 공항 - 10775 

[문제 링크](https://www.acmicpc.net/problem/10775) 

### 성능 요약

메모리: 23640 KB, 시간: 220 ms

### 분류

자료 구조, 그리디 알고리즘, 분리 집합

### 제출 일자

2025년 11월 27일 00:58:37

### 문제 설명

<p>For your birthday, you were given an airport.</p>

<p>The airport has G gates, numbered from 1 to G.</p>

<p>P planes arrive at the airport, one after another. You are to assign the ith plane to permanently dock at any gate 1, . . . , g<sub>i</sub> (1 ≤ g<sub>i</sub> ≤ G), at which no previous plane has docked. As soon as a plane cannot dock at any gate, the airport is shut down and no future planes are allowed to arrive.</p>

<p>In order to keep the person who gave you the airport happy, you would like to maximize the number of planes starting from the beginning that can all dock at different gates.</p>

### 입력 

 <p>The first line of input contains G (1 ≤ G ≤ 10<sup>5</sup>), the number of gates at the airport.</p>

<p>The second line of input contains P (1 ≤ P ≤ 10<sup>5</sup>), the number of planes which will land.</p>

<p>The next P lines contain one integer g<sub>i</sub> (1 ≤ g<sub>i</sub> ≤ G), such that the ith plane must dock at some gate from 1 to g<sub>i</sub>, inclusive.</p>

<p>Note that for at least 40% of the marks for this question, P ≤ 2000 and G ≤ 2000.</p>

### 출력 

 <p>Output the maximum number of planes that can land starting from the beginning.</p>

