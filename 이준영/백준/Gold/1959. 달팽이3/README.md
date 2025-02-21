# [Gold III] 달팽이3 - 1959 

[문제 링크](https://www.acmicpc.net/problem/1959) 

### 성능 요약

메모리: 108384 KB, 시간: 96 ms

### 분류

많은 조건 분기, 수학

### 제출 일자

2025년 2월 21일 20:33:07

### 문제 설명

<p>M줄 N칸으로 되어 있는 표 위에, 달팽이 모양으로 선을 그리려고 한다.</p>

<table class="table table-bordered" style="width:9%">
	<tbody>
		<tr>
			<td style="width:3%">ㅇ</td>
			<td style="width:3%"> </td>
			<td style="width:3%"> </td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
		</tr>
	</tbody>
</table>

<p>위의 그림은 M=5, N=3의 예이다. 이제 표의 왼쪽 위 칸(○)에서 시작하여, 오른쪽으로 선을 그려 나간다. 표의 바깥 또는 이미 그려진 칸에 닿아서 더 이상 이동할 수 없게 되면, 시계방향으로 선을 꺾어서 그려나간다.</p>

<table class="table table-bordered" style="width:9%">
	<tbody>
		<tr>
			<td style="width:3%">ㅇ</td>
			<td style="width:3%">→</td>
			<td style="width:3%">↘</td>
		</tr>
		<tr>
			<td>↗</td>
			<td>↘</td>
			<td>↓</td>
		</tr>
		<tr>
			<td>↑</td>
			<td>↓</td>
			<td>↓</td>
		</tr>
		<tr>
			<td>↑</td>
			<td>끝</td>
			<td>↓</td>
		</tr>
		<tr>
			<td>↖</td>
			<td>←</td>
			<td>↙</td>
		</tr>
	</tbody>
</table>

<p>위의 표는 선을 그려 나간 모양을 나타낸 것이다. 선이 꺾어진 부분은 대각선으로 나타내었다.  표의 모든 칸이 채워질 때까지 선을 몇 번 꺾게 될까? 또, 어디에서 끝나게 될까?</p>

### 입력 

 <p>첫째 줄에 M과 N이 빈 칸을 사이에 두고 주어진다. (2 ≤ M, N ≤ 2,100,000,000)</p>

### 출력 

 <p>첫째 줄에 표의 모든 칸이 채워질 때까지 선이 꺾어지는 횟수를 출력한다. 둘째 줄에 끝나는 점의 좌표를 출력한다. 왼쪽 위 칸의 좌표를 (1, 1), 오른쪽 아래 칸의 좌표를 (M, N)이라고 하자.</p>

