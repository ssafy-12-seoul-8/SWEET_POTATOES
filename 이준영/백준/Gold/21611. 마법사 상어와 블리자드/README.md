# [Gold I] 마법사 상어와 블리자드 - 21611 

[문제 링크](https://www.acmicpc.net/problem/21611) 

### 성능 요약

메모리: 112108 KB, 시간: 144 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2025년 3월 20일 16:03:56

### 문제 설명

<p>마법사 상어는 <a href="/problem/20056">파이어볼</a>, <a href="/problem/20057">토네이도</a>, <a href="/problem/20058">파이어스톰</a>, <a href="/problem/21610">물복사버그</a>, <a href="/problem/21610">비바라기</a> 마법을 할 수 있다. 오늘 새로 배운 마법은 블리자드이고, 크기가 N×N인 격자에서 연습하려고 한다. N은 항상 홀수이고, (r, c)는 격자의 r행 c열을 의미한다. 격자의 가장 왼쪽 윗 칸은 (1, 1)이고, 가장 오른쪽 아랫 칸은 (N, N)이며 마법사 상어는 ((N+1)/2, (N+1)/2)에 있다.</p>

<p>일부 칸과 칸 사이에는 벽이 세워져 있으며, 다음은 N = 3, 5, 7인 경우의 예시이다. 실선은 벽이고, 점선은 벽이 아니다. 칸에 적혀있는 수는 칸의 번호이다.</p>

<table class="table table-bordered td-center td-middle">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/443a20c6-fbd7-4951-9b68-bf78b12b27fb/-/preview/" style="width: 204px; height: 203px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/7781df31-3999-4234-a032-32cb6fd439e9/-/preview/" style="width: 204px; height: 204px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/50b901d5-47ec-4504-bce1-122e8282284a/-/preview/" style="width: 204px; height: 204px;"></td>
		</tr>
		<tr>
			<td>N = 3</td>
			<td>N = 5</td>
			<td>N = 7</td>
		</tr>
	</tbody>
</table>

<p>가장 처음에 상어가 있는 칸을 제외한 나머지 칸에는 구슬이 하나 들어갈 수 있다. 구슬은 1번 구슬, 2번 구슬, 3번 구슬이 있다. 같은 번호를 가진 구슬이 번호가 연속하는 칸에 있으면, 그 구슬을 연속하는 구슬이라고 한다. 다음은 N = 7인 경우 예시이다. </p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/2c31bd47-ddc9-40f2-9830-05bef469fb4a/-/preview/" style="width: 300px; height: 299px;"></p>

<p>블리자드 마법을 시전하려면 방향 d<sub>i</sub>와 거리 s<sub>i</sub>를 정해야 한다. 총 4가지 방향 ↑, ↓, ←, →가 있고, 정수 1, 2, 3, 4로 나타낸다. 상어는 d<sub>i</sub> 방향으로 거리가 s<sub>i</sub> 이하인 모든 칸에 얼음 파편을 던져 그 칸에 있는 구슬을 모두 파괴한다. 구슬이 파괴되면 그 칸은 구슬이 들어있지 않은 빈 칸이 된다. 얼음 파편은 벽의 위로 떨어지기 때문에, 벽은 파괴되지 않는다.</p>

<p>다음 예시는 방향은 아래, 거리는 2인 경우이다.</p>

<table class="table table-bordered td-center td-middle">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/ca05f21a-bd15-4fbd-80a5-899712db2beb/-/preview/" style="width: 300px; height: 299px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/4768a8c6-c935-430d-9ce3-7fde346b0830/-/preview/" style="width: 300px; height: 299px;"></td>
		</tr>
		<tr>
			<td>빨간색으로 표시된 칸에 얼음 파편이 떨어진다.</td>
			<td>구슬이 파괴된 후</td>
		</tr>
	</tbody>
</table>

<p>만약 어떤 칸 A의 번호보다 번호가 하나 작은 칸이 빈 칸이면, A에 있는 구슬은 그 빈 칸으로 이동한다. 이 이동은 더 이상 구슬이 이동하지 않을 때까지 반복된다. 따라서, 구슬이 파괴된 후에는 빈 칸이 생겨 구슬이 이동하고, 구슬이 모두 이동한 결과는 다음과 같다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/28dcbbe3-7035-49ad-afed-642218adee39/-/preview/" style="width: 300px; height: 299px;"></p>

<p>이제 구슬이 폭발하는 단계이다. 폭발하는 구슬은 4개 이상 연속하는 구슬이 있을 때 발생한다. 다음은 왼쪽 그림은 위의 상태에서 폭발하는 구슬이 들어있는 칸을 파란색과 초록색으로 표시한 것이고, 오른쪽 그림은 구슬이 폭발한 후의 상태이다.</p>

<table class="table table-bordered td-center td-middle">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/41c500e1-e82c-440c-afcc-f351af9ea1dc/-/preview/" style="width: 300px; height: 299px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/cf990414-2eb8-4f60-bd4c-bf8dfd35665d/-/preview/" style="width: 300px; height: 299px;"></td>
		</tr>
		<tr>
			<td>구슬이 폭발하기 전</td>
			<td>구슬이 폭발한 후</td>
		</tr>
	</tbody>
</table>

<p>구슬이 폭발해 빈 칸이 생겼으니 다시 구슬이 이동한다. 구슬이 이동한 후에는 다시 구슬이 폭발하는 단계이고, 이 과정은 더 이상 폭발하는 구슬이 없을때까지 반복된다. 구슬이 폭발한 후의 상태에서 구슬이 이동하면 다음과 같다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/6fe3b9cf-b6a2-4ad1-9014-3b99852996b5/-/preview/" style="width: 300px; height: 299px;"></p>

<p>위의 상태는 4개 이상 연속하는 구슬이 있기 때문에 구슬이 다시 폭발하게 된다.</p>

<table class="table table-bordered td-center td-middle">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/5fb62a98-2cea-4c4d-9b6f-9c540b459290/-/preview/" style="width: 300px; height: 299px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/0f70b5e5-3111-4f16-a699-42638a17c540/-/preview/" style="width: 300px; height: 299px;"></td>
		</tr>
		<tr>
			<td>구슬이 폭발하기 전</td>
			<td>구슬이 폭발하고 이동한 후</td>
		</tr>
	</tbody>
</table>

<p>이제 더 이상 폭발한 구슬이 없기 때문에, 구슬이 변화하는 단계가 된다. 연속하는 구슬은 하나의 그룹이라고 한다. 다음은 1번 구슬은 빨간색, 2번 구슬은 파란색, 3번 구슬은 보라색으로 표시한 그림이다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/0d0b2e68-960c-4bb7-a950-da389183ea88/-/preview/" style="width: 300px; height: 299px;"></p>

<p>하나의 그룹은 두 개의 구슬 A와 B로 변한다. 구슬 A의 번호는 그룹에 들어있는 구슬의 개수이고, B는 그룹을 이루고 있는 구슬의 번호이다. 구슬은 다시 그룹의 순서대로 1번 칸부터 차례대로 A, B의 순서로 칸에 들어간다. 다음 그림은 구슬이 변화한 후이고, 색은 구분하기 위해 위의 그림에 있는 그룹의 색을 그대로 사용했다. 만약, 구슬이 칸의 수보다 많아 칸에 들어가지 못하는 경우 그러한 구슬은 사라진다.</p>

<p style="text-align: center;"> <img alt="" src="https://upload.acmicpc.net/c72823d6-95b2-424f-b9d8-84c423685b3d/-/preview/" style="width: 300px; height: 299px;"></p>

<p>마법사 상어는 블리자드를 총 M번 시전했다. 시전한 마법의 정보가 주어졌을 때, 1×(폭발한 1번 구슬의 개수) + 2×(폭발한 2번 구슬의 개수) + 3×(폭발한 3번 구슬의 개수)를 구해보자.</p>

### 입력 

 <p>첫째 줄에 N, M이 주어진다. 둘째 줄부터 N개의 줄에는 격자에 들어있는 구슬의 정보가 주어진다. r번째 행의 c번째 정수는 (r, c)에 들어있는 구슬의 번호를 의미한다. 어떤 칸에 구슬이 없으면 0이 주어진다. 상어가 있는 칸도 항상 0이 주어진다.</p>

<p>다음 M개의 줄에는 블리자드 마법의 방향 d<sub>i</sub>와 거리 s<sub>i</sub>가 한 줄에 하나씩 마법을 시전한 순서대로 주어진다.</p>

### 출력 

 <p>첫째 줄에 1×(폭발한 1번 구슬의 개수) + 2×(폭발한 2번 구슬의 개수) + 3×(폭발한 3번 구슬의 개수)를 출력한다.</p>

