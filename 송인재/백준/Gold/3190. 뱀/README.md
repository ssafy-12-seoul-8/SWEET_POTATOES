# [Gold IV] 뱀 - 3190 

[문제 링크](https://www.acmicpc.net/problem/3190) 

### 성능 요약

메모리: 14440 KB, 시간: 104 ms

### 분류

자료 구조, 덱, 구현, 큐, 시뮬레이션

### 제출 일자

2024년 8월 26일 02:11:32

### 문제 설명

<p>One of the most popular DOS games is 'Dummy'. The snake is crawling through the board and eating apples that increase its length. The game ends when the snake bumps into itself or into the wall. </p>

<p>Game board consists of NxN squares arranged in N rows and N columns, and some squares contain apples. Around the board there is a wall. At the beginning of the game, the snake is located in the top-left corner, its length is equal to 1 and its head is directed towards right. </p>

<p>Snake is crawling by changing its position during each second according to the following rules: </p>

<ul>
	<li>first, snake extends its length by spreading to the next square in front of the head (i.e. in the direction of the head),</li>
	<li>if there is an apple on that square, tail of the snake does not move (hence, its length is increased by 1 in this step),</li>
	<li>if there is no apple, last square of the tail is erased (hence, its length stays unchanged) </li>
</ul>

<p>Positions of the apples and movements of the snake are given. Write a program that will calculate the number of seconds until the game ends. </p>

### 입력 

 <p>First line of input contains an integer N, 2 ≤ N ≤ 100. </p>

<p>Following line contains an integer K, 0 ≤ K ≤ 100, the number of apples on the board. </p>

<p>Following K lines contain coordinates of apples on the board. First number denotes the row and second number denotes the column of the board where the apple is situated. There will be no apple at the top-left corner of the board. </p>

<p>Following line contains an integer number L, 1 ≤ L ≤ 100, the number of times the snake makes a turn. </p>

<p>Each of the following L lines contains the description of one turn. A single turn is described by a number X (positive integer less than or equal to 10,000) and a character C. This means that the snake rotates its head 90 degrees left (if C is 'L') or right (if C is 'D') at the end of the Xth second </p>

### 출력 

 <p>First and only line of output should contain number of seconds from the problem statement. </p>

