# [Gold I] 용감한 아리의 동굴 대탈출 - 25173 

[문제 링크](https://www.acmicpc.net/problem/25173) 

### 성능 요약

메모리: 114972 KB, 시간: 188 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션

### 제출 일자

2025년 3월 18일 16:35:40

### 문제 설명

<p>알쿡 나라의 아리 기사는 드디어 깊은 동굴 속에 사는 전설의 보스 몬스터를 잡으러 왔다. 이후 설명에서 보스 몬스터는 편의상 보스라고 칭한다. 알쿡 나라는 무한히 큰 2차원 격자판으로 이루어져 있으며 보스가 살고 있는 동굴은 <em>N</em> x <em>M</em> 크기로 알쿡 나라 어딘가에 존재한다. 동굴 주위는 벽으로 막혀있으며, 동굴 곳곳에는 석순이 자라있다.</p>

<p>아리가 동굴에 입장하면 아리는 동굴 안의 격자판 중 한 칸에, 보스는 아리와 상하좌우 인접한 칸 중 한 칸에 위치한 상태로 전투가 시작된다. 전투 중, 아리와 보스는 각자의 현재 진행 방향으로 한 칸 이동할 수 있으며 진행 방향은 상하좌우 네 방향 중 하나이다. 전투가 시작될 때 보스의 진행 방향은 보스가 아리를 바라보고 있는 방향이며, 아리의 첫 진행 방향도 보스의 진행 방향과 동일하다. 아리와 보스 모두 동굴 벽이나 석순이 자란 칸으로 이동할 수 없으며, 둘이 동시에 한 칸에 있을 수는 없다.</p>

<p>전투는 <strong>아리의 공격 - 아리의 이동 - 보스의 공격 - 보스의 이동</strong>이 끝나기 전까지 반복된다. 어떤 과정도 다른 과정과 동시에 진행할 수 없으며, 반드시 자신의 공격이 끝나고 이동하거나, 상대의 이동이 끝나야 공격이 가능하다. 상대의 공격으로 데미지를 입을 경우 자신의 체력이 입은 데미지만큼 감소하며, 전투 중 아리와 보스 둘 중 체력이 먼저 0 보다 작거나 같게 되는 쪽이 패배하며 전투는 그 즉시 끝나게 된다. 전투 과정은 다음과 같다.</p>

<ul>
	<li>아리의 공격 차례일 때 아리는 <em>D</em>만큼의 데미지로 보스를 한 번 공격할 수 있다.</li>
	<li>아리의 이동 차례일 때 아리는 현재 진행 방향으로 한 칸 이동할 수 있다.
	<ul>
		<li>아리가 현재 진행 방향으로 이동할 수 없는 경우, 이동할 수 있는 진행 방향을 찾을 때까지 제자리에서 오른쪽으로 90도씩 회전하고 회전할 때마다 체력을 1 소모한다. 이동할 수 있는 진행 방향을 찾았을 때, 해당 방향으로 한 칸 이동한다.</li>
		<li>4번을 회전하고도 진행 방향을 찾지 못한 경우 현재 위치한 칸에서 아리의 이동 차례를 마친다.</li>
	</ul>
	</li>
	<li>보스의 공격 차례일 때 보스는 아래에서 설명하는 방법으로 석순을 하나 찾아 해당 위치에 부하 몬스터 한 마리를 소환한다. 보스는 동굴의 어떤 칸에 위치하든 동굴 안의 모든 칸은 물론이고, 동굴 밖의 모든 칸도 눈으로 확인할 수 있는 능력이 있다. 이 능력 때문에 보스는 직접 움직이지 않고 석순을 찾을 수 있으며, 석순을 발견하는 순간 찾는 과정을 멈추고 부하 몬스터를 소환한다.
	<ul>
		<li>아래와 같이, 보스는 현재 위치한 칸을 중심으로 시계 방향으로 탐색을 진행한다. 석순을 하나 발견하거나 동굴 안의 모든 칸을 확인할 때까지 정사각형의 크기를 늘려가며 탐색을 진행한다.</li>
	</ul>
	</li>
</ul>

<table align="center" border="1" cellpadding="1" cellspacing="1" class="table table-bordered" style="width: 1400px;">
	<tbody>
		<tr>
			<td style="text-align: center;">보스의 진행 방향이 ↑ 일 때</td>
			<td style="text-align: center;">보스의 진행 방향이 → 일 때</td>
			<td style="text-align: center;">보스의 진행 방향이 ↓ 일 때</td>
			<td style="text-align: center;">보스의 진행 방향이 ← 일 때</td>
		</tr>
		<tr>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/e4dd6817-6b86-46ba-aac0-09caf5be4639/" style="width: 250px; height: 259px;"></td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/f7b45904-823d-40e4-90f0-7e5932a2a666/" style="width: 265px; height: 250px;"></td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/783affa2-7eb7-45a4-85fd-6b2dd2625921/" style="width: 250px; height: 266px;"></td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/752f5a08-59e1-427b-88d8-4c2ca4c09c80/" style="width: 263px; height: 250px;"></td>
		</tr>
	</tbody>
</table>

<ul>
	<li>위의 방법으로 탐색을 진행할 때, 석순을 하나 발견하거나 동굴의 모든 칸을 확인하고도 석순을 발견하지 못한다면 보스는 그대로 자신의 공격 차례를 마친다.
	<ul>
		<li>위의 방법으로 석순을 발견했다면 발견한 석순이 위치한 칸에 보스의 공격력인 <em>E</em>만큼의 체력을 가지는 부하 몬스터를 한 마리 소환한다. 부하 몬스터는 아리에게 최단 거리로 이동하여 아리를 공격하고 사라지며, 부하 몬스터가 사라져야만 보스의 공격 차례가 끝나고 보스의 다음 이동이 가능하다.</li>
		<li>부하 몬스터는 상하좌우로 한 칸씩 이동 가능하며, 한 칸 이동할 때마다 자신의 체력을 1 소모한다. 부하 몬스터는 동굴 벽 혹은 보스나 석순이 위치한 칸으로 이동할 수 없다. 부하 몬스터가 아리가 있는 칸에 도착했을 때 남은 체력만큼 아리에게 데미지를 입히고 사라지며, 만약 아리에게 가는 도중 체력이 0이 되었거나 아리에게 도착할 수 없었다면 부하 몬스터는 데미지를 입히지 못하고 사라진다.</li>
	</ul>
	</li>
	<li>보스의 이동차례일 때 보스는 아리가 마지막으로 이동하기 전 위치한 칸으로 이동하고, 아리가 마지막으로 이동하고 난 후의 진행 방향과 같은 방향을 가진다. 만약, 아리의 마지막 이동 차례에서 아리가 이동할 수 없었다면 보스도 현재 위치한 칸에서 이동 차례를 마친다.</li>
</ul>

<p>여기까지의 설명은 <strong>“아리의 위대한 모험!”</strong> 이라는 게임에 대한 설명이었다! 아리를 플레이하는 우리는 아리가 전투에서 이길 수 있을지 판단해야 한다. 동굴의 상태를 미리 알고 있다고 할 때, 아리가 전투에서 이길 수 있을지 예측해보자.</p>

### 입력 

 <p>첫 번째 줄에 동굴의 행의 크기를 의미하는 <em>N</em>과 열의 크기를 의미하는 <em>M</em>이 주어진다.</p>

<p>두 번째 줄부터 <em>N</em>개의 줄에 대해 <em>i</em>번째 줄에는 동굴의 (<em>i</em> - 1)행의 상태를 나타내는 <em>M</em>개의 정수가 주어진다. 0보다 크거나 같고 3보다 작거나 같은 네 가지 정수로 주어지며, 1은 석순이 자란 칸, 2는 아리의 시작 위치, 3은 보스의 시작 위치를 나타내며 0은 아무것도 없는 칸을 의미한다. 아리의 시작 위치와 보스의 시작 위치는 동굴에서 딱 한 칸씩만 주어지며 보스와 아리가 상하좌우로 인접하지 않은 상태인 입력은 주어지지 않는다.</p>

<p><em>(N</em> + 2)번째 줄에 아리의 체력, 공격력을 나타내는 두 정수 <em>A</em>, <em>D</em> 와 보스의 체력, 공격력을 나타내는 두 정수 <em>B</em>, <em>E</em> 가 한 줄에 주어진다.</p>

### 출력 

 <p>첫 번째 줄에 전투에서 아리가 이길 수 있다면 "<code>VICTORY!"</code>를 출력하고, 아리가 이길 수 없다면 "<code>CAVELIFE..."</code>을 출력한다.</p>

