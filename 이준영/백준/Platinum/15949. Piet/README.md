# [Platinum IV] Piet - 15949 

[문제 링크](https://www.acmicpc.net/problem/15949) 

### 성능 요약

메모리: 117852 KB, 시간: 168 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션

### 제출 일자

2025년 3월 19일 20:11:48

### 문제 설명

<p>Piet은 프로그래밍 언어의 하나로, 코드가 N×M의 2차원 이미지로 되어 있는 것이 특징이다. 이름의 유래는 추상화로 유명한 네덜란드의 화가인 피트 몬드리안(Piet Mondrian)이다. 다음의 이미지는 "Hello, world!"를 출력하는 Piet 코드이다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/f0ecbdb1-3f43-4048-99cb-42bd4a03e0b1/-/preview/"></p>

<p>Piet 프로그램에서 단위 정사각형을 코델(Codel)이라고 하며 각 코델마다 특정 색깔이 칠해져있다. 이는 비트맵 이미지의 픽셀에 대응되는 개념이다. 같은 색깔의 코델이 상하좌우로 연결된 블록이 프로그램의 최소 실행 단위가 된다. 맨 처음 실행되는 블록은 가장 왼쪽 위 코델이 포함된 블록이며, 규칙에 따라 다음에 실행될 블록으로 이동하는 과정을 반복한다.</p>

<p>현재 블록에서 어떤 블록으로 이동할지를 결정하기 위해 DP(Direction Pointer)와 CC(Codel Chooser)라는 두 가지 값이 존재한다. DP의 값은 왼쪽, 오른쪽, 위쪽, 아래쪽 중 하나이고, CC의 값은 왼쪽 혹은 오른쪽 중 하나이다. 프로그램이 처음 실행될 때 DP의 값은 오른쪽, CC의 값은 왼쪽이다. 어떤 블록으로 이동할지를 선택하는 기준은 다음과 같다.</p>

<ul>
	<li>현재 블록의 코델들 중에서 DP의 방향으로 가장 멀리 위치한 코델들을 찾는다. 블록이 볼록하지 않은 경우 이 코델들은 연속하지 않을 수 있다.</li>
	<li>위에서 찾은 코델들 중 DP 방향을 향했을 때 CC의 방향으로 가장 끝에 있는 코델을 선택한다. 이 때 CC의 방향은 상대적인 방향임에 유의하라. 예를 들어, DP가 아래쪽을 가리키고 CC가 오른쪽을 가리키는 경우, 선택되는 코델은 가장 왼쪽에 있는 코델이 된다.</li>
	<li>위에서 선택한 코델에서 DP의 방향으로 맞닿은 코델이 포함된 블록이 다음 블록이 된다.</li>
</ul>

<p>이에 대한 예시로, 다음과 같은 그림에서 어떤 블록으로 이동할지를 선택하는 과정을 살펴보자.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/48cddd99-3f7a-47ea-aeae-0befde753ffd/-/preview/"></p>

<p>각 칸에 적힌 글자는 색깔을 나타내는 값이다. 현재 블록은 A 블록이고, DP의 값(검은 화살표)은 아래쪽, CC의 값(회색 화살표)은 오른쪽인 상태이다. 이 때 A 블록의 코델들 중에서 DP의 방향으로 가장 멀리 위치한 코델은 A 블록에서 가장 아래쪽에 위치한 코델로, 그림에서 점으로 표시된 코델이다. 이 블록들 중 CC의 방향으로 가장 끝에 있는 코델은 그림에서 테두리로 표시된 블록이다. 이 코델의 아래쪽(DP의 방향)으로 맞닿은 코델(빨간색 별표)이 속한 블록인 B 블록이 다음 블록이 된다.</p>

<p>검은색 블록 혹은 이미지의 경계 바깥은 이동할 수 없는 구역이다. 만약 다음으로 이동하려는 블록이 검은색이거나 이미지의 경계를 벗어나는 경우는 다음의 방법으로 진행한다.</p>

<ol>
	<li>CC의 값이 왼쪽인 경우 오른쪽으로, 오른쪽인 경우 왼쪽으로 바꾼 후 다시 이동을 시도한다.</li>
	<li>CC의 값을 바꾼 후에도 이동할 수 없는 경우, CC의 값을 유지하며 DP를 시계방향으로 회전한 후 다시 이동을 시도한다.</li>
	<li>시계방향으로 회전한 후에도 이동할 수 없는 경우, 1번으로 되돌아간다.</li>
	<li>위 과정을 계속 반복하여 총 8가지의 경우를 모두 시도했는데도 이동할 수 있는 블록을 찾지 못한 경우, 프로그램이 종료된다.</li>
</ol>

<p>예를 들어, 다음과 같은 그림에서 어떤 블록으로 이동할지를 선택하는 과정을 살펴보자.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/b6ba1eed-9ed4-4dc5-b567-2803177e5b95/-/preview/"></p>

<p>현재 블록은 A 블록이고, DP의 방향은 위, CC의 방향은 왼쪽인 상태이다. 이번에도 경계에 위치한 코델을 점으로, CC에 의해 선택된 코델을 테두리로 표시하였다. 현재 상태에서 선택된 다음 블록은 검은색 블록이므로 이동할 수 없다. 따라서 CC의 값을 오른쪽으로 바꾼 뒤 다시 다음 블록을 찾는데, 역시 검은색 블록이므로 이동할 수 없다. 이제 DP의 방향을 시계방향으로 회전하여 오른쪽으로 바꾼 뒤 블록을 찾는다(이 때 CC의 값은 바뀌지 않는다). 선택된 코델과 맞닿은 블록은 이미지의 경계 밖이므로 CC의 값을 왼쪽으로 바꾼 뒤 다시 시도한다. 이번에는 다른 코델이 선택되지만 역시 맞닿은 블록이 이미지의 경계 밖이므로 이동할 수 없다. 다시 DP의 방향을 시계방향으로 회전하여 아래로 바꾼 뒤 블록을 찾는다. 이 때 선택된 블록은 검은색 블록으로 역시 이동할 수 없고, CC의 값을 다시 오른쪽으로 바꾸면 B 블록이 선택되고 이는 이동할 수 있는 블록이다. 따라서 다음 블록은 B 블록이 된다. 이상의 과정을 그림으로 나타내면 다음과 같다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/dddacadd-2279-4944-8a61-a991d477df7e/-/preview/"><img alt="" src="https://upload.acmicpc.net/a1b1008d-f4b9-410f-a031-6b90619ff4e3/-/preview/"><img alt="" src="https://upload.acmicpc.net/51429e25-2018-4ea4-bfa3-3c8adfd6d0b7/-/preview/"><img alt="" src="https://upload.acmicpc.net/631d0e14-d016-4c1d-8e09-3ac036d70c5e/-/preview/"><img alt="" src="https://upload.acmicpc.net/b6b01486-2f30-4d40-b9ec-d634b935e881/-/preview/"></p>

<p>Piet으로 작성된 프로그램이 주어졌을 때, 이 프로그램이 어떤 블록을 거치며 실행되는지 알고 싶어졌다. 입력된 Piet 프로그램에 대해, 프로그램이 종료할 때까지 거치는 블록의 색깔을 출력하는 프로그램을 작성하시오.</p>

<p>* 실제 Piet의 연산 중에는 픽셀의 색깔에 따라 DP 혹은 CC가 바뀌는 연산이 있지만, 이 문제에 한해서는 위에서 설명된 규칙에 의해서만 DP와 CC가 변경되는 것으로 간주한다.</p>

### 입력 

 <p>첫 번째 줄에 자연수 N과 M이 주어진다. (1 ≤ N, M ≤ 100)</p>

<p>두 번째 줄부터 N줄에 걸쳐 M개의 글자로 이루어진 문자열이 입력되며, 이는 Piet 프로그램 이미지의 각 코델을 의미한다. 각각의 글자는 알파벳 대문자로 색깔을 나타내는 값이며, X는 검은색을 의미한다. 종료되지 않는 프로그램은 입력되지 않으며, 가장 왼쪽 위 코델은 검은색이 아님이 보장된다.</p>

### 출력 

 <p>첫 번째 줄에 프로그램이 종료될 때까지 거치는 블록들의 색깔을 순서대로 출력한다.</p>

