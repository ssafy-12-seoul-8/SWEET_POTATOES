# [Gold III] 웜홀 - 1865 

[문제 링크](https://www.acmicpc.net/problem/1865) 

### 성능 요약

메모리: 33692 KB, 시간: 1604 ms

### 분류

그래프 이론, 최단 경로, 벨만–포드

### 제출 일자

2025년 11월 6일 11:12:06

### 문제 설명

<p>While exploring his many farms, Farmer John has discovered a number of amazing wormholes. A wormhole is very peculiar because it is a one-way path that delivers you to its destination at a time that is BEFORE you entered the wormhole! Each of FJ's farms comprises N (1 <= N <= 500) fields conveniently numbered 1..N, M (1 <= M <= 2500) paths, and W (1 <= W <= 200) wormholes.</p>

<p>As FJ is an avid time-traveling fan, he wants to do the following: start at some field, travel through some paths and wormholes, and return to the starting field a time before his initial departure. Perhaps he will be able to meet himself :) .</p>

<p>To help FJ find out whether this is possible or not, he will supply you with complete maps to F (1 <= F <= 5) of his farms.  No paths will take longer than 10,000 seconds to travel and no wormhole can bring FJ back in time by more than 10,000 seconds.</p>

### 입력 

 <ul>
	<li>Line 1: A single integer, F. F farm descriptions follow.</li>
	<li>Line 1 of each farm: Three space-separated integers respectively: N, M, and W</li>
	<li>Lines 2..M+1 of each farm: Three space-separated numbers (S, E, T) that describe, respectively: a bidirectional path between S and E that requires T seconds to traverse. Two fields might be connected by more than one path.</li>
	<li>Lines M+2..M+W+1 of each farm: Three space-separated numbers (S, E, T) that describe, respectively: A one way path from S to E that also moves the traveler back T seconds.</li>
</ul>

### 출력 

 <ul>
	<li>Lines 1..F: For each farm, output "YES" if FJ can achieve his goal, otherwise output "NO" (do not include the quotes).</li>
</ul>

<p> </p>

