# [Gold V] 학부 연구생 민상 - 21922 

[문제 링크](https://www.acmicpc.net/problem/21922) 

### 성능 요약

메모리: 221496 KB, 시간: 1672 ms

### 분류

그래프 이론, 그래프 탐색, 구현, 시뮬레이션

### 제출 일자

2025년 2월 12일 17:13:12

### 문제 설명

<p>학부 연구생으로 새로 연구실에 들어온 민상이는 사용할 자리를 정하려고 한다.</p>

<p>연구실은 격자 모양으로 되어있고 에어컨에서 바람이 상,하,좌,우 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c34"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>4</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$4$</span></mjx-container>방향으로 분다. 물론 에어컨이 위치한 곳에도 바람이 분다.</p>

<p>민상이는 더위를 많이 타서 에어컨 바람이 지나가는 곳 중 하나를 선택하여 앉으려고 한다.</p>

<p>연구실에는 다양한 물건들이 있어 바람의 방향을 바꾼다.</p>

<p>연구실에 있는 물건의 종류는 총 4가지가 있다. 아래 화살표의 의미는 바람이 각 물건에서 바람의 이동을 표시한 것이다.</p>

<table class="table table-bordered">
	<tbody>
		<tr>
			<td style="text-align: center;">물건 종류</td>
			<td style="text-align: center;">물건 모양</td>
			<td style="text-align: center;">바람의 이동 방향</td>
		</tr>
		<tr>
			<td style="text-align: center;">물건 1</td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/fc51a710-aba3-495e-9633-7f2f99a05311/-/crop/743x727/586,188/-/preview/" style="height: 165px; width: 169px;"></td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/a17fba2d-62cb-436f-b832-8d7215d52ea2/-/crop/542x380/689,350/-/preview/" style="height: 140px; width: 200px;"></td>
		</tr>
		<tr>
			<td style="text-align: center;">물건 2</td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/50cf291b-eee5-48f1-98e3-44cfd9bf8bb0/-/crop/712x666/604,208/-/preview/" style="height: 158px; width: 169px;"><br>
			 </td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/a8e6d8d9-f329-404e-882e-28c916757cdf/-/crop/357x453/785,317/-/preview/" style="width: 158px; height: 200px;"></td>
		</tr>
		<tr>
			<td style="text-align: center;">물건 3</td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/a182264f-02ee-4881-941f-fd9888dd1282/-/crop/821x1080/551,0/-/preview/" style="height: 185px; width: 141px;"></td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/c0be3b8b-3c46-4fd5-97de-1702b9bac229/-/crop/695x820/614,125/-/preview/" style="height: 236px; width: 200px;"></td>
		</tr>
		<tr>
			<td style="text-align: center;">물건 4</td>
			<td style="text-align: center;">
			<p><img alt="" src="https://upload.acmicpc.net/9de8a3b6-6d09-4298-98a6-da28a4fd6e30/-/crop/712x1080/599,0/-/preview/" style="height: 185px; width: 122px;"></p>
			</td>
			<td style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/55a653da-8200-4d00-9d2a-9d698d4794a0/-/crop/821x691/551,198/-/preview/" style="width: 250px; height: 210px;"></td>
		</tr>
	</tbody>
</table>

<p>연구실 어디든 민상이가 앉을 수 있는 자리이다. 즉 에어컨이 위치한 자리와 물건이 있는 자리 모두 앉을 수 있다.</p>

<p>민상이가 원하는 자리는 몇 개 있는지 계산해주자.</p>

### 입력 

 <p>첫 번째 줄에는 연구실의 크기가 세로 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="2"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo stretchy="false">(</mo><mn>1</mn><mo>≤</mo><mi>N</mi><mo>≤</mo><mn>2</mn><mo>,</mo><mn>000</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N(1 \le N \le 2,000)$</span></mjx-container>, 가로 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="2"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi><mo stretchy="false">(</mo><mn>1</mn><mo>≤</mo><mi>M</mi><mo>≤</mo><mn>2</mn><mo>,</mo><mn>000</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M(1 \le M \le 2,000)$</span></mjx-container> 순으로 주어진다.</p>

<p>두 번째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>+</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N + 1$</span></mjx-container> 줄까지 연구실 내부 구조 정보를 알려주는 값 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>개가 주어진다.</p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="2"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="2"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="2"><mjx-c class="mjx-c34"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>,</mo><mn>2</mn><mo>,</mo><mn>3</mn><mo>,</mo><mn>4</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1,2,3,4$</span></mjx-container>는 위에서 설명한 물건의 종류이다.</p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c39"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>9</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$9$</span></mjx-container>는 에어컨을 의미하고, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>은 빈 공간을 의미한다.</p>

<p>에어컨은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>개 이상 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c35"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>50</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$50$</span></mjx-container>개 이하가 들어온다.</p>

### 출력 

 <p>민상이가 원하는 자리의 개수를 출력한다.</p>

