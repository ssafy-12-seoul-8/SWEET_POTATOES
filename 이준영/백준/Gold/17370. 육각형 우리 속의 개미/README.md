# [Gold III] 육각형 우리 속의 개미 - 17370 

[문제 링크](https://www.acmicpc.net/problem/17370) 

### 성능 요약

메모리: 114484 KB, 시간: 364 ms

### 분류

백트래킹, 브루트포스 알고리즘, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 17일 08:59:37

### 문제 설명

<p>무한히 많은 정육각형이 서로 맞닿아 놓인 형태의 개미 우리가 있다. 다음 그림과 같은 형태이고, 하얀색 변으로만 개미가 다닐 수 있다.</p>

<p style="margin-top: 20px;"><img alt="img1" src="https://upload.acmicpc.net/a62eeb9c-2d2d-44f8-bc58-f475ba72e514/-/preview/" style="display: block; margin-left: auto; margin-right: auto; width: 100%; max-width: 210px;"></p>

<p style="margin-bottom: 20px; text-align: center;">개미 우리의 모습</p>

<p>곤충 관찰이 취미인 유이는 세 정육각형이 서로 맞닿아 있는 어떤 점 위에 개미를 하나 올렸다. 이렇게 우리에 올라온 개미는 그 자신에게 미지의 영역인 우리를 페로몬을 뿌리며 탐색하기 시작했다. 처음 개미는 점과 연결된 세 변 중 하나를 향해 이동을 시작하는데, 편의를 위해 이 첫 번째 이동이 북쪽을 향하도록 돌려서 보자.</p>

<p>만약 개미가 변이 세 갈래로 갈라지는 점에 도착하면, 자신이 이동해온 변을 제외한 나머지 두 변 중 하나를 골라 그 방향으로 회전하여 탐색을 계속한다.</p>

<p style="margin-top: 20px;"><img alt="img2" src="https://upload.acmicpc.net/3c98ee70-eb95-42ed-a469-9ca9e47b77db/-/preview/" style="display: block; margin-left: auto; margin-right: auto; width: 100%; max-width: 180px;"></p>

<p style="margin-bottom: 20px; text-align: center;">연두색은 시작 지점, 초록색은 개미가 탐색하며 페로몬을 뿌린 경로. 검은색은 개미, 주황색은 다음 이동을 위해 선택 가능한 두 변을 나타낸다.</p>

<p>개미가 이전에 방문했던, 즉, 페로몬이 뿌려진 지점에 도착하면 이곳이 이미 익숙한 영역이라는 착각에 빠지고 더 이상의 탐색을 멈춘다. 이렇게 탐색을 멈췄을 때, 방향을 회전한 횟수가 정확히 <em>N</em>번이 되는 경우의 수를 구해보자.</p>

<p style="margin-top: 20px;"><img alt="img3" src="https://upload.acmicpc.net/aff82ba5-e6e9-498c-80ac-04d2cc5cf6f9/-/preview/" style="display: block; margin-left: auto; margin-right: auto; width: 100%; max-width: 320px;"></p>

<p style="text-align: center;">방향을 7번 회전하는 두 경로. 페로몬의 궤적은 동일해도 개미의 이동 방향에 따라 경로를 구별하도록 한다.</p>

### 입력 

 <p>첫 번째 줄에 하나의 정수 <em>N</em>(1 ≤ <em>N</em> ≤ 22)이 주어진다.</p>

### 출력 

 <p>첫 번째 줄에 개미가 방향 회전을 <em>N</em>번 하고 멈추는 경우의 수를 출력한다.</p>

