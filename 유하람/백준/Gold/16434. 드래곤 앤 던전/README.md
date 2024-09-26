# [Gold IV] 드래곤 앤 던전 - 16434 

[문제 링크](https://www.acmicpc.net/problem/16434) 

### 성능 요약

메모리: 58444 KB, 시간: 492 ms

### 분류

이분 탐색, 구현

### 제출 일자

2024년 9월 26일 19:18:21

### 문제 설명

<p>용사는 공주를 구하기 위해 무시무시한 용이 있는 던전으로 향하기로 하였습니다. 우선 용사는 용사 자신과 던전을 분석하였습니다.</p>

<p>용사에게는 세 종류의 능력치가 있습니다. </p>

<ul>
	<li><em>H<sub>MaxHP</sub></em> : 용사의 최대 생명력입니다. 이 값은 1이상이어야 하며 던전에 들어간 이후로 변하지 않습니다.</li>
	<li><em>H<sub>CurHP</sub></em> : 현재 용사의 생명력입니다. 던전에 들어가기 전 이 값은 용사의 최대 생명력 <em>H<sub>MaxHP</sub></em>와 같습니다. 이 값은 <em>H<sub>MaxHP</sub></em>보다 커질 수 없습니다.</li>
	<li><em>H<sub>ATK</sub></em> : 용사의 공격력입니다.</li>
</ul>

<p>던전은 총 <em>N</em>개의 방으로 이루어져 있고 <em>i</em>번째 방을 통해서만 <em>i</em>+1번째 방으로 이동 할 수 있습니다. 방에는 포션이 있거나 몬스터가 있는데 몬스터가 있을 경우 몬스터를 쓰러트려야지 다음방으로 이동 할 수 있습니다. <em>N</em>번째 방에는 공주와 용이 있고, 용을 무찌르면 공주를 구할 수 있습니다.</p>

<p>몬스터가 있는 방에 올 경우 다음과 같이 전투가 진행됩니다.</p>

<ol>
	<li>용사의 공격력 <em>H<sub>ATK</sub></em>만큼 몬스터의 생명력을 깎습니다.</li>
	<li>몬스터의 생명력이 0 이하이면 전투가 종료되고 용사는 다음 방으로 이동합니다.</li>
	<li>몬스터의 공격력만큼 용사의 생명력 <em>H<sub>CurHP</sub></em>를 깎습니다.</li>
	<li>용사의 생명력이 0 이하이면 전투가 종료되고 용사는 사망합니다.</li>
	<li>다시 1부터 진행합니다.</li>
</ol>

<p>포션이 있는 방에 올 경우 포션을 마셔서 현재 용사의 생명력 <em>H<sub>CurHP</sub></em>가 일정량 회복되고 공격력 <em>H<sub>ATK</sub></em>도 일정량만큼 증가됩니다. 회복된 생명력이 최대 생명력 <em>H<sub>MaxHP</sub></em>보다 큰 경우 용사의 현재 생명력 <em>H<sub>CurHP</sub></em>가 최대 생명력 <em>H<sub>MaxHP</sub></em>와 같아집니다.</p>

<p>용사는 던전으로 향하기 전에 만반의 준비를 하고 있습니다. 용사는 수련을 하면 최대 생명력 <em>H<sub>MaxHP</sub></em>를 늘릴 수 있는데 얼마나 수련해야 할지 고민입니다.</p>

<p>용사는 <em>N</em>번 방에 있는 용을 쓰러트리기 위한 최소의 <em>H<sub>MaxHP</sub></em>를 여러분이 계산해주면 좋겠다고 합니다.</p>

### 입력 

 <p>첫 번째 줄에 방의 개수 <em>N </em>(1 ≤ <em>N<sub>  </sub></em>≤ 123,456) 과 용사의 초기 공격력 <em>H<sub>ATK</sub></em> (1 ≤ <em>H<sub>ATK  </sub></em>≤ 1,000,000) 가 주어집니다.</p>

<p><em>i</em>+1번째 줄엔 <em>i</em>번째 방의 정보를 나타내는 세개의 정수 <em>t<sub><span style="font-size: 10.8333px;">i</span></sub></em>, <em>a<sub>i</sub></em>, <em>h<sub>i</sub></em> (<em>t<sub><span style="font-size: 10.8333px;">i</span></sub></em> ∈ {1, 2}, 1 ≤ <em>a<sub>i</sub></em>, <em>h<sub>i  </sub></em>≤ 1,000,000) 가 주어집니다. </p>

<p><em>t<sub><span style="font-size: 10.8333px;">i</span></sub></em>가 1인 경우 공격력이 <em>a<sub>i</sub></em>이고 생명력이 <em>h<sub>i</sub></em>인 몬스터가 있음을 나타내고, <em>t<sub><span style="font-size: 10.8333px;">i</span></sub></em>가 2인 경우 용사의 공격력 <em>H<sub>ATK</sub></em>를 <em>a<sub>i</sub></em>만큼 증가시켜주고 용사의 현재 생명력 <em>H<sub>CurHP</sub></em>를 <em>h<sub>i</sub></em>만큼 회복시켜주는 포션이 있음을 나타냅니다.</p>

### 출력 

 <p>용사가 <em>N</em>번째 방에 있는 용을 쓰러트리기 위한 최소의 <em>H<sub>MaxHP</sub></em>를 출력합니다.</p>

