# [Gold V] 적록색약 - 10026 

[문제 링크](https://www.acmicpc.net/problem/10026) 

### 성능 요약

메모리: 16636 KB, 시간: 128 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 8월 22일 18:07:06

### 문제 설명

<p>A little known fact about cows is the fact that they are red-green colorblind, meaning that red and green look identical to them.  This makes it especially difficult to design artwork that is appealing to cows as well as humans.</p>

<p>Consider a square painting that is described by an N x N grid of characters (1 <= N <= 100), each one either R (red), G (green), or B (blue).  A painting is interesting if it has many colored "regions" that can be distinguished from each-other.  Two characters belong to the same region if they are directly adjacent (east, west, north, or south), and if they are indistinguishable in color.  For example, the painting</p>

<pre>RRRBB
GGBBB
BBBRR
BBRRR
RRRRR</pre>

<p>has 4 regions (2 red, 1 blue, and 1 green) if viewed by a human, but only 3regions (2 red-green, 1 blue) if viewed by a cow.  </p>

<p>Given a painting as input, please help compute the number of regions in the painting when viewed by a human and by a cow.</p>

### 입력 

 <p>* Line 1: The integer N.</p>

<p>* Lines 2..1+N: Each line contains a string with N characters, describing one row of a painting.</p>

### 출력 

 <p>* Line 1: Two space-separated integers, telling the number of regions in the painting when viewed by a human and by a cow.</p>

