# [Silver II] 나무 자르기 - 2805 

[문제 링크](https://www.acmicpc.net/problem/2805) 

### 성능 요약

메모리: 119420 KB, 시간: 468 ms

### 분류

이분 탐색, 매개 변수 탐색

### 제출 일자

2024년 9월 11일 15:38:44

### 문제 설명

<p>Lumberjack Mirko needs to chop down M metres of wood. It is an easy job for him since he has a nifty new woodcutting machine that can take down forests like wildfire. However, Mirko is only allowed to cut a single row of trees.</p>

<p>Mirko's machine works as follows: Mirko sets a height parameter H (in metres), and the machine raises a giant sawblade to that height and cuts off all tree parts higher than H (of course, trees not higher than H meters remain intact). Mirko then takes the parts that were cut off. For example, if the tree row contains trees with heights of 20, 15, 10, and 17 metres, and Mirko raises his sawblade to 15 metres, the remaining tree heights after cutting will be 15, 15, 10, and 15 metres, respectively, while Mirko will take 5 metres off the first tree and 2 metres off the fourth tree (7 metres of wood in total).</p>

<p>Mirko is ecologically minded, so he doesn't want to cut off more wood than necessary. That's why he wants to set his sawblade as high as possible. Help Mirko find the maximum integer height of the sawblade that still allows him to cut off at least M metres of wood.</p>

### 입력 

 <p>The first line of input contains two space-separated positive integers, N (the number of trees, 1 ≤ N ≤ 1 000 000) and M (Mirko's required wood amount, 1 ≤ M ≤ 2 000 000 000).</p>

<p>The second line of input contains N space-separated positive integers less than 1 000 000 000, the heights of each tree (in metres). The sum of all heights is greater than or equal to M, thus Mirko will always be able to obtain the required amount of wood.</p>

### 출력 

 <p>The first and only line of output must contain the required height setting.</p>

