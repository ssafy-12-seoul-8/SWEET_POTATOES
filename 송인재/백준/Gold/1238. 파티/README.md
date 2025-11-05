# [Gold III] 파티 - 1238 

[문제 링크](https://www.acmicpc.net/problem/1238) 

### 성능 요약

메모리: 99172 KB, 시간: 608 ms

### 분류

그래프 이론, 최단 경로, 데이크스트라

### 제출 일자

2025년 11월 5일 15:44:26

### 문제 설명

<p>One cow from each of N farms (1 <= N <= 1000) conveniently numbered 1..N is going to attend the big cow party to be held at farm #X (1 <= X <= N). A total of M (1 <= M <= 100,000) unidirectional (one-way) roads connects pairs of farms; road i requires Ti (1 <= Ti <= 100) units of time to traverse.</p>

<p>Each cow must walk to the party and, when the party is over, return to her farm. Each cow is lazy and thus picks an optimal route with the shortest time. A cow's return route might be different from her original route to the party since roads are one-way.</p>

<p>Of all the cows, what is the longest amount of time a cow must spend walking to the party and back?</p>

### 입력 

 <p>* Line 1: Three space-separated integers, respectively: N, M, and X</p>

<p>* Lines 2..M+1: Line i+1 describes road i with three space-separated integers: Ai, Bi, and Ti. The described road runs from farm Ai to farm Bi, requiring Ti time units to traverse.</p>

### 출력 

 <p>* Line 1: One integer: the maximum of time any one cow must walk.</p>

<p> </p>

