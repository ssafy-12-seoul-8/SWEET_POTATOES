# [Gold III] 죽음의 비 - 22944 

[문제 링크](https://www.acmicpc.net/problem/22944) 

### 성능 요약

메모리: 115084 KB, 시간: 104 ms

### 분류

백트래킹, 너비 우선 탐색, 브루트포스 알고리즘, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 12일 11:48:22

### 문제 설명

<p>가로, 세로 길이가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>인 정사각형 격자가 있다. 해당 격자에는 두 곳을 제외한 모든 곳에 체력을 1씩 감소시키는 죽음의 비가 내리고 있다. 죽음의 비가 안내리는 곳은 현재 있는 위치와 안전지대라는 곳이다. 현재 있는 위치에도 곧 비가 내릴 예정이라 빨리 이 죽음의 비를 뚫고 안전지대로 이동해야한다.</p>

<p>다행히도 격자에는 죽음의 비를 잠시 막아주는 우산이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D43E TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>K</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$K$</span></mjx-container>개 존재한다. 우산에는 내구도 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D437 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>D</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$D$</span></mjx-container>라는 개념이 존재한다. 우산에 비를 맞으면 내구도가 1씩 감소하고, 내구도가 0이 되는 순간 우산은 사라진다. 문제에서 주어지는 우산의 내구도는 모두 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D437 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>D</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$D$</span></mjx-container>로 동일하다.</p>

<p>격자에서 이동을 할 때 다음과 같이 순서로 진행된다.</p>

<ol>
	<li>상하좌우로 이동한다. 만약 이동할 곳이 격자 밖이라면 이동할 수 없다. </li>
	<li>이동한 곳이 안전지대라면 반복을 종료한다.</li>
	<li>이동한 곳에 우산이 있다면 우산을 든다. 만약, 이동할 때부터 우산을 가지고 있다면 가지고 있는 우산을 버리고 새로운 우산으로 바꾼다.<br>
	버린 우산은 더 이상 사용할 수 없다.</li>
	<li>죽음의 비를 맞았을 때, 우산을 가지고 있다면 우산의 내구도가 1이 감소하고 만약 우산을 가지고 있지 않는다면 체력이 1 감소한다.</li>
	<li>만약 우산의 내구도가 0이 되면 들고 있는 우산이 사라진다.</li>
	<li>만약 체력이 0이 되면 죽는다...</li>
	<li>아직 체력이 남았다면 안전지대까지 위 과정을 반복한다.</li>
</ol>

<p>현재 있는 위치에서 안전지대로 얼마나 빠르게 이동할 수 있는지 구해주자.</p>

### 입력 

 <p>첫 번째 줄에 정사각형 격자의 한변의 길이인 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>와 현재 체력 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D43B TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>H</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$H$</span></mjx-container>, 우산의 내구도 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D437 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>D</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$D$</span></mjx-container>가 공백으로 구분되어 주어진다.</p>

<p>다음 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 줄에는 정사각형 격자의 정보가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 문자로 붙어서 주어진다. 이때 주어지는 문자는 우산은 "U", 현재 있는 위치 "S", 안전지대 "E", 빈 칸 "."만 존재한다. 현재 있는 위치 "S"와 안전지대 "E"는 반드시 1개 존재한다.</p>

### 출력 

 <p>안전지대로 이동할 때 최소 이동 횟수를 출력한다. 만약 안전지대로 이동하지 못하는 경우에는 <code>-1</code>을 출력한다.</p>

