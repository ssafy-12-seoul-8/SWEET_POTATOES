# [Platinum V] 가희와 베개 - 24338 

[문제 링크](https://www.acmicpc.net/problem/24338) 

### 성능 요약

메모리: 195956 KB, 시간: 820 ms

### 분류

너비 우선 탐색, 브루트포스 알고리즘, 자료 구조, 깊이 우선 탐색, 분리 집합, 그래프 이론, 그래프 탐색, 구현

### 제출 일자

2025년 4월 11일 09:45:07

### 문제 설명

<p>가희는 언니 방에 있는 가방과 베개 위에서 똬리를 틀고 자는 것을 좋아합니다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/8d6799f0-75d9-47f6-ab55-bcc4f430c777/-/preview/"></p>

<p style="text-align: center;"><strong>[그림 1] 언니 가방 위에 올라와서 똬리를 틀고 있는 가희</strong></p>

<p>가희는 언니 방에 언니가 있는 줄 알고 들어갔지만, 평소와 다르게 엄마 주인이 침대 위에 있었습니다. 엄마 주인은 언니 방에 들어온 가희를 내쫓고 언니의 가방과 베개 위에서 자지 못하도록 장애물과 고도 1의 나무토막 여러 개를 언니 방에 설치하였습니다.</p>

<p>엄마 주인이 언니 방을 나가고 나서야, 가희는 다시 언니 방에 들어올 수 있게 되었습니다. 그런데, 엄마 주인이 설치해 놓은 장애물과 나무토막들 때문에 가희가 좋아하는 베개와 가방으로 갈 수 없었습니다. 이곳저곳을 돌아다니다가 지친 가희는 언니 방의 좌표 (x, y)에서 오빠 주인에게 도움을 요청하였습니다. 마침 오빠 주인은 <code>?</code>로 표시된 곳에 <strong>가로 1칸, 세로 1칸을 차지하는 경사로</strong>를 설치할 수 있는 장치를 가지고 있었습니다. 가희는 이 장치를 오빠 주인에게 받아, 장치를 이용해서 <strong>경사로를 설치할 수 있는 모든 곳에 경사로를 설치</strong>한 후 베개나 가방이 있는 곳으로 이동하려고 합니다.</p>

<p>경사로가 설치된 방향이란 고도가 낮은 쪽에서 높은 쪽으로 올라가는 방향을 의미합니다. 이 방향은 북쪽을 나타내는 N, 서쪽을 나타내는 W, 동쪽을 나타내는 E, 남쪽을 나타내는 S 이렇게 4가지가 있습니다. 경사로가 설치된 방향에 따라 이동할 수 없는 방향도 있습니다. <strong>아래 그림에서 경사로가 설치되지 않은 곳은 고도가 0 또는 1인 곳입니다.</strong></p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/aa578017-369e-43ef-ae9c-6a316f81c71a/-/preview/"></p>

<p style="text-align: center;"><strong>[그림 2-1(왼), 그림 2-2(오)] 경사로가 설치된 방향과 이동할 수 없는 방향</strong></p>

<p>[그림 2-1] 처럼 W 방향이나 E 방향으로 설치된 경사로에서 위쪽, 아래쪽으로 갈 수 없고, 위쪽이나 아래쪽에서 W 방향이나 E 방향으로 설치된 경사로로 올 수 없습니다. [그림 2-2] 처럼 N 방향이나 S 방향으로 설치된 경사로에서 왼쪽, 오른쪽으로 갈 수 없고, 왼쪽이나 오른쪽에서 N 방향이나 S 방향으로 설치된 경사로로 올 수 없습니다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/cd4985da-882d-4f3c-8c10-d13172768073/-/preview/"> </p>

<p style="text-align: center;"><strong>[그림 3] 위에서 바라본 경사로의 방향</strong></p>

<p>[그림 3]은 경사로의 방향에 따라 <strong>고도가 0인 곳에서 1인 곳으로 어떻게 연결하는지</strong> 보여줍니다. 아래 [그림 4]를 보겠습니다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/8c3d19e3-0e07-4ff7-a499-be2468ac1bee/-/preview/"></p>

<p style="text-align: center;"><strong>[그림 4] W 방향으로 설치된 경사로를 측면에서 본 모습</strong></p>

<p>좌표 (1, 2)에 W 방향으로 경사로가 설치되었다고 해 보겠습니다. 이 경우, W 방향으로 설치된 경사로는 고도가 1인 (1, 1)과, 고도가 0인 (1, 3)을 이어주게 됩니다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/e0c4da19-b34c-49a0-a309-5733cd89e8c9/-/preview/"></p>

<p style="text-align: center;"><strong>[그림 5] E 방향으로 설치된 모습을 측면에서 본 모습</strong></p>

<p>반면에, 좌표 (1, 1)의 고도가 1이고, (1, 3)의 고도가 0이고, (1, 2)에 E 방향으로 경사로가 설치된 경우, 가희는 (1, 1)에서 (1, 2)로, 혹은 (1, 2)에서 (1, 3)으로 갈 수 없습니다.</p>

<p>가희는 다음 규칙을 만족하면서 이동해야 합니다. 안 그러면 무서운 엄마 주인이 가희가 언니 방에 들어왔다는 사실을 눈치챌 것입니다.</p>

<ul>
	<li>현재 가희가 있는 곳으로부터 <strong>상하좌우로 인접한 곳으로만 이동</strong>할 수 있습니다.</li>
	<li>벽이 있는 곳으로 이동할 수 없습니다.</li>
	<li><strong>고도가 다른 곳</strong>으로 이동할 때, <strong>경사로를 통해서만 이동할 수 있습니다.</strong></li>
	<li>가희는 맵 바깥으로 나갈 수 없습니다.</li>
</ul>

<p>가희는 오빠 주인이 가지고 온 장치를 이용해서 <strong>경사로를 설치할 수 있는 모든 곳에 경사로를 적절한 방향으로 설치</strong>하려고 합니다. 그렇게 해서, <strong>오빠에게 도움을 요청한 곳으로부터 베개나 가방이 있는 곳으로 갈 수 있게 하려고 합니다.</strong> 가희가 목적을 달성할 수 있게 도와주세요.</p>

### 입력 

 <p>첫 번째 줄에 언니 방의 세로 길이 <em>R</em>과 가로 길이 <em>C</em>가 공백으로 구분되어 주어집니다. <em>R</em>과 <em>C</em>는 1 이상 738 이하의 정수입니다.</p>

<p>두 번째 줄부터 <em>R</em>개의 줄에 걸쳐 길이가 <em>C</em>인 문자열이 주어집니다. <em>i</em>번째 문자열의 <em>j</em>번째 문자는 아래 6개 중 하나로 좌표 (<em>i</em>, <em>j</em>)의 언니 방의 정보를 의미합니다.</p>

<ul>
	<li><code>?</code> : 경사로를 설치할 수 있는 곳</li>
	<li><code>.</code> : 고도가 0인 곳</li>
	<li><code>1</code> : 고도가 1인 곳 (언니 방에 설치된 나무토막의 위를 의미)</li>
	<li><code>#</code> : <strong>가희가 절대로 갈 수 없는</strong> 벽</li>
	<li><code>P</code> : 베개</li>
	<li><code>B</code> : 가방</li>
</ul>

<p>그다음 줄에 가희가 오빠에게 도움을 요청한 곳의 <em>x</em>좌표와 <em>y</em>좌표가 공백으로 구분되어 주어집니다. <em>x</em>는 1 이상 <em>R </em>이하의 정수이며, <em>y</em>는 1 이상 <em>C </em>이하의 정수입니다.</p>

### 출력 

 <ul>
	<li>가희가 목적을 달성할 수 있도록 '<code>?</code>'가 표시된 모든 곳에 경사로를 설치할 수 있다면 아무것이나 출력해도 정답으로 인정됩니다.
	<ul>
		<li>'<code>?</code>'가 표시된 모든 곳에는 '<code>N</code>', '<code>W</code>', '<code>E</code>', '<code>S</code>' 중 하나가 있어야 합니다.</li>
		<li>그 외에 지역은 변형을 가하지 않아야 합니다. 예를 들어, 벽이 있던 곳에 벽을 없애서 고도를 1로 만드는 것은 허용되지 않습니다.</li>
	</ul>
	</li>
	<li>가희가 '<code>?</code>'으로 표시된 모든 곳에 어떤 방법으로 경사로를 설치해도 목적을 달성할 수 없다면 -1을 출력해 주세요.</li>
</ul>

