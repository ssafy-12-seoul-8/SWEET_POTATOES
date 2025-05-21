# [Gold IV] 습격받은 도시 - 20947 

[문제 링크](https://www.acmicpc.net/problem/20947) 

### 성능 요약

메모리: 317364 KB, 시간: 1000 ms

### 분류

애드 혹, 구현

### 제출 일자

2025년 5월 21일 17:30:36

### 문제 설명

<p>극악무도한 테러리스트 주현이가 도시를 습격했다. 습격받은 도시는 세로 $N$칸, 가로 $N$칸으로 이뤄진 격자 모양이며, 각 칸은 빈칸이거나 건물이 존재한다. 주현이는 자신이 만든 수제 폭탄을 건물이 없는 곳에 설치한다. 폭탄은 터질 때 상하좌우 각 방향에 대해 충격파가 퍼져나가는데, 충격파가 닿은 건물은 파괴되어 건물 잔해가 된다. 충격파는 건물 또는 건물 잔해에 닿고 난 뒤 소멸한다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/497021c4-a031-4ab6-ab73-6b3d546a7863/-/preview/" style="width: 600px; height: 222px;"></p>

<p>이번 테러 사건 수사를 맡은 향빈이는 현장을 재구성하는 중이다. 건물 잔해의 위치를 통해 어떤 위치에서 폭탄이 터졌는지 알아내고자 한다. 아무리 생각해도 폭탄의 위치를 알아낼 수 없는 향빈이는 문제 해결의 대가인 당신을 찾아왔다. 습격받은 도시의 정보가 주어졌을 때, 주현이가 설치한 폭탄의 위치를 구해주자.</p>

### 입력 

 <p>다음과 같이 입력이 주어진다.</p>

<div style="background:#eeeeee;border:1px solid #cccccc;padding:5px 10px;">
<p>$N$</p>

<p>$\begin{matrix} a_{1,1} & a_{1,2} & \cdots & a_{1,N} \\ a_{2,1} & a_{2,2} & \cdots & a_{2,N} \\ \vdots & \vdots & \ddots & \vdots \\ a_{N,1} & a_{N,2} & \cdots & a_{N,N} \end{matrix}$</p>
</div>

### 출력 

 <p>$N$개의 줄에 도시의 정보를 출력한다. 각 줄은 $N$개의 문자를 포함하며 $i$번째 줄 $j$번째 문자는 도시의 세로 $i$번째 가로 $j$번째 칸에 대한 정보이다. 빈칸일 경우 <span style="color:#e74c3c;"><code>.</code></span>, 건물일 경우 <span style="color:#e74c3c;"><code>O</code></span>, 건물 잔해일 경우 <span style="color:#e74c3c;"><code>X</code></span>, 폭탄이 설치된 칸인 경우 <span style="color:#e74c3c;"><code>B</code></span>이다. 답이 여러 가지인 경우, 아무거나 출력한다.</p>

