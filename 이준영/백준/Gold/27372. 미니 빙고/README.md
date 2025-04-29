# [Gold IV] 미니 빙고 - 27372 

[문제 링크](https://www.acmicpc.net/problem/27372) 

### 성능 요약

메모리: 113220 KB, 시간: 272 ms

### 분류

백트래킹, 구현

### 제출 일자

2025년 4월 29일 16:56:25

### 문제 설명

<p>Albert는 아래와 같은 3x3 격자판에서 하는 미니 빙고를 (mini BINGO) 즐겨한다. 이 문제를 풀기 위해 BINGO가 무슨 게임인지 알 필요는 없다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/b999f7f2-3d41-42af-8ab3-a8a7563135a9/-/preview/"></p>

<p>Albert가 고안한 "미니 빙고" 놀이는 위와 같이 3x3 격자판에 서로 다른 영대문자 알파벳 9개를 적는 것으로 시작한다. 그리고 이 9개의 알파벳을 임의로 섞어서 길이 9인 문자열 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container>를 하나 고르는데 이를 seed (시드) 문자열이라 부른다.</p>

<p>시드 문자열 S에 등장하는 알파벳 순서대로 격자판의 칸을 색칠하는데, 아래 조건에 따라 해당 칸의 점수를 매긴다.</p>

<ul>
	<li>방금 색칠한 칸이 속한 열 위에 놓인 3개의 칸 모두가 색칠됐다면 1점을 추가한다.</li>
	<li>방금 색칠한 칸이 속한 행 위에 놓인 3개의 칸 모두가 색칠됐다면 1점을 추가한다.</li>
	<li>방금 색칠한 칸이 주-대각선 (위 예제에서 A, F, K) 위에 있고 주-대각선 위의 3칸 모두 색칠 됐다면 1점을 추가한다.</li>
	<li>방금 색칠한 칸이 반-대각선 (위 예제에서 C, F, I) 위에 있고 반-대각선 위의 3칸 모두 색칠 됐다면 1점을 추가한다.</li>
</ul>

<p>이 방법을 통해 얻은 각 칸의 점수는 언제나 0이상 4이하이며, 이를 시드문자열과 같은 순서대로 적어 길이가 9인 문자열을 얻을 수 있다 - 이렇게 얻은 점수 문자열을 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D447 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo stretchy="false">(</mo><mi>S</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$T(S)$</span></mjx-container>라 하자.</p>

<p>예를 들어 시드 문자열 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container> = "<code>JGFACKIEB</code>" 인 경우를 살펴보자. 아래 그림에서 상단 1열부터 5열까지, 그리고 하단 1열부터 4열까지의 격자판은 시드 문자열에 따라 알맞은 칸을 순서대로 칠한 모습을 보여준다.</p>

<ul>
	<li>처음으로 칠해지는 다섯 개의 칸은 "<code>J</code>", "<code>G</code>", "<code>F</code>", "<code>A</code>", "<code>C</code>"이며 각각 0점씩 점수를 부여한다.</li>
	<li>여섯 번째로 "<code>K</code>"를 칠한 후 주-대각선과 3열 때문에 2점의 점수를 부여한다.</li>
	<li>일곱 번째로 "<code>I</code>"를 칠한 후 3행과 반-대각선 때문에 2점의 점수를 부여한다.</li>
	<li>여덟 번째로 "<code>E</code>"를 칠한 후 1열과 2행 때문에 2점의 점수를 부여한다.</li>
	<li>마지막으로 "<code>B</code>"를 칠한 후 1행과 2열 때문에 2점의 점수를 부여한다.</li>
	<li>이리하여 최종적으로 얻게 되는 점수 문자열은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D447 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo stretchy="false">(</mo><mi>S</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$T(S)$</span></mjx-container> = "<code>000002222</code>"가 된다.</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/8854d6db-c321-47aa-9390-0b4b8086fe4e/-/preview/"></p>

<p>같은 격자판에서 시드 문자열이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container> = "<code>ABEGKCFIJ</code>" 일 때, 아래와 같은 순서로 격자를 칠하고, 이때의 점수 문자열은 "<code>000002222</code>"가 된다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/5527201e-3a8f-43e6-981e-18641434699a/-/preview/"></p>

<p>위 예제에서 보이듯 서로 다른 시드 문자열의 점수 문자열이 같을 수 있다.</p>

<p>Albert는 임의의 격자판과 임의의 시드 문자열 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container>가 있을 때 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D447 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo stretchy="false">(</mo><mi>S</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$T(S)$</span></mjx-container> 를 구하는 것이 너무 쉽다고 생각한다. 따라서 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container>의 점수 문자열을 구한 후, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container>와 같은 점수 문자열을 (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D447 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo stretchy="false">(</mo><mi>S</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$T(S)$</span></mjx-container>) 만들어내는 모든 시드 문자열 중 사전순으로 가장 앞서는 시드 문자열을 찾고 싶다. Albert를 도와주자.</p>

### 입력 

 <p>입력 첫 줄에 테스트 케이스의 수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D447 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$T$</span></mjx-container>가 주어진다.</p>

<p>각 테스트 케이스의 첫 줄에는 길이 9인 시드 문자열 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container>가 주어진다. 다음 세 줄에 걸쳐 3x3 격자판의 상태가 주어지는데 각 줄에 3개의 문자가 공백 없이 주어진다.</p>

### 출력 

 <p>각 테스트 케이스의 정답인 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D447 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo stretchy="false">(</mo><mi>S</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$T(S)$</span></mjx-container>와 해당 점수 문자열을 얻게 하는 시드 문자열 중 사전순으로 가장 앞서는 문자열을 공백으로 구분하여 각 줄에 출력한다.</p>

