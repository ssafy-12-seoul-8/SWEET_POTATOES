# [Gold III] 코딩은 예쁘게 - 2879 

[문제 링크](https://www.acmicpc.net/problem/2879) 

### 성능 요약

메모리: 14376 KB, 시간: 112 ms

### 분류

그리디 알고리즘

### 제출 일자

2024년 11월 7일 11:24:56

### 문제 설명

<p>Zvonkec is yet another programmer employed in a small company. Every day he has to refactor one file of source code. Much to his dismay, the source is usually far from being clear and tidy. He is especially bothered by uneven indentation, i.e. the number of tabulators (tabs) indenting each line. Fortunately, his editor has a command to select a group of consecutive lines and add or delete a character from the start of each one. Help Zvonkec tidy up the code as quickly as possible. </p>

<p>You are given the number of lines N, a sequence specifying the current number of tabs at the start of each line, and a sequence specifying the required number of tabs at the start of each line. </p>

<p>Zvonkec can execute any number of commands consisting of: </p>

<ul>
	<li>selecting any number of consecutive lines </li>
	<li>adding or deleting a single tab to/from the front of each of the selected lines </li>
</ul>

<p>The two actions above comprise a single command, regardless of the number of selected lines. </p>

<p>It should be noted that it is forbidden to delete more tabs from a line than are actually present at the start of a line, as the editor would start deleting characters other than tabs. </p>

<p>You are asked to calculate the minimum number of commands required to tidy up the code. </p>

### 입력 

 <p>The first line of input contains a positive integer N (N ≤ 1000). </p>

<p>The second line contains a sequence of N integers P<sub>i</sub> (0 ≤ P<sub>i</sub> ≤ 80), specifying the number of tabs at the start of i-th line before any editing. </p>

<p>The third line contains a sequence of N integers K<sub>i</sub> (0 ≤ K<sub>i</sub> ≤ 80), specifying the number of tabs that Zvonkec would like at the start of i-th line. </p>

### 출력 

 <p>The first and only line of output must contain the required number, as specified in the problem statement. </p>

