# [Platinum IV] 박스 정렬 - 2834 

[문제 링크](https://www.acmicpc.net/problem/2834) 

### 성능 요약

메모리: 109412 KB, 시간: 92 ms

### 분류

애드 혹, 해 구성하기, 그리디 알고리즘, 순열 사이클 분할

### 제출 일자

2025년 2월 14일 08:55:28

### 문제 설명

<p>상근이는 박스 N개를 로봇을 이용해서 정렬하려고 한다. 박스에는 1부터 N까지 숫자가 겹치지 않게 쓰여 있고, 이 수가 오름차순을 이루도록 박스를 정렬하려고 한다.</p>

<p>상근이가 가지고 있는 로봇에 수열을 입력하면, 위치에 해당하는 박스를 교환하게 된다. 수열에는 같은 위치가 두 번 이상 주어지면 안 된다.</p>

<p>예를 들어, 박스가 지금 [4, 1, 5, 2, 3] 순서로 놓여져 있고, 로봇에 [2, 1, 3] 명령을 내렸다고 해보자. 그럼 두 번째 위치에 있는 박스를 위치 1로 옮기고, 첫 번째 박스는 위치 3으로, 세 번째 박스는 위치 2로 이동하게 된다. 박스의 순서는 [1, 5, 4, 2, 3]이 된다.</p>

<p>명령을 가장 적게 이용해서 박스를 정렬하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 박스의 수 N이 주어진다. (2 ≤ N ≤ 1000)</p>

<p>다음 줄에는 박스에 붙어있는 숫자가 순서대로 주어진다. 같은 숫자가 두 번 이상 주어지지 않는다.</p>

### 출력 

 <p>첫째 줄에 정렬하는데 사용한 명령의 수 X를 출력한다.</p>

<p>그 다음 X개 줄에는 로봇에게 내린 명령을 순서대로 출력한다. 가장 첫 숫자는 수열의 길이이며, 그 다음에 콜론(:)과 공백을 출력하고, 수열의 각 원소를 출력한다.</p>

