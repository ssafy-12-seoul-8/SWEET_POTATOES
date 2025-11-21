# [Gold III] 텀 프로젝트 - 9466 

[문제 링크](https://www.acmicpc.net/problem/9466) 

### 성능 요약

메모리: 336208 KB, 시간: 1604 ms

### 분류

그래프 이론, 그래프 탐색, 깊이 우선 탐색

### 제출 일자

2025년 11월 21일 10:28:51

### 문제 설명

<p>Students who enrolled in the ‘Problem Solving’ course in this fall semester have to carry out a term project. There is no limit to the number of project team members. Even one team is allowed such that all students are members of the same team. In order to form project teams, every student should select a friend with whom he or she wants to work. A student who wants to work alone can select himself or herself. A student list (s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>r</sub>) can be a team if either r=1 and s<sub>1</sub> selects s<sub>1</sub> or s<sub>1</sub> selects s<sub>2</sub>, s<sub>2</sub> selects s<sub>3</sub>, … , s<sub>r-1</sub> selects s<sub>r</sub>, and s<sub>r</sub> selects s<sub>1</sub>.</p>

<p>For example, let’s assume that there are 7 students in the class. The students are numbered from 1 to 7. The following is the result of the selection.</p>

<table class="table table-bordered" style="width:30%">
	<thead>
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<th>7</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>3</td>
			<td>1</td>
			<td>3</td>
			<td>7</td>
			<td>3</td>
			<td>4</td>
			<td>6</td>
		</tr>
	</tbody>
</table>

<p>From the above result, we can see that two teams (3) and (4, 7, 6) are formed. Students 1, 2, and 5 don’t belong to any team.</p>

<p>Given the result of the selection, write a program to compute the number of students who don’t belong to a project team. </p>

### 입력 

 <p>Your program is to read from standard input. The input consists of T test cases. The number of test cases T is given in the first line of the input. Each test case starts with a line containing an integer n (2 ≤ n ≤ 100 000), where n is the number of students in the class. All students are numbered from 1 to n. The next line of each test case contains n integers s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>n</sub>, where s<sub>i</sub> is the student who was a student ݅ selected by. </p>

### 출력 

 <p>Your program is to write to standard output. Print exactly one line for each test case. The line should contain the number of students who don’t belong to a project team. </p>

