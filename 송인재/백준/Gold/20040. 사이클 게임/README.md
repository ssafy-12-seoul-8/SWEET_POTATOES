# [Gold IV] 사이클 게임 - 20040 

[문제 링크](https://www.acmicpc.net/problem/20040) 

### 성능 요약

메모리: 126776 KB, 시간: 604 ms

### 분류

자료 구조, 분리 집합

### 제출 일자

2025년 11월 17일 17:59:34

### 문제 설명

<p>Cycle game is a game in which two players take turns drawing a line segment for given points. The first player gets to draw a line segment in the odd-numbered turns, while the other player takes even-numbered turns. At the start of the game, <em>n</em> points are given in the plane, and each of the points has a unique number from 0 to <em>n</em> − 1. Note that no three points lie on a same line. In each turn, a player draws a line segment connecting two given points. Players cannot redraw a line segment which has already been drawn, but it is allowed to draw a line segment across existing line segments. Players take turns until there is the loser who completes a cycle first. A cycle <em>C</em> is a subset of the line segments drawn by the players which satisfies the following condition.</p>

<blockquote>
<p>From any endpoint of a line segment in <em>C</em>, one can travel down and return to the end point while visiting every line segment in <em>C</em> exactly once.</p>
</blockquote>

<p>A problem is that as players draw many segments, it is difficult to check whether a cycle is created. Therefore, sometimes players continue to play the game even though a cycle has been made and the game is actually over. To prevent this situation, we need to write a program which examines whether the game has been over.</p>

<p>Write a program to decide whether the game has been over and output in which turn the first cycle has been made.</p>

### 입력 

 <p>Your program is to read from standard input. The input starts with a line containing two integers 3 ≤ <em>n</em> ≤ 500,000 and 3 ≤ <em>m</em> ≤ 1,000,000, where <em>n</em> represents the number of points and <em>m</em> represents the number of turns in which line segments have been drawn. Every point has a unique number from 0 to <em>n</em> − 1, and no three points lie on a same line. Each of the following <em>m</em> lines contains two numbers of points which are the end points of the line segments each player drew in the <em>i</em>-th turn (1 ≤ <em>i</em> ≤ <em>m</em>).<span style="display: none;"> </span></p>

### 출력 

 <p>Your program is to write to standard output. Print exactly one line. The line should contain the number of the turn in which the cycle has been first created, i.e., the game has been over, and 0 if the game was not over for <em>m</em> turns.</p>

