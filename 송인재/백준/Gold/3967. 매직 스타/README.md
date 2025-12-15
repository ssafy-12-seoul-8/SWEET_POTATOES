# [Gold V] 매직 스타 - 3967 

[문제 링크](https://www.acmicpc.net/problem/3967) 

### 성능 요약

메모리: 16824 KB, 시간: 560 ms

### 분류

구현, 브루트포스 알고리즘, 백트래킹

### 제출 일자

2025년 12월 15일 13:49:35

### 문제 설명

<p>A magic star consists of all the numbers from 1 to 12 arranged in the shape of a hexagram:</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/magicstar.png" style="height:239px; width:230px"></p>

<p>The magic comes from the fact that in each line of 4 numbers, the sum of the numbers is 26. In the example given above, the six lines consist of the following numbers:</p>

<ul>
	<li>1 + 4 + 10 + 11</li>
	<li>11 + 5 + 3 + 7</li>
	<li>7 + 6 + 12 + 1</li>
	<li>2 + 10 + 5 + 9</li>
	<li>9 + 3 + 6 + 8</li>
	<li>8 + 12 + 4 + 2</li>
</ul>

<p>There are several possible ways to arrange the numbers to get a magic star. Given a partially labelled star, your task is to extend the solution such that a magic star is formed.</p>

### 입력 

 <p>The input consists of a visualization of the star; the unlabelled fields of the star will be represented by an 'x' character, and labelled fields will contain a letter between 'A' and 'L', where the i-th letter in the alphabet represents number i. The character '.' is used to align the elds of the star in the shape of a hexagram. You may assume that each input will use the same alignment of the fields as the one in the sample input.</p>

### 출력 

 <p>Print the lexicographically smallest extension of the given partial solution which is a magic star (lexicographically smallest means that the concatenation of the rows should result in a string which is lexicographically smaller than other potential solutions). You may assume that there is always a solution for the given input.</p>

