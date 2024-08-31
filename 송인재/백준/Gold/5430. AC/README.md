# [Gold V] AC - 5430 

[문제 링크](https://www.acmicpc.net/problem/5430) 

### 성능 요약

메모리: 92052 KB, 시간: 768 ms

### 분류

덱, 파싱, 구현, 문자열, 자료 구조

### 제출 일자

2024년 8월 31일 22:45:34

### 문제 설명

<p>The programming language Better And Portable Code (BAPC) is a language for working with lists of integers. The language has two built-in functions: ‘R’ (reverse) and ‘D’ (drop).</p>

<p>The function ‘R’ reverses its input list, and ’D’ drops the first element of its input and returns the rest, or gives an error in case its input is an empty list. To get more advanced behavior, functions can be composed: “AB” is the function that first applies ‘A’ to its input and then ‘B’ to the resulting list. For example, “RDD” is a function that reverses a list and then drops the first two elements.</p>

<p>Unfortunately, our BAPC interpreter has bit rotted, so we ask you to write a new one.</p>

<p>Given a BAPC program and its input, return its output or “error” in case ‘D’ is applied to an empty list. Lists are represented as the character ‘[’ followed by a comma-separated list of integers followed by the character ‘]’. Notice that the input and output lists can be quite long.</p>

### 입력 

 <p>On the first line one positive number: the number of test cases, at most 100. After that per test case:</p>

<ul>
	<li>one line with a string p (1 ≤ length(p) ≤ 100 000): a BAPC program, consisting of the</li>
	<li>characters ‘R’ and ‘D’.</li>
	<li>one line with an integer n (0 ≤ n ≤ 100 000): the number of elements in the input.</li>
	<li>one line with a list of n integers in the form [x<sub>1</sub>, ..., x<sub>n</sub>] (1 ≤ x<sub>i</sub> ≤ 100): the input list</li>
</ul>

### 출력 

 <p>Per test case:</p>

<ul>
	<li>one line with the resulting integer list or “error” in case of an error.</li>
</ul>

