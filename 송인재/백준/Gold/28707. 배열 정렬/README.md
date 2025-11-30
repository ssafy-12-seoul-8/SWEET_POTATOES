# [Gold I] 배열 정렬 - 28707 

[문제 링크](https://www.acmicpc.net/problem/28707) 

### 성능 요약

메모리: 99912 KB, 시간: 736 ms

### 분류

자료 구조, 그래프 이론, 집합과 맵, 최단 경로, 해시를 사용한 집합과 맵, 데이크스트라

### 제출 일자

2025년 11월 30일 11:07:32

### 문제 설명

<p>You are given an array $A = [A_1, A_2, \cdots, A_N]$ of $N$ positive integers. You want to sort this array in non-descending order, i.e., $A_1 \le A_2 \le \cdots \le A_N$. To achieve this, you can perform any of the following $M$ operations in any order and as many times as you want:</p>

<ul>
	<li>Swap the $l_i$'th and $r_i$'th numbers of $A$. The cost is $c_i$. $(1 \le i \le M)$</li>
</ul>

<p>Print the minimum total cost required to sort $A$ in non-descending order.</p>

### 입력 

 <p>The first line contains the length $N$ of the array $A$. $(2 \le N \le 8)$</p>

<p>The second line contains the elements $A_1, \cdots, A_N$ of $A$, separated by a space. $(1 \le A_i \le 10)$</p>

<p>The third line contains the number of operations $M$. $(1 \le M \le 10)$</p>

<p>The next $M$ lines contain three integers $l_i, r_i, c_i$ which represent an operation, separated by a space. $(1 \le l_i < r_i \le N;$ $1 \le c_i \le 10)$</p>

### 출력 

 <p>Print the minimum total cost required to sort $A$ in non-descending order in the first line. If it is impossible to make the array non-descending, print $-1$ instead.</p>

