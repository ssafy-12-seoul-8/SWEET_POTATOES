# [Platinum V] 온풍기 안녕! - 23289 

[문제 링크](https://www.acmicpc.net/problem/23289) 

### 성능 요약

메모리: 119212 KB, 시간: 480 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2025년 3월 19일 15:26:31

### 문제 설명

<p>유난히 추운 날씨가 예상되는 이번 겨울을 대비하기 위해 구사과는 온풍기를 설치하려고 한다. 온풍기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)의 온도를 실시간으로 모니터링하는 시스템을 개발했다. (r, c)는 r행 c열을 의미한다.</p>

<p>구사과의 성능 테스트는 다음과 같은 작업이 순차적으로 이루어지며, 가장 처음에 모든 칸의 온도는 0이다. 문제의 그림에서 빈 칸은 온도가 0인 칸을 의미한다.</p>

<ol>
	<li>집에 있는 모든 온풍기에서 바람이 한 번 나옴</li>
	<li>온도가 조절됨</li>
	<li>온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소</li>
	<li><a href="/problem/13727">초콜릿을 하나 먹는다.</a></li>
	<li>조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K이상이면 테스트를 중단하고, 아니면 1부터 다시 시작한다.</li>
</ol>

<p>집에 있는 모든 온풍기에서 바람이 한 번 나오는 과정을 설명하면 다음과 같다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/52ba4824-7167-4f5b-a6b2-e3c9a6b48b6b/-/preview/" style="width: 393px; height: 350px;"></p>

<p style="text-align: center;"><그림 1></p>

<p><그림 1>은 크기가 7×8인 집에 온풍기가 (3, 1)에 설치되어 있는 상황이다. 온풍기는 바람이 나오는 방향이 있는데, 그 방향은 오른쪽, 왼쪽, 위, 아래 중 하나이다. 온풍기에서 따뜻한 바람이 한 번 나오면, 다음과 같은 영역의 온도가 칸에 적힌 값만큼 증가하게 된다. 아래 그림은 오른쪽 방향으로 바람이 나온 예시이며, 온풍기에서 바람이 나오는 방향에 따라 <그림 2>를 회전시켜서 해당하는 방향으로 바람이 나왔을 때 증가하는 온도를 구할 수 있다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/4456ba65-2cad-480b-a5dc-014e83051f4e/-/preview/" style="width: 350px; height: 497px;"></p>

<p style="text-align: center;"><그림 2></p>

<p>온풍기에서 바람이 한 번 나왔을 때, 온풍기의 바람이 나오는 방향에 있는 칸은 항상 온도가 5도 올라간다. 그 다음 이 바람은 계속 다른 칸으로 이동해 다른 칸의 온도를 위의 그림과 같이 상승시키게 된다. 어떤 칸 (x, y)에 온풍기 바람이 도착해 온도가 k (> 1)만큼 상승했다면, (x-1, y+1), (x, y+1), (x+1, y+1)의 온도도 k-1만큼 상승하게 된다. 이때 그 칸이 존재하지 않는다면, 바람은 이동하지 않는다. 온풍기에서 바람이 한 번 나왔을 때, 어떤 칸에 같은 온풍기에서 나온 바람이 여러 번 도착한다고 해도 온도는 여러번 상승하지 않는다.</p>

<p><그림 1>의 상태에서 온풍기 바람이 한 번 불었다면, 증가하는 온도의 양은 <그림 3>과 같다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/eb04f005-5e8b-4ea1-98e0-4e590185c1bd/-/preview/" style="width: 393px; height: 350px;"></p>

<p style="text-align: center;"><그림 3></p>

<p>일부 칸과 칸 사이에는 벽이 있어 온풍기 바람이 지나갈 수 없다. 바람이 오른쪽으로 불었을 때 어떤 칸 (x, y)에서 (x-1, y+1)로 바람이 이동할 수 있으려면, (x, y)와 (x-1, y) 사이에 벽이 없어야 하고, (x-1, y)와 (x-1, y+1) 사이에도 벽이 없어야 한다. (x, y)에서 (x, y+1)로 바람이 이동할 수 있으려면 (x, y)와 (x, y+1) 사이에 벽이 없어야 한다. 마지막으로 (x, y)에서 (x+1, y+1)로 바람이 이동할 수 있으려면, (x, y)와 (x+1, y), (x+1, y)와 (x+1, y+1) 사이에 벽이 없어야 한다.</p>

<p>예를 들어, (3, 4)와 (3, 5) 사이에 벽이 있는 경우 온풍기에서 바람이 한 번 나왔을 때 온도는 <그림 4>와 같이 상승한다. 벽은 빨간색으로 표시했다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/ea4e6a0c-5184-4ef8-93a9-9b6f9ad89bee/-/preview/" style="width: 393px; height: 350px;"></p>

<p style="text-align: center;"><그림 4></p>

<p>(3, 5)는 (3, 4), (2, 4), (4, 4)에서 바람이 이동할 수 없기 때문에, 온도가 상승하지 않는다.</p>

<p>만약 바람의 방향이 왼쪽인 온풍기가 (4, 7)에 있고, (3, 4)와 (3, 5) 사이에 벽, (2, 5)와 (3, 5) 사이에 벽이 있는 경우라면 온풍기에서 바람이 한 번 나왔을 때 <그림 5>와 같이 온도가 상승한다. <그림 6>은 바람의 방향이 아래인 온풍기가 (2, 5)에 있고, (4, 4)와 (4, 5) 사이, (4, 4)와 (5, 4) 사이, (4, 6)과 (5, 6) 사이에 벽이 있는 경우이다.</p>

