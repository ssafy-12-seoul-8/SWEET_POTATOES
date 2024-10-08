# [Gold III] 종이접기 - 20187 

[문제 링크](https://www.acmicpc.net/problem/20187) 

### 성능 요약

메모리: 13112 KB, 시간: 96 ms

### 분류

구현

### 제출 일자

2024년 10월 8일 16:56:38

### 문제 설명

<p>정사각형의 종이를 중앙선을 중심으로 접는 방법은 아래 그림에서 보인 것처럼 4가지가 있다.</p>

<ul>
	<li><code>D</code>: 가로 중심선을 중심으로 반으로 접되 윗 면이 아랫 면을 덮도록 접음</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/af51072e-06a1-4e96-9a59-02ae2cb58f62/-/preview/" style="width: 240px; height: 102px;"></p>

<ul>
	<li><code>U</code>: 가로 중심선을 중심으로 반으로 접되 아랫 면이 윗 면을 덮도록 접음</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/a0d825d8-f661-4176-8160-bbb90d106ddf/-/preview/" style="width: 222px; height: 90px;"></p>

<ul>
	<li><code>R</code>: 세로 중심선을 중심으로 반으로 접되 왼쪽 면이 오른쪽 면을 덮도록 접음</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/f6ce9eb3-d679-4618-868f-a77ff414224e/-/preview/" style="width: 164px; height: 110px;"></p>

<ul>
	<li><code>L</code>: 세로 중심선을 중심으로 반으로 접되 오른쪽 면이 왼쪽 면을 덮도록 접음</li>
</ul>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/8e984151-3f58-4526-bfb7-bfc7cfd225af/-/preview/" style="width: 159px; height: 102px;"></p>

<p>한 변의 길이가 2<sup>k</sup>인 정사각형 종이가 있을 때, 이를 세로로 k번, 가로로 k번 접으면 (접는 순서는 상관 없음) 각 변의 길이가 1인 정사각형이 된다. 아래 그림에서 보인 것처럼 각 변의 길이가 1인 정사각형의 네 귀퉁이 중 한 군데에 구멍을 낸다. 구멍의 위치는 그림에서 보인 것처럼 숫자로 표시한다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/397a6729-f3b4-4947-8068-a1e37759fb4a/-/preview/" style="width: 124px; height: 128px;"></p>

<p>구멍을 낸 후 접은 순서의 역순으로 종이를 펼치면, 종이에 2<sup>2k</sup>개의 구멍이 있게 된다. 예를 들어, 한 변의 길이가 4(= 2<sup>2</sup>)인 정사각형을 <<code>R</code>, <code>D</code>, <code>D</code>, <code>R</code>>순서대로 접은 후, 3번 위치에 구멍을 낸 다음 종이를 펼치면 아래 그림처럼 구멍이 나게 된다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/f33749e3-7332-4ed4-925b-f81cb36060b1/-/preview/" style="width: 152px; height: 153px;"></p>

<p>종이의 크기를 나타내는 정수 k, 종이를 접는 순서를 나타내는 정보, 구멍 뚫는 위치를 나타내는 정수가 주어질 때, 2<sup>k</sup> × 2<sup>k</sup> 격자에 뚫린 구멍의 위치를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 번째 줄에 k가 주어진다.</p>

<p>다음 줄에는 종이 접는 방법을 나타내는 문자가 2k개 주어지는데, 각 문자는 공백으로 구분된다. 종이를 접는 방법 <code>D</code>, <code>U</code>, <code>R</code>, <code>L</code>은 각각 해당하는 대문자 알파벳으로 주어진다.</p>

<p>다음 줄에는 구멍 뚫는 위치를 나타내는 정수 h(0 ≤ h ≤ 3) 가 주어진다.</p>

### 출력 

 <p>접힌 종이를 접은 순서의 역순으로 펼친 후 정사각형에 뚫린 구멍의 위치를 번호로 출력한다. 출력은 총 2<sup>k</sup>줄로 이루어지며 i (1 ≤ i ≤ 2<sup>k</sup>)번째 줄에는 격자의 i번 행에 뚫린 구멍의 번호를 왼쪽에서 오른쪽 순서로, 공백을 사이에 두고 출력한다.</p>

