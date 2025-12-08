# [Platinum V] 행성 터널 - 2887 

[문제 링크](https://www.acmicpc.net/problem/2887) 

### 성능 요약

메모리: 72156 KB, 시간: 1680 ms

### 분류

그래프 이론, 정렬, 최소 스패닝 트리

### 제출 일자

2025년 12월 2일 19:05:20

### 문제 설명

<p>Fourth Great and Bountiful Human Empire is developing a transconduit tunnel network connecting all it's planets. The Empire consists of N planets, represented as points in the 3D space. The cost of forming a transconduit tunnel between planets A and B is:</p>

<p>TunnelCost[A,B] = min{ |xA-xB|, |yA-yB|, |zA-zB| }</p>

<p>where (xA, yA, zA) are 3D coordinates of planet A, and (xB, yB, zB) are coordinates of planet B. The Empire needs to build exactly N - 1 tunnels in order to fully connect all planets, either by direct links or by chain of links. You need to come up with the lowest possible cost of successfully completing this project.</p>

### 입력 

 <p>The first line of input contains one integer N (1 ≤ N ≤ 100 000), number of planets.</p>

<p>Next N lines contain exactly 3 integers each. All integers are between -10<sup>9</sup> and 10<sup>9</sup> inclusive. Each line contains the x, y, and z coordinate of one planet (in order).</p>

<p>No two planets will occupy the exact same point in space.</p>

### 출력 

 <p>The first and only line of output should contain the minimal cost of forming the network of tunnels.</p>

