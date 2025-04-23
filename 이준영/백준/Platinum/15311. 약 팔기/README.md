# [Platinum V] 약 팔기 - 15311 

[문제 링크](https://www.acmicpc.net/problem/15311) 

### 성능 요약

메모리: 109544 KB, 시간: 96 ms

### 분류

애드 혹, 해 구성하기, 수학

### 제출 일자

2025년 4월 23일 19:53:08

### 문제 설명

<p>약장수 강욱이는 오늘도 약을 판다. 짬에서 나오는 Vibe로 화려한 언변을 구사하는 강욱이는 최고의 약장수이다. 하지만 이런 그에게도 고민거리가 하나 있으니...</p>

<p>동규라는 단골 손님이 있는데, 그는 매일 약을 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1$</span></mjx-container>알에서 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>100</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$100$</span></mjx-container>만알 사이의 랜덤한 자연수 개수만큼 원했다. 주문을 받은 강욱이는 약 상자에서 한 알씩 약을 세서 꺼내주곤 했는데, 그것이 답답했던 동규는 강욱이에게 매번 화를 냈던 것이다.</p>

<p>이러다 동규가 자기를 때리지 않을까 무서웠던 강욱이는 동규가 원하는 만큼의 약을 빨리 건네주기 위한 방법을 고민하기 시작했다. 그는 곧 소싯적에 공부했던 <strong>Algorithm</strong>을 이용해 다음과 같은 방법을 생각해 냈다.</p>

<p><em>'약 봉지 여러 개에 각각 적절한 수의 알약을 담아서 일렬로 늘어 놓은 뒤, 동규가 약을 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D458 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>k</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$k$</span></mjx-container>알 달라고 하면 총 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D458 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>k</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$k$</span></mjx-container>알의 약이 들어있는 어떤 연속한 구간의 약 봉지들을 한 번에 집어 주면 되겠군!'</em></p>

<p>아쉽게도, 강욱이의 약 판매대는 봉지를 일렬로 최대 2000개까지만 올려놓을 수 있다. 강욱이는 적은 수의 봉지에 알약을 적절히 담아서 동규가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>100</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$100$</span></mjx-container>만 이하의 어떤 수를 부르든 그 수에 해당하는 만큼의 약을 줄 수 있었으면 한다. 하지만 물리 공부를 하느라 <strong>Algorithm</strong> 공부를 열심히 하지 못한 강욱이는 어떻게 할지 몰라 쩔쩔매고 있다. 강욱이를 도와주자!</p>

### 입력 

 <p>첫 번째 줄에 동규의 최대 약 요구량을 나타내는 정수 N (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c3D"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo>=</mo><mn>1</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$=1\, 000\, 000$</span></mjx-container>) 이 주어진다.</p>

### 출력 

 <p>첫 번째 줄에는 필요한 약봉지의 개수 K (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D43E TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>K</mi><mo>≤</mo><mn>2</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \le K \le 2\, 000$</span></mjx-container>) 를 출력한다.</p>

<p>두 번째 줄에는 왼쪽부터 순서대로 각 약봉지에 들어있어야 하는 약의 수를 출력한다. 각 봉지에는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1$</span></mjx-container>알 이상 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>100</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$100$</span></mjx-container>만알 이하의 약이 있어야 한다.</p>

