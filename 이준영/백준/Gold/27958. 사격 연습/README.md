# [Gold IV] 사격 연습 - 27958 

[문제 링크](https://www.acmicpc.net/problem/27958) 

### 성능 요약

메모리: 114768 KB, 시간: 236 ms

### 분류

백트래킹, 브루트포스 알고리즘, 구현, 시뮬레이션

### 제출 일자

2025년 3월 22일 12:45:34

### 문제 설명

<p><em>N</em>×<em>N</em> 크기의 보드 판이 존재하며, 1개 이상의 표적이 존재한다. 한 학생은 사격을 연습하고 있으며, 1번부터 <em>K</em>번까지 <em>K</em>개의 총알을 가지고 있다. 학생은 총 <em>K</em>번의 사격을 진행하며, 1번부터 <em>K</em>번까지의 총알을 차례대로 발사해야 한다.</p>

<p>한 번의 사격을 할 때는 1행부터 <em>N</em>행까지 중에서 하나의 행을 선택하여 사격을 진행한다. 총알은 가장 왼쪽 열(1열)의 한 위치에서 시작해 왼쪽에서 오른쪽으로 수평으로 한 칸씩 이동하며 날아가고, 각 총알은 공격력 정보를 가지고 있다.</p>

<p>초기 입력에서 보드 판에서 표적이 있는 위치는 1 이상의 자연수로 표시되고, 표적이 없는 곳은 정수 0으로 표시된다. 표적이 있는 위치의 값은 <strong>초기 체력(시작 시점의 현재 체력)</strong>을 의미한다. 이후에 총알이 표적에 닿으면 <strong>현재 체력</strong>이 총알의 공격력만큼 감소한다. 총알은 표적을 관통하지 못 하고, 표적에 닿은 총알은 즉시 사라진다.</p>

<p>총알에 닿아 현재 체력이 0 이하가 되면 표적은 사라진다. 이때, 해당 표적의 초기 체력만큼 점수를 얻는다. 이후에 사라진 표적 위치의 상, 하, 좌, 우 위치 중에서 빈 칸(표적이 없는 곳)인 모든 위치에 대하여, 사라진 표적의 초기 체력의 1/4의 값을 초기 체력으로 가지는 새로운 표적이 생성된다. 이때, 새로운 표적의 초기 체력에 대해서 소수점 아래는 버리며, 만약 그 값이 0인 경우에는 새로운 표적은 생성되지 않는다.</p>

<p>초기 상태에서는 모든 표적들에 대해 초기 체력과 현재 체력은 동일하다. 또한 값이 10 이상인 표적은 보너스 표적이다. 보너스 표적은 별도의 초기 체력이 없다. 보너스 표적을 맞히는 순간 총알의 공격력과 상관없이 총알과 보너스 표적이 함께 사라지며, 그 즉시 보너스 표적에 적힌 점수만큼 점수를 더한다. 보너스 체력은 사라진 뒤에 새로운 표적을 생성하지 않는다. 보너스 표적이 아닌 일반 표적의 초기 체력은 1 이상 9 이하의 자연수다.</p>

<p><em>N</em>×<em>N</em> 크기의 초기 보드 판 정보가 주어졌을 때, <em>K</em>번의 사격으로 얻을 수 있는 점수의 최댓값을 구하는 프로그램을 작성하시오. <em>K</em>번의 사격 모두 동일한 위치(동일한 행)에서 수행할 수 있다. 또한 각 총알의 공격력은 1 이상 100 이하의 자연수다.</p>

<p>예를 들어 <em>N</em>=5, <em>K</em>=3일 때를 생각해 보자. 하나의 예시를 테이블로 표현하면 다음과 같다. 각 총알의 공격력은 차례대로 1, 5, 1이라고 가정한다. 이때, 사격을 진행할 수 있는 위치는 총 5개가 된다. 초기 점수는 0점부터 시작한다.</p>

<table class="table table-bordered table-center-50 td-center">
	<tbody>
		<tr>
			<td><strong>위치 1</strong></td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 2</strong></td>
			<td>10</td>
			<td>0</td>
			<td>4</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 3</strong></td>
			<td>0</td>
			<td>0</td>
			<td>7</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 4</strong></td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 5</strong></td>
			<td>0</td>
			<td>0</td>
			<td>2</td>
			<td>0</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<ol>
	<li>가장 먼저, 첫 번째 총알의 공격력은 1이다. <strong>위치 2</strong>에서 사격을 진행하면 보너스 표적을 맞히고, 점수가 10점이 된다.</li>
</ol>

<table class="table table-bordered table-center-50 td-center">
	<tbody>
		<tr>
			<td><strong>위치 1</strong></td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 2</strong></td>
			<td>0</td>
			<td>0</td>
			<td>4</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 3</strong></td>
			<td>0</td>
			<td>0</td>
			<td>7</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 4</strong></td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 5</strong></td>
			<td>0</td>
			<td>0</td>
			<td>2</td>
			<td>0</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<ol start="2">
	<li>이후에 두 번째 총알의 공격력은 5이다. <strong>위치 2</strong>에서 사격을 진행하면 일반 표적을 맞히고, 점수가 14점이 된다.</li>
</ol>

<table class="table table-bordered table-center-50 td-center">
	<tbody>
		<tr>
			<td><strong>위치 1</strong></td>
			<td>0</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 2</strong></td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 3</strong></td>
			<td>0</td>
			<td>0</td>
			<td>7</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 4</strong></td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 5</strong></td>
			<td>0</td>
			<td>0</td>
			<td>2</td>
			<td>0</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<ol start="3">
	<li>이후에 세 번째 총알의 공격력은 1이다. <strong>위치 1</strong>에서 사격을 진행하면 일반 표적을 맞히고, 점수가 15점이 된다.</li>
</ol>

<table class="table table-bordered table-center-50 td-center">
	<tbody>
		<tr>
			<td><strong>위치 1</strong></td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 2</strong></td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 3</strong></td>
			<td>0</td>
			<td>0</td>
			<td>7</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 4</strong></td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
			<td>0</td>
		</tr>
		<tr>
			<td><strong>위치 5</strong></td>
			<td>0</td>
			<td>0</td>
			<td>2</td>
			<td>0</td>
			<td>0</td>
		</tr>
	</tbody>
</table>

<p>현재 예시에서는 위와 같이 사격을 진행했을 때 점수가 15점이 되며, 이 경우가 최댓값이다.</p>

### 입력 

 <p>첫째 줄에 보드 판의 크기 <em>N</em>이 자연수로 주어진다. <em>N</em>은 2 이상 8 이하의 자연수다. 둘째 줄에 사격 횟수 <em>K</em>가 자연수로 주어진다. <em>K</em>는 1 이상 5 이하의 자연수다. 셋째 줄부터 <em>N</em>+2번째 줄까지 <em>N</em>×<em>N</em> 크기의 보드의 정보가 주어진다. 각 위치에 대한 값은 공백을 기준으로 구분되며, 0 이상 30 이하의 정수다. <em>N</em>+3번째 줄에 1번부터 K번까지의 각 총알의 공격력 값이 공백을 기준으로 구분되어 차례대로 주어지며, 각 공격력 값은 1 이상 100 이하의 자연수다.</p>

### 출력 

 <p><em>K</em>번의 사격이 가능할 때, 얻을 수 있는 최대 점수를 첫째 줄에 자연수로 출력한다.</p>

