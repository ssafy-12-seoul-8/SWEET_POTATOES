# [Gold V] 내진 설계 - 31863 

[문제 링크](https://www.acmicpc.net/problem/31863) 

### 성능 요약

메모리: 172760 KB, 시간: 468 ms

### 분류

그래프 이론, 그래프 탐색, 구현, 시뮬레이션

### 제출 일자

2025년 3월 17일 19:56:31

### 문제 설명

<p>오늘 새벽, 갑자기 규모 5.0 지진이 발생했다. 지진이 발생한 진원지는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>×</mo><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N \times M$</span></mjx-container> 격자 모양의 지역 중 한 곳이다. 진원지에서 발생한 지진을 본진, 건물이 무너졌을 때 발생하는 약한 지진을 여진이라고 하자. 본진은 진원지를 기준으로 상하좌우 각 방향으로 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$2$</span></mjx-container>칸까지 뻗어나가며, 여진은 상하좌우로 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1$</span></mjx-container>칸까지 뻗어나간다. 본진과 여진은 건물에 영향을 준다. 내진 설계가 되어 있지 않은 건물은 지진이 도달한 즉시 무너지지만, 내진 설계가 되어 있는 건물은 지진이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$2$</span></mjx-container>번 도달하면 무너진다. 본진과 여진이 뻗어나가는 도중 지진 방파제를 만나거나 격자 모양의 지역 밖으로 나가면 더 이상 뻗어나가지 않는다. 예제1에 대한 지진의 이동은 아래와 같다.</p>

<table class="table table-bordered td-center">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/02a8ce92-6ede-4135-954d-5d1ae1b24382/-/preview/" style="height: 280px; width: 350px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/6a017858-7fd6-4d74-879a-74bb385cc644/-/preview/" style="height: 280px; width: 350px;"></td>
		</tr>
		<tr>
			<td>(1)</td>
			<td>(2)</td>
		</tr>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/ca699ab7-5423-42ca-820e-6b93e0ab7061/-/preview/" style="height: 280px; width: 350px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/49a05ff1-9486-4994-b64e-0ea65b9c3fa9/-/preview/" style="height: 280px; width: 350px;"></td>
		</tr>
		<tr>
			<td>(3)</td>
			<td>(4)</td>
		</tr>
	</tbody>
</table>

<p>빠른 재해 복구를 위해 지진의 피해를 확인하고자 한다. 지진으로 인해 무너진 건물의 개수와 무너지지 않은 건물의 개수를 구해보자.</p>

### 입력 

 <p>첫째 줄에 정수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo stretchy="false">(</mo><mn>2</mn><mo>≤</mo><mi>N</mi><mo>≤</mo><mn>1</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N(2 \leq N \leq 1 \, 000)$</span></mjx-container>과 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi><mo stretchy="false">(</mo><mn>2</mn><mo>≤</mo><mi>M</mi><mo>≤</mo><mn>1</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M(2 \leq M \leq 1 \, 000)$</span></mjx-container>이 공백으로 구분되어 주어진다.</p>

<p>둘째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 줄에 걸쳐 길이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>의 문자열이 주어진다. 문자열을 이루는 문자는 아래 5종류이며, 진원지는 1개만 주어진다.</p>

<ul>
	<li><span style="color:#e74c3c;"><code>@</code></span>: 진원지</li>
	<li><span style="color:#e74c3c;"><code>.</code></span>: 일반 도로</li>
	<li><span style="color:#e74c3c;"><code>*</code></span>: 내진 설계가 되어있지 않은 건물</li>
	<li><span style="color:#e74c3c;"><code>#</code></span>: 내진 설계가 되어있는 건물</li>
	<li><span style="color:#e74c3c;"><code>|</code></span>: 방파제</li>
</ul>

### 출력 

 <p>무너진 건물의 개수와 무너지지 않은 건물의 개수를 공백으로 구분하여 한 줄에 출력한다.</p>

