# [Gold IV] 가희의 수열놀이 (Small) - 17162 

[문제 링크](https://www.acmicpc.net/problem/17162) 

### 성능 요약

메모리: 103472 KB, 시간: 1440 ms

### 분류

자료 구조, 수학, 스택

### 제출 일자

2024년 1월 4일 10:06:45

### 문제 설명

<p>chogahui는 수열 <em>arr</em>을 이용해 나머지 놀이를 하고 있습니다. 조가희는 수열에 다음과 같은 연산을 할 수 있습니다.</p>

<ul>
	<li>수열 <em>arr</em>의 맨 뒤에 <em>num</em>을 추가합니다.</li>
	<li>수열 <em>arr</em>의 맨 뒤에 있는 원소를 제거합니다.</li>
</ul>

<p>chogahui가 물어보는 질문은 다음과 같습니다.</p>

<ul>
	<li>수열 <em>arr</em>의 <strong>맨 뒤</strong>에서부터 최소 몇 개의 수를 선택해야, 이들을 <em>mod</em>로 나누었을 때 나머지가 0, ... , <em>mod-1</em>인 경우가 <strong>최소 한 번 이상</strong> 나타나는가?</li>
</ul>

<p>chogahui의 질문을 해결해 주세요.</p>

### 입력 

 <p>첫 번째 줄에는 쿼리의 수를 의미하는 정수 <em>Q</em>와 나누는 정수 <em>mod</em> 가 공백으로 구분되어 주어집니다. (1 ≤ <em>Q</em> ≤ 2×10<sup>5</sup>, 1 ≤ <em>mod</em> ≤ 10<sup>2</sup>)</p>

<p>이후 <em>Q</em>개의 줄에 걸쳐서, 다음 세 종류의 쿼리 중 하나가 주어집니다. 이는 맨 앞에 오는 정수의 값 (1, 2, 3)에 따라 구분됩니다.</p>

<ul>
	<li>1 <em>num</em> : 수열 <em>arr</em>의 맨 뒤에 <em>num</em>을 추가한다. (1 ≤ <em>num</em> ≤ 2<sup>31</sup>-1)</li>
	<li>2 : 수열 <i>arr</i>의 맨 뒤에 있는 원소를 제거한다. <strong>만약 <em>arr</em>이 비어있으면 무시한다.</strong></li>
	<li>3 : chogahui가 요구하는 쿼리에 대한 값을 계산한다.</li>
</ul>

<p>처음에 수열 <em>arr</em>은 비어 있습니다.</p>

### 출력 

 <p>chogahui가 요구한 쿼리에 대한 값을 <strong>3번 쿼리</strong>가 들어올 때마다 출력합니다. 3번 쿼리는 입력에 <strong>1개 이상 존재</strong>합니다. 3번 쿼리에 대한 답이 존재하지 않는 경우에는 -1을 출력한다.</p>

