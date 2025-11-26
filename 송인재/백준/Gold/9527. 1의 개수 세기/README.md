# [Gold II] 1의 개수 세기 - 9527 

[문제 링크](https://www.acmicpc.net/problem/9527) 

### 성능 요약

메모리: 14344 KB, 시간: 104 ms

### 분류

수학, 누적 합, 비트마스킹

### 제출 일자

2025년 11월 26일 19:13:43

### 문제 설명

<p>Carl is right now the happiest child in the world: he has just learned this morning what the binary  system is. He learned, for instance, that the binary representation of a positive integer k is a string a<sub>n</sub>a<sub>n−1</sub> · · · a<sub>1</sub>a<sub>0</sub> where each ai is a binary digit 0 or 1, starting with a<sub>n</sub> = 1, and such that <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D458 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c3D"></mjx-c></mjx-mo><mjx-munderover space="4" limits="false"><mjx-mo class="mjx-sop"><mjx-c class="mjx-c2211 TEX-S1"></mjx-c></mjx-mo><mjx-script style="vertical-align: -0.285em; margin-left: 0px;"><mjx-texatom size="s" texclass="ORD"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-texatom><mjx-spacer style="margin-top: 0.284em;"></mjx-spacer><mjx-texatom size="s" texclass="ORD"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c3D"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-texatom></mjx-script></mjx-munderover><mjx-texatom space="2" texclass="ORD"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D44E TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-msup space="3"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-script style="vertical-align: 0.363em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msup></mjx-texatom></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>k</mi><mo>=</mo><munderover><mo data-mjx-texclass="OP">∑</mo><mrow data-mjx-texclass="ORD"><mi>i</mi><mo>=</mo><mn>0</mn></mrow><mrow data-mjx-texclass="ORD"><mi>n</mi></mrow></munderover><mrow data-mjx-texclass="ORD"><msub><mi>a</mi><mi>i</mi></msub><mo>×</mo><msup><mn>2</mn><mi>i</mi></msup></mrow></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\(k = \sum_{i=0} ^{n} {a_i \times 2^i}\)</span></mjx-container>. It is really nice to see him turning decimal numbers into binary numbers, and then adding and even multiplying them.</p>

<p>Caesar is Carl’s older brother, and he just can’t stand to see his little brother so happy. So he has prepared a challenge: “Look Carl, I have an easy question for you: I will give you two integers A and B, and you have to tell me how many 1’s there are in the binary representation of all the integers from A to B, inclusive. Get ready”. Carl agreed to the challenge. After a few minutes, he came back with a list of the binary representation of all the integers from 1 to 100. “Caesar, I’m ready”. Caesar smiled and said: “Well, let me see, I choose A = 10<sup>15</sup> and B = 10<sup>16</sup>. Your list will not be useful”.</p>

<p>Carl hates loosing to his brother so he needs a better solution fast. Can you help him?</p>

### 입력 

 <p>A single line that contains two integers A and B (1 ≤ A ≤ B ≤ 10<sup>16</sup>).</p>

### 출력 

 <p>Output a line with an integer representing the total number of digits 1 in the binary representation of all the integers from A to B, inclusive.</p>