<table class="table table-bordered td-center">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/668c276c-867f-47b1-8a2c-14978cefe477/-/preview/" style="width: 393px; height: 350px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/4cc2c9c0-a868-4ad3-aa1d-fbca37363dac/-/preview/" style="width: 393px; height: 350px;"></td>
		</tr>
		<tr>
			<td><그림 5></td>
			<td><그림 6></td>
		</tr>
	</tbody>
</table>

<p>구사과의 집에는 온풍기가 2대 이상 있을 수도 있다. 이 경우 각각의 온풍기에 의해서 상승한 온도를 모두 합한 값이 해당 칸의 상승한 온도이다.</p>

<p>예를 들어, <그림 7>은 <그림 6>과 같은 벽을 가지고 있는 집에서 바람이 방향이 위인 온풍기가 (7, 5)에 있는 경우이고, <그림 8>는 <그림 6>과 같은 벽을 가지고 있는 집에서 바람의 방향이 아래인 온풍기가 (2, 5)에 있고, 바람의 방향이 위인 온풍기가 (7, 5)에 있는 경우이다. <그림 8>는 같은 벽을 가지고 있는 집에서 <그림 6>의 온풍기와 <그림 7>의 온풍기가 동시에 설치된 상황이기 때문에, 각 칸의 상승한 온도는 두 그림의 값을 더한 값과 같다. 온풍기가 있는 칸도 다른 온풍기에 의해 온도가 상승할 수 있기 때문에, <그림 8>에서 온풍기의 위치는 표시하지 않았다.</p>

<table class="table table-bordered td-center">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/504c9f6c-ac7c-46de-bfb7-321de68b0c93/-/preview/" style="width: 393px; height: 350px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/a2067daf-e089-4ec3-8347-3587aed19026/-/preview/" style="width: 393px; height: 350px;"></td>
		</tr>
		<tr>
			<td><그림 7></td>
			<td><그림 8></td>
		</tr>
	</tbody>
</table>

<p>온도가 조절되는 과정은 다음과 같다.</p>

<p>모든 인접한 칸에 대해서, 온도가 높은 칸에서 낮은 칸으로 ⌊(두 칸의 온도의 차이)/4⌋만큼 온도가 조절된다. 온도가 높은 칸은 이 값만큼 온도가 감소하고, 낮은 칸은 온도가 상승한다. 인접한 두 칸 사이에 벽이 있는 경우에는 온도가 조절되지 않는다. 이 과정은 모든 칸에 대해서 동시에 발생한다.</p>

<p>다음은 온도 조절의 예시이다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/4a5c2637-54c5-4eb5-a8ee-a01e30552c2e/-/crop/1002x374/0,0/-/preview/" style="height: 112px; width: 300px;"></p>

<p style="text-align: center;">(1, 1)에서 (1, 2)와 (1, 3)으로 공기가 섞인다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/4a5c2637-54c5-4eb5-a8ee-a01e30552c2e/-/crop/1002x374/0,435/-/preview/" style="height: 112px; width: 300px;"></p>

<p style="text-align: center;">(2, 2)와 (3, 2) 사이에 벽이 있기 때문에, (3, 2)는 온도가 그대로 유지된다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/4a5c2637-54c5-4eb5-a8ee-a01e30552c2e/-/crop/1002x374/0,874/-/preview/" style="height: 112px; width: 300px;"></p>

<p style="text-align: center;">모든 칸에 대해서 동시에 온도의 조절이 발생한다.</p>

<p>가장 바깥쪽 칸은 1행, R행, 1열, C열에 있는 칸이다. 예를 들어, <그림 9>와 같은 경우 가장 바깥쪽 칸의 온도가 1씩 감소하면 <그림 10>과 같이 된다. 온도가 0인 칸은 온도가 감소하지 않는다.</p>

<table class="table table-bordered td-center">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/4ec03451-238c-48a6-86b4-24b06fe1b74f/-/preview/" style="width: 390px; height: 350px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/847f8d3b-d4a1-49ec-a515-7a8716b32b8d/-/preview/" style="width: 390px; height: 350px;"></td>
		</tr>
		<tr>
			<td><그림 9></td>
			<td><그림 10></td>
		</tr>
	</tbody>
</table>

<p>방의 크기와 방에 설치된 온풍기의 정보, 벽의 위치와 조사하려고 하는 칸의 위치가 주어진다. 구사과가 먹은 초콜릿의 개수를 출력한다.</p>

### 입력 

 <p>첫째 줄에 세 정수 R, C, K가 주어진다. 둘째 줄부터 R개의 줄에 방의 정보가 주어진다. i번째 줄의 j번째 정수는 (i, j)의 정보를 의미하며 다음 중 하나이다.</p>

<ul>
	<li>0: 빈 칸</li>
	<li>1: 방향이 오른쪽인 온풍기가 있음</li>
	<li>2: 방향이 왼쪽인 온풍기가 있음</li>
	<li>3: 방향이 위인 온풍기가 있음</li>
	<li>4: 방향이 아래인 온풍기가 있음</li>
	<li>5: 온도를 조사해야 하는 칸</li>
</ul>

<p>다음 줄에는 벽의 개수 W가 주어진다. 다음 W개의 줄에는 벽의 정보가 주어지며, 이 정보는 세 정수 x, y, t로 이루어져 있다. t가 0인 경우 (x, y)와 (x-1, y) 사이에 벽이 있는 것이고, 1인 경우에는 (x, y)와 (x, y+1) 사이에 벽이 있는 것이다.</p>

### 출력 

 <p>구사과가 먹는 초콜릿의 개수를 출력한다. 만약, 먹는 초콜릿의 개수가 100을 넘어가면 101을 출력한다.</p>

