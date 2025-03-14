# [Gold II] 상어 중학교 - 21609 

[문제 링크](https://www.acmicpc.net/problem/21609) 

### 성능 요약

메모리: 112008 KB, 시간: 168 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션

### 제출 일자

2025년 3월 14일 16:34:10

### 문제 설명

<p>상어 중학교의 코딩 동아리에서 게임을 만들었다. 이 게임은 크기가 N×N인 격자에서 진행되고, 초기에 격자의 모든 칸에는 블록이 하나씩 들어있고, 블록은 검은색 블록, 무지개 블록, 일반 블록이 있다. 일반 블록은 M가지 색상이 있고, 색은 M이하의 자연수로 표현한다. 검은색 블록은 -1, 무지개 블록은 0으로 표현한다. (i, j)는 격자의 i번 행, j번 열을 의미하고, |r<sub>1</sub> - r<sub>2</sub>| + |c<sub>1</sub> - c<sub>2</sub>| = 1을 만족하는 두 칸 (r<sub>1</sub>, c<sub>1</sub>)과 (r<sub>2</sub>, c<sub>2</sub>)를 인접한 칸이라고 한다.</p>

<p>블록 그룹은 연결된 블록의 집합이다. 그룹에는 일반 블록이 적어도 하나 있어야 하며, 일반 블록의 색은 모두 같아야 한다. 검은색 블록은 포함되면 안 되고, 무지개 블록은 얼마나 들어있든 상관없다. 그룹에 속한 블록의 개수는 2보다 크거나 같아야 하며, 임의의 한 블록에서 그룹에 속한 인접한 칸으로 이동해서 그룹에 속한 다른 모든 칸으로 이동할 수 있어야 한다. 블록 그룹의 기준 블록은 무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록, 그러한 블록이 여러개면 열의 번호가 가장 작은 블록이다.</p>

<p>오늘은 이 게임에 오토 플레이 기능을 만드려고 한다. 오토 플레이는 다음과 같은 과정이 블록 그룹이 존재하는 동안 계속해서 반복되어야 한다.</p>

<ol>
	<li>크기가 가장 큰 블록 그룹을 찾는다. 그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹, 그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 그 것도 여러개이면 열이 가장 큰 것을 찾는다.</li>
	<li>1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B<sup>2</sup>점을 획득한다.</li>
	<li>격자에 중력이 작용한다.</li>
	<li>격자가 90도 반시계 방향으로 회전한다.</li>
	<li>다시 격자에 중력이 작용한다.</li>
</ol>

<p>격자에 중력이 작용하면 검은색 블록을 제외한 모든 블록이 행의 번호가 큰 칸으로 이동한다. 이동은 다른 블록이나 격자의 경계를 만나기 전까지 계속 된다.</p>

<p>다음은 N = 5, M = 3인 경우의 예시이다.</p>

<table class="table table-bordered table-center-30 table-21609">
	<tbody>
		<tr>
			<td>2</td>
			<td>2</td>
			<td>-1</td>
			<td>3</td>
			<td>1</td>
		</tr>
		<tr>
			<td>3</td>
			<td>3</td>
			<td>2</td>
			<td>0</td>
			<td>-1</td>
		</tr>
		<tr>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>1</td>
			<td>2</td>
		</tr>
		<tr>
			<td>-1</td>
			<td>3</td>
			<td>1</td>
			<td>3</td>
			<td>2</td>
		</tr>
		<tr>
			<td>0</td>
			<td>3</td>
			<td>2</td>
			<td>2</td>
			<td>1</td>
		</tr>
	</tbody>
</table>

<p>여기서 찾을 수 있는 크기가 가장 큰 블록 그룹을 다음과 같이 빨간색으로 표시했다.</p>

<table class="table table-bordered table-center-30 table-21609">
	<tbody>
		<tr>
			<td>2</td>
			<td>2</td>
			<td>-1</td>
			<td>3</td>
			<td>1</td>
		</tr>
		<tr>
			<td class="bg-red">3</td>
			<td class="bg-red">3</td>
			<td>2</td>
			<td>0</td>
			<td>-1</td>
		</tr>
		<tr>
			<td class="bg-red">0</td>
			<td class="bg-red">0</td>
			<td class="bg-red">0</td>
			<td>1</td>
			<td>2</td>
		</tr>
		<tr>
			<td>-1</td>
			<td class="bg-red">3</td>
			<td>1</td>
			<td>3</td>
			<td>2</td>
		</tr>
		<tr>
			<td class="bg-red">0</td>
			<td class="bg-red">3</td>
			<td>2</td>
			<td>2</td>
			<td>1</td>
		</tr>
	</tbody>
</table>

<p>블록 그룹이 제거되면 다음과 같이 변하고, 점수 8<sup>2</sup>점을 획득한다.</p>

<table class="table table-bordered table-center-30 table-21609">
	<tbody>
		<tr>
			<td>2</td>
			<td>2</td>
			<td>-1</td>
			<td>3</td>
			<td>1</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td>2</td>
			<td>0</td>
			<td>-1</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
			<td>1</td>
			<td>2</td>
		</tr>
		<tr>
			<td>-1</td>
			<td> </td>
			<td>1</td>
			<td>3</td>
			<td>2</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td>2</td>
			<td>2</td>
			<td>1</td>
		</tr>
	</tbody>
</table>

<p>중력이 작용하면 다음과 같이 변한다.</p>

<table class="table table-bordered table-center-30 table-21609">
	<tbody>
		<tr>
			<td> </td>
			<td> </td>
			<td>-1</td>
			<td>3</td>
			<td>1</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
			<td>0</td>
			<td>-1</td>
		</tr>
		<tr>
			<td>2</td>
			<td> </td>
			<td>2</td>
			<td>1</td>
			<td>2</td>
		</tr>
		<tr>
			<td>-1</td>
			<td> </td>
			<td>1</td>
			<td>3</td>
			<td>2</td>
		</tr>
		<tr>
			<td> </td>
			<td>2</td>
			<td>2</td>
			<td>2</td>
			<td>1</td>
		</tr>
	</tbody>
</table>

<p>90도 반시계방향으로 회전한 결과는 다음과 같다.</p>

<table class="table table-bordered table-center-30 table-21609">
	<tbody>
		<tr>
			<td>1</td>
			<td>-1</td>
			<td>2</td>
			<td>2</td>
			<td>1</td>
		</tr>
		<tr>
			<td>3</td>
			<td>0</td>
			<td>1</td>
			<td>3</td>
			<td>2</td>
		</tr>
		<tr>
			<td>-1</td>
			<td> </td>
			<td>2</td>
			<td>1</td>
			<td>2</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td> </td>
			<td> </td>
			<td>2</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td>2</td>
			<td>-1</td>
			<td> </td>
		</tr>
	</tbody>
</table>

<p>다시 여기서 중력이 작용하면 다음과 같이 변한다.</p>

<table class="table table-bordered table-center-30 table-21609">
	<tbody>
		<tr>
			<td>1</td>
			<td>-1</td>
			<td> </td>
			<td> </td>
			<td> </td>
		</tr>
		<tr>
			<td>3</td>
			<td> </td>
			<td>2</td>
			<td>2</td>
			<td>1</td>
		</tr>
		<tr>
			<td>-1</td>
			<td> </td>
			<td>1</td>
			<td>3</td>
			<td>2</td>
		</tr>
		<tr>
			<td> </td>
			<td> </td>
			<td>2</td>
			<td>1</td>
			<td>2</td>
		</tr>
		<tr>
			<td> </td>
			<td>0</td>
			<td>2</td>
			<td>-1</td>
			<td>2</td>
		</tr>
	</tbody>
</table>

<p>오토 플레이가 모두 끝났을 때 획득한 점수의 합을 구해보자.</p>

### 입력 

 <p>첫째 줄에 격자 한 변의 크기 N, 색상의 개수 M이 주어진다.</p>

<p>둘째 줄부터 N개의 줄에 격자의 칸에 들어있는 블록의 정보가 1번 행부터 N번 행까지 순서대로 주어진다. 각 행에 대한 정보는 1열부터 N열까지 순서대로 주어진다. 입력으로 주어지는 칸의 정보는 -1, 0, M이하의 자연수로만 이루어져 있다.</p>

### 출력 

 <p>첫째 줄에 획득한 점수의 합을 출력한다.</p>

