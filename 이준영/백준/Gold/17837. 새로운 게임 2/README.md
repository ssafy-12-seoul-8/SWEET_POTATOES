# [Gold II] 새로운 게임 2 - 17837 

[문제 링크](https://www.acmicpc.net/problem/17837) 

### 성능 요약

메모리: 112436 KB, 시간: 144 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2025년 4월 1일 21:02:30

### 문제 설명

<p>재현이는 주변을 살펴보던 중 체스판과 말을 이용해서 새로운 게임을 만들기로 했다. 새로운 게임은 크기가 N×N인 체스판에서 진행되고, 사용하는 말의 개수는 K개이다. 말은 원판모양이고, 하나의 말 위에 다른 말을 올릴 수 있다. 체스판의 각 칸은 흰색, 빨간색, 파란색 중 하나로 색칠되어있다.</p>

<p>게임은 체스판 위에 말 K개를 놓고 시작한다. 말은 1번부터 K번까지 번호가 매겨져 있고, 이동 방향도 미리 정해져 있다. 이동 방향은 위, 아래, 왼쪽, 오른쪽 4가지 중 하나이다.</p>

<p>턴 한 번은 1번 말부터 K번 말까지 순서대로 이동시키는 것이다. 한 말이 이동할 때 위에 올려져 있는 말도 함께 이동한다. 말의 이동 방향에 있는 칸에 따라서 말의 이동이 다르며 아래와 같다. 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료된다.</p>

<ul>
	<li>A번 말이 이동하려는 칸이
	<ul>
		<li>흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
		<ul>
			<li>A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.</li>
			<li>예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.</li>
		</ul>
		</li>
		<li>빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
		<ul>
			<li>A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.</li>
			<li>A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.</li>
		</ul>
		</li>
		<li>파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.</li>
		<li>체스판을 벗어나는 경우에는 파란색과 같은 경우이다.</li>
	</ul>
	</li>
</ul>

<p>다음은 크기가 4×4인 체스판 위에 말이 4개 있는 경우이다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/0aec7e3d-e8f5-428a-bebc-6a0fd514b387/-/preview/" style="width: 250px; height: 251px;"></p>

<p>첫 번째 턴은 다음과 같이 진행된다.</p>

<div class="table-responsive">
<table class="table table-bordered" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/46796304-b486-4420-9d2c-ea49e2d5665b/-/preview/" style="width: 250px; height: 251px;"></td>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/04643ced-fdfd-46f5-a07e-374704dbb1c5/-/preview/" style="width: 250px; height: 252px;"></td>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/46f4bfab-841b-41c8-842e-56027816f846/-/preview/" style="width: 250px; height: 251px;"></td>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/fcccf76c-9431-4ff5-8a05-7dbd2feff142/-/preview/" style="width: 250px; height: 251px;"></td>
		</tr>
	</tbody>
</table>
</div>

<p>두 번째 턴은 다음과 같이 진행된다.</p>

<div class="table-responsive">
<table class="table table-bordered" style="width: 100%;">
	<tbody>
		<tr>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/36568153-8c2a-4fe9-b45f-72036c97f5aa/-/preview/" style="width: 250px; height: 252px;"></td>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/babead43-4acc-425d-917a-54dcc6f45414/-/preview/" style="width: 250px; height: 251px;"></td>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/1edd5ed8-0f4c-4c6d-b304-3b7642f42c6f/-/preview/" style="width: 250px; height: 251px;"></td>
			<td style="width: 25%; text-align: center;"><img alt="" src="https://upload.acmicpc.net/028a5dd2-5524-4475-8439-9e7794e28ee4/-/preview/" style="width: 250px; height: 252px;"></td>
		</tr>
	</tbody>
</table>
</div>

<p>체스판의 크기와 말의 위치, 이동 방향이 모두 주어졌을 때, 게임이 종료되는 턴의 번호를 구해보자.</p>

### 입력 

 <p>첫째 줄에 체스판의 크기 N, 말의 개수 K가 주어진다. 둘째 줄부터 N개의 줄에 체스판의 정보가 주어진다. 체스판의 정보는 정수로 이루어져 있고, 각 정수는 칸의 색을 의미한다. 0은 흰색, 1은 빨간색, 2는 파란색이다.</p>

<p>다음 K개의 줄에 말의 정보가 1번 말부터 순서대로 주어진다. 말의 정보는 세 개의 정수로 이루어져 있고, 순서대로 행, 열의 번호, 이동 방향이다. 행과 열의 번호는 1부터 시작하고, 이동 방향은 4보다 작거나 같은 자연수이고 1부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.</p>

<p>같은 칸에 말이 두 개 이상 있는 경우는 입력으로 주어지지 않는다.</p>

### 출력 

 <p>게임이 종료되는 턴의 번호를 출력한다. 그 값이 1,000보다 크거나 절대로 게임이 종료되지 않는 경우에는 -1을 출력한다.</p>

