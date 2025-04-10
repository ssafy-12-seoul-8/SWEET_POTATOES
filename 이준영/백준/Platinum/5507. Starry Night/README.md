# [Platinum IV] Starry Night - 5507 

[문제 링크](https://www.acmicpc.net/problem/5507) 

### 성능 요약

메모리: 111696 KB, 시간: 144 ms

### 분류

그래프 이론, 그래프 탐색, 구현

### 제출 일자

2025년 4월 10일 11:45:01

### 문제 설명

<p>High up in the night sky, the shining stars appear in clusters of various shapes. A cluster is a non-empty group of neighbouring stars, adjacent in horizontal, vertical or diagonal direction. A cluster cannot be a part of a larger cluster.</p>

<p>Clusters may be similar. Two clusters are similar if they have the same shape and number of stars, irrespective of their orientation. In general, the number of possible orientations for a cluster is eight, as Figure 1 exemplifies.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/5507/1.gif" style="height:166px; width:295px"></p>

<p style="text-align:center">Figure 1. Eight similar clusters</p>

<p>The night sky is represented by a sky map, which is a two-dimensional matrix of 0's and 1's. A cell contains the digit 1 if it has a star, and the digit 0 otherwise.</p>

<p>Given a sky map, mark all the clusters with lower case letters. Similar clusters must be marked with the same letter; non-similar clusters must be marked with different letters.</p>

<p>You mark a cluster with a lower case letter by replacing every 1 in the cluster by that lower case letter.</p>

### 입력 

 <p>In standard input the first two lines contain, respectively, the width W and the height H of a sky map. The sky map is given in the following H lines, of W characters each.</p>

<ul>
	<li>0 <= W (width of the sky map) <= 100</li>
	<li>0 <= H (height of the sky map) <= 100</li>
	<li>0 <= Number of clusters <= 500</li>
	<li>0 <= Number of non-similar clusters <= 26 (a..z)</li>
	<li>1 <= Number of stars per cluster <= 160</li>
</ul>

<p> </p>

### 출력 

 <p>The standard output contains the same map as standard input, except that the clusters are marked as described in Task.</p>

