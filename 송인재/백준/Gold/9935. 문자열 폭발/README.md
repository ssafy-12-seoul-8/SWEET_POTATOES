# [Gold IV] 문자열 폭발 - 9935 

[문제 링크](https://www.acmicpc.net/problem/9935) 

### 성능 요약

메모리: 67412 KB, 시간: 388 ms

### 분류

자료 구조, 스택, 문자열

### 제출 일자

2024년 8월 30일 10:12:38

### 문제 설명

<p>Mirko likes to play with strings of characters, but this time he has taken it too far – he put an “explosion” in the string! An explosion is a series of characters which, if found in the vicinity of fire, explodes and starts a chain reaction. </p>

<p>Mirko, being as negligent as he usually is, forgot that his string contained an explosion and placed it near a candlelight. Thus the chain reaction began. </p>

<p>The chain reaction takes place in the following way: </p>

<ul>
	<li>if a string contains explosions, they all explode and a new string is formed by concatenating the pieces without the exploding parts </li>
	<li>this concatenation could possibly create new explosions </li>
	<li>the chain reaction repeats while there are explosions in the string </li>
</ul>

<p>Now Mirko wants to know whether anything will be left after this series of chain reactions. If nothing remains, output “FRULA” (without quotes). If, by any chance, something is left, output the final string remaining after all the reactions. </p>

<p>Please note: The explosion will not contain two equal characters. </p>

### 입력 

 <p>The first line of input contains Mirko's string, (1 ≤ |Mirko's string| ≤ 1 000 000). </p>

<p>The second line of input contains the explosion string, (1 ≤ |explosion| ≤ 36). </p>

<p>Both Mirko's string and the explosion string consist of uppercase and lowercase letters of the English alphabet and digits 0, 1, … 9. </p>

### 출력 

 <p>The first and only line of output must contain the final string remaining after all the reactions as stated in the task. </p>

