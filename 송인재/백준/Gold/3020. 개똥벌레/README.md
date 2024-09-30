# [Gold V] 개똥벌레 - 3020 

[문제 링크](https://www.acmicpc.net/problem/3020) 

### 성능 요약

메모리: 30820 KB, 시간: 268 ms

### 분류

이분 탐색, 누적 합

### 제출 일자

2024년 9월 30일 14:45:02

### 문제 설명

<p>A Japanese firefly has flown into a cave full of obstacles: stalagmites (rising from the floor) and stalactites (hanging from the ceiling). The cave is N units long (where N is even) and H units high. The first obstacle is a stalagmite after which stalactites and stalagmites alternate. </p>

<p>Here is an example cave 14 units long and 5 units high (the image corresponds to the example): </p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/c6fd496d-ccf5-4f9d-a06e-32b121fc6a82/-/preview/" style="width: 271px; height: 108px;"></p>

<p>The Japanese firefly is not the type that would fly around the obstacle, instead it will choose a single height and ram from one end of the cave to the other destroying all obstacles in its path with its mighty kung-fu moves. </p>

<p>In the previous example, choosing the 4th level from the ground has the firefly destroying eight obstacles: </p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/bfcbb94f-0e15-4ff9-b2ef-43e07c7ee503/-/preview/" style="width: 292px; height: 108px;"></p>

<p>This is not the best choice because the firefly will end up less tired if it chooses either level one or five, as that would require destroying only seven obstacles. </p>

<p>You are given the width and length of the cave and the sizes of all obstacles. </p>

<p>Write a program that determines the minimum number of obstacles the firefly needs to destroy to reach the end of the cave, and on how many distinct levels it can achieve that number. </p>

### 입력 

 <p>The first line contains two integers N and H, 2 ≤ N ≤ 200000, 2 ≤ H ≤ 500000, the length and height of the cave. N will always be even. </p>

<p>The next N lines contain the sizes of the obstacles, one per line. All sizes are positive integers less than H. </p>

### 출력 

 <p>Output two integers separated by a single space on a single line. The first number is the minimum number of obstacles the firefly has to destroy and the second is the number of levels on which that can be achieved. </p>

